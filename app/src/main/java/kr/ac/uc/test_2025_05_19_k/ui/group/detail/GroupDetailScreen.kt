package kr.ac.uc.test_2025_05_19_k.ui.group.detail

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail
import kr.ac.uc.test_2025_05_19_k.viewmodel.GroupDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupDetailScreen(
    navController: NavController,
    groupId: Long,
    viewModel: GroupDetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val isLoadingDetail by viewModel.isLoadingDetail.collectAsState()
    val groupDetail by viewModel.groupDetail.collectAsState()
    val detailErrorMessage by viewModel.detailErrorMessage.collectAsState()
    val applySuccess by viewModel.applySuccess.collectAsState()

    // 가입 신청 결과 토스트 노출
    applySuccess?.let {
        Toast.makeText(context, if (it) "가입 신청 완료" else "가입 신청 실패 또는 이미 처리됨", Toast.LENGTH_SHORT).show()
        viewModel.resetApplyStatus()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(groupDetail?.title ?: if (isLoadingDetail) "로딩 중..." else "그룹 정보") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "뒤로가기")
                    }
                }
            )
        }
    ) { paddingValues ->
        when {
            isLoadingDetail -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            detailErrorMessage != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = detailErrorMessage!!,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center
                    )
                }
            }
            groupDetail == null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("해당 그룹 정보를 찾을 수 없습니다.", textAlign = TextAlign.Center)
                }
            }
            else -> {
                GroupDetailContent(
                    modifier = Modifier.padding(paddingValues),
                    detail = groupDetail!!,
                    onApplyToGroup = { viewModel.applyToGroup() }
                )
            }
        }
    }
}

/**
 * 그룹 상세 정보 화면 (공지/관리자 영역 없이 스터디 소개, 요구 사항, 인원/관심사/가입 신청만 표시)
 */
@Composable
fun GroupDetailContent(
    modifier: Modifier = Modifier,
    detail: StudyGroupDetail,
    onApplyToGroup: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(detail.title, style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(bottom = 4.dp))
        Text(
            detail.locationName,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("스터디 그룹 소개", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 4.dp))
                Text(text = detail.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("가입 요구 사항", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 4.dp))
                Text(text = detail.requirements, style = MaterialTheme.typography.bodyMedium)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("관심사: ${detail.interestName}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
            Text("인원: ${detail.currentMembers}/${detail.maxMembers}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.secondary)
        }

        Spacer(modifier = Modifier.weight(1f))

        if (detail.alreadyApplied) {
            Text(
                text = "가입 신청 완료",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )
        } else {
            Button(
                onClick = onApplyToGroup,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                enabled = detail.currentMembers < detail.maxMembers // 정원 미만일 때만 버튼 활성화
            ) {
                Text("가입 신청")
            }
        }
    }
}
