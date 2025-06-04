// mo-gag-gong/frontend/frontend-dev-hj/app/src/main/java/kr/ac/uc/test_2025_05_19_k/ui/group/detail/GroupDetailScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.group.detail

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.ac.uc.test_2025_05_19_k.viewmodel.GroupDetailViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.graphics.Color

@Composable
fun GroupDetailScreen(
    groupId: Long,
    viewModel: GroupDetailViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val groupDetail by viewModel.groupDetail.collectAsState()
    val applySuccess by viewModel.applySuccess.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadGroupDetail(groupId)
    }

    applySuccess?.let {
        if (it) {
            Toast.makeText(context, "가입 신청 완료", Toast.LENGTH_SHORT).show()
            viewModel.resetApplyStatus()
        } else {
            Toast.makeText(context, "가입 신청 실패", Toast.LENGTH_SHORT).show()
            viewModel.resetApplyStatus()
        }
    }

    groupDetail?.let { group ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp) // 카드 간 간격 추가
        ) {
            item {
                // 스터디 제목
                Text(
                    text = group.title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
            item {
                // 위치 (작게)
                Text(
                    text = group.locationName,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            item {
                // 스터디 그룹 소개 문구
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "스터디 그룹 소개",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = group.description,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            item {
                // 가입 요구 사항
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "가입 요구 사항",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = group.requirements,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            item {
                // 관심사 및 인원
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "관심사: ${group.interestName}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "인원: ${group.currentMembers}/${group.maxMembers}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                if (group.alreadyApplied) {
                    Text(
                        text = "가입 신청 완료",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                } else {
                    Button(
                        onClick = { viewModel.applyToGroup(group.groupId) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("가입 신청")
                    }
                }
            }
        }
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}