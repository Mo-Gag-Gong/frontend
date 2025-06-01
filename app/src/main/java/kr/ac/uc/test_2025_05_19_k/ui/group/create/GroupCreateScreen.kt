package kr.ac.uc.test_2025_05_19_k.ui.group.create

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.* // Material 2 사용 중 (OutlinedTextField, Button 등)
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.ac.uc.test_2025_05_19_k.viewmodel.GroupCreateViewModel

@OptIn(ExperimentalMaterialApi::class) // ExposedDropdownMenuBox 사용을 위해 유지
@Composable
fun GroupCreateScreen(
    navController: NavController,
    viewModel: GroupCreateViewModel = hiltViewModel()
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var requirements by remember { mutableStateOf("") } // ViewModel의 createGroup 파라미터는 String? 이므로, 여기서 "" (non-null)로 전달해도 괜찮음
    var categoryExpanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("선택") } // 실제로는 관심사(interest) 이름
    var maxMembers by remember { mutableStateOf("") }

    // startDate와 endDate를 위한 상태 변수 추가
    var startDate by remember { mutableStateOf("") } // 예: "YYYY-MM-DD" 형식으로 입력 가정
    var endDate by remember { mutableStateOf("") }   // 예: "YYYY-MM-DD" 형식으로 입력 가정

    // 카테고리 목록: 실제로는 API에서 가져오는 것이 이상적입니다.
    // GET /api/users/interests -> List<InterestDto> 를 HomeViewModel이나 별도 ViewModel에서 관리하고 전달받는 방식 고려
    val categories = listOf("취업", "자격증", "알고리즘", "자율") // 현재는 하드코딩 유지

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) { // 스크롤 가능하게 하려면 .verticalScroll(rememberScrollState()) 추가
        OutlinedTextField(
            value = title,
            onValueChange = { if (it.length <= 20) title = it },
            label = { Text("그룹명 (최대 20자)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { if (it.length <= 500) description = it },
            label = { Text("소개 문구 (최대 500자)") },
            modifier = Modifier.fillMaxWidth().height(100.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = requirements,
            onValueChange = { if (it.length <= 500) requirements = it },
            label = { Text("가입 요구사항 (최대 500자)") },
            modifier = Modifier.fillMaxWidth().height(100.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 카테고리 (관심사) 선택
        ExposedDropdownMenuBox(
            expanded = categoryExpanded,
            onExpandedChange = { categoryExpanded = !categoryExpanded }
        ) {
            OutlinedTextField(
                value = selectedCategory,
                onValueChange = {},
                readOnly = true,
                label = { Text("카테고리 (관심사)") }, // 레이블 명칭 변경 고려
                trailingIcon = { Icon(Icons.Filled.ArrowDropDown, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = categoryExpanded,
                onDismissRequest = { categoryExpanded = false }
            ) {
                categories.forEach { cat ->
                    DropdownMenuItem(onClick = {
                        selectedCategory = cat
                        categoryExpanded = false
                    }) {
                        Text(cat)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 시작 날짜 입력 필드 추가
        OutlinedTextField(
            value = startDate,
            onValueChange = { startDate = it }, // 간단한 문자열 입력, 실제로는 DatePicker 사용 권장
            label = { Text("시작 날짜 (예: YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 종료 날짜 입력 필드 추가
        OutlinedTextField(
            value = endDate,
            onValueChange = { endDate = it }, // 간단한 문자열 입력, 실제로는 DatePicker 사용 권장
            label = { Text("종료 날짜 (예: YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = maxMembers,
            onValueChange = { if (it.all { ch -> ch.isDigit() } && it.length <= 2) maxMembers = it },
            label = { Text("최대 인원 (숫자 2~99)") }, // 유효 범위 명시
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val members = maxMembers.toIntOrNull()
                // 날짜 유효성 검사 등 추가 필요
                if (title.isNotBlank() &&
                    description.isNotBlank() && // 소개 문구도 필수 입력으로 가정 (필요에 따라 조건 변경)
                    selectedCategory != "선택" &&
                    members != null && members in 2..99 &&
                    startDate.isNotBlank() && // 시작 날짜 필수 입력 가정
                    endDate.isNotBlank()       // 종료 날짜 필수 입력 가정
                ) {
                    viewModel.createGroup(
                        title = title,
                        description = description,
                        requirements = requirements, // ViewModel에서 String?으로 받음
                        interest = selectedCategory,   // 'category'에서 'interest'로 변경된 파라미터명으로 전달
                        maxMembers = members,
                        startDate = startDate,         // 추가된 파라미터 전달
                        endDate = endDate,           // 추가된 파라미터 전달
                        onSuccess = { navController.popBackStack() },
                        onError = { error ->
                            Log.e("GroupCreateScreen", "그룹 생성 실패: $error")
                            // 사용자에게 오류 메시지를 보여주는 UI 처리 (예: Toast, Snackbar) 추가 권장
                        }
                    )
                } else {
                    Log.w("GroupCreateScreen", "입력 값 유효성 검사 실패")
                    // 사용자에게 유효성 검사 실패 메시지 표시 권장
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("그룹 생성")
        }
    }
}