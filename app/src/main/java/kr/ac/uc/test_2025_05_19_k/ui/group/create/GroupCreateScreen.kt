package kr.ac.uc.test_2025_05_19_k.ui.group.create

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.ac.uc.test_2025_05_19_k.viewmodel.GroupCreateViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GroupCreateScreen(
    navController: NavController,
    viewModel: GroupCreateViewModel = hiltViewModel()
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var requirements by remember { mutableStateOf("") }
    var categoryExpanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("선택") }
    var maxMembers by remember { mutableStateOf("") }

    val categories = listOf("취업", "자격증", "알고리즘", "자율")

    Column(modifier = Modifier.padding(16.dp)) {
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

        ExposedDropdownMenuBox(
            expanded = categoryExpanded,
            onExpandedChange = { categoryExpanded = !categoryExpanded }
        ) {
            OutlinedTextField(
                value = selectedCategory,
                onValueChange = {},
                readOnly = true,
                label = { Text("카테고리") },
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

        OutlinedTextField(
            value = maxMembers,
            onValueChange = { if (it.all { ch -> ch.isDigit() } && it.length <= 2) maxMembers = it },
            label = { Text("최대 인원 (숫자)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val members = maxMembers.toIntOrNull() ?: 0
                if (
                    title.isNotBlank() && selectedCategory != "선택" && members in 2..99
                ) {
                    viewModel.createGroup(
                        title = title,
                        description = description,
                        requirements = requirements,
                        category = selectedCategory,
                        maxMembers = members,
                        onSuccess = { navController.popBackStack() },
                        onError = { error ->
                            Log.e("GroupCreateScreen", "그룹 생성 실패: $error")
                        }
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("그룹 생성")
        }
    }
}

annotation class GroupCreateScreen
