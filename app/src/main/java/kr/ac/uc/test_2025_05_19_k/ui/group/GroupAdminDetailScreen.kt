// app/src/main/java/kr/ac/uc/test_2025_05_19_k/ui/group/GroupAdminDetailScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.group

import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto
import kr.ac.uc.test_2025_05_19_k.viewmodel.GroupAdminDetailViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.ui.text.font.FontWeight

// 탭 제목 리스트
private val adminDetailTabs = listOf("공지 사항", "멤버", "그룹 목표", "채팅", "모임")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupAdminDetailScreen(
    navController: NavController,
    groupId: Long,
    viewModel: GroupAdminDetailViewModel = hiltViewModel()
) {
    val groupDetail by viewModel.groupDetail.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    var selectedTabIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(selectedTabIndex) {
        when (selectedTabIndex) {
            0 -> viewModel.fetchNoticesFirstPage()
            // TODO: 다른 탭 선택 시 해당 데이터 로드 함수 호출
            1 -> Log.d("AdminDetail", "멤버 탭 선택됨")
            2 -> Log.d("AdminDetail", "그룹 목표 탭 선택됨")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(groupDetail?.title ?: if (isLoading) "로딩 중..." else "그룹 관리") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "뒤로가기")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                adminDetailTabs.forEachIndexed { index, title ->
                    FilterChip(
                        selected = (selectedTabIndex == index),
                        onClick = { selectedTabIndex = index },
                        label = { Text(title) },
                        // Add the enabled parameter here
                        enabled = true, // Or some other logic if needed
                        shape = RoundedCornerShape(50),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color.Black,
                            selectedLabelColor = Color.White,
                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                            labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        border = null
                    )
                }
            }

            // 선택된 탭에 따라 다른 관리 기능 화면 표시
            when (selectedTabIndex) {
                0 -> {
                    // ViewModel로부터 공지사항 관련 상태 구독
                    val notices by viewModel.groupNotices.collectAsState()
                    val isLoadingNotices by viewModel.isLoadingNotices.collectAsState()
                    AdminNoticesScreen(
                        navController = navController,
                        groupId = groupId,
                        notices = notices,
                        isLoading = isLoadingNotices
                    )
                }
            }
        }
    }
}

@Composable
fun AdminNoticesScreen(
    navController: NavController,
    groupId: Long,
    notices: List<GroupNoticeDto>,
    isLoading: Boolean
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (isLoading && notices.isEmpty()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (notices.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("등록된 공지사항이 없습니다.", style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items = notices, key = { it.noticeId }) { notice ->
                    AdminNoticeCard(
                        notice = notice,
                        onEdit = { /* TODO: 수정 화면으로 이동 */ },
                        onDelete = { /* TODO: 삭제 확인 다이얼로그 표시 */ }
                    )
                }
            }
        }

        // 공지사항 작성 FAB
        FloatingActionButton(
            onClick = {
                // 공지사항 작성 화면으로 이동
                navController.navigate("notice_create/$groupId")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "공지사항 작성")
        }
    }
}

// 공지사항 카드 Composable
@Composable
fun AdminNoticeCard(
    notice: GroupNoticeDto,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(notice.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "작성자: ${notice.creatorName}  •  ${notice.createdAt.take(10)}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text(notice.content, style = MaterialTheme.typography.bodyMedium)

            // 수정/삭제 버튼
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onEdit) { Text("수정") }
                TextButton(onClick = onDelete, colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)) { Text("삭제") }
            }
        }
    }
}



// 각 탭별 관리 화면 플레이스홀더 (이전과 동일)
@Composable
fun AdminNoticesScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("공지사항 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun AdminMembersScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("멤버 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun AdminGoalsScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("그룹 목표 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun AdminChatScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("채팅 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun AdminMeetingsScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("모임 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
    }
}