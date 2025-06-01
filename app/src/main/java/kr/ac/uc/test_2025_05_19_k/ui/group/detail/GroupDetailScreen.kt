package kr.ac.uc.test_2025_05_19_k.ui.group.detail

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel // Hilt ViewModel 사용 시 import
import androidx.lifecycle.viewmodel.compose.viewModel // 기본 viewModel 사용 시
import kr.ac.uc.test_2025_05_19_k.model.group.StudyGroupResponseDto // 새로운 DTO import
import kr.ac.uc.test_2025_05_19_k.viewmodel.GroupDetailViewModel

@Composable
fun GroupDetailScreen(
    groupId: Long,
    // ViewModel 주입 방식에 따라 hiltViewModel() 또는 viewModel() 사용
    // GroupDetailViewModel 클래스에 @HiltViewModel 어노테이션이 있다면 hiltViewModel() 사용
    viewModel: GroupDetailViewModel = hiltViewModel(),
    onBack: () -> Unit // 뒤로가기 액션
) {
    val context = LocalContext.current
    val groupDetail by viewModel.groupDetail.collectAsState()
    val applySuccess by viewModel.applySuccess.collectAsState()
    val isAlreadyApplied by viewModel.isAlreadyApplied.collectAsState() // ViewModel에서 추가한 상태 사용

    LaunchedEffect(Unit) {
        viewModel.loadGroupDetail(groupId)
        // 사용자의 가입 상태를 확인하는 로직이 ViewModel에 있다면 여기서 호출
        // 예: viewModel.checkApplicationStatus(groupId)
    }

    LaunchedEffect(applySuccess) { // applySuccess 상태가 변경될 때마다 실행
        applySuccess?.let {
            if (it) {
                Toast.makeText(context, "가입 신청 완료", Toast.LENGTH_SHORT).show()
                // 성공 시, 상세 정보를 다시 로드하거나 isAlreadyApplied 상태를 true로 변경한 것을
                // ViewModel 내부에서 이미 처리했을 것이므로 여기서는 reset만 호출
            } else {
                Toast.makeText(context, "가입 신청 실패", Toast.LENGTH_SHORT).show()
            }
            viewModel.resetApplyStatus() // Toast를 보여준 후 상태를 리셋
        }
    }

    groupDetail?.let { group ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // 그룹명 (title 필드 사용)
            Text(text = group.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))

            // 스터디 그룹 소개
            Text(text = "스터디 그룹 소개", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(text = group.description)
            Spacer(modifier = Modifier.height(16.dp))

            // 카테고리(관심사) 및 인원 정보
            Row {
                Text(
                    text = "#${group.interestName}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "${group.currentMembers} / ${group.maxMembers} 명",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            // 위치 정보 (locationName 필드가 DTO에 있다면)
            if (group.locationName.isNotBlank()) { // locationName이 nullable일 경우 group.locationName?.isNotBlank() == true
                Text(text = "위치", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(text = group.locationName)
                Spacer(modifier = Modifier.height(16.dp))
            }

            // 가입 요구 사항 (requirements 필드가 DTO에 있다면)
            if (group.requirements.isNotBlank()) { // requirements가 nullable일 경우 group.requirements?.isNotBlank() == true
                Text(text = "가입 요구 사항", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(text = group.requirements)
                Spacer(modifier = Modifier.height(16.dp))
            }

            // 시작일, 종료일 (DTO에 startDate, endDate 필드가 있다면)
            Text(text = "스터디 기간", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(text = "${group.startDate} ~ ${group.endDate}")
            Spacer(modifier = Modifier.height(24.dp))


            // 가입 신청 버튼 또는 상태 표시
            // viewModel의 isAlreadyApplied 상태를 사용
            if (isAlreadyApplied) {
                Text(
                    text = "가입 신청 완료",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            } else {
                Button(
                    onClick = { viewModel.applyToGroup(group.groupId) }, // group.id 대신 group.groupId 사용
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("가입 신청", color = Color.White)
                }
            }
        }
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
