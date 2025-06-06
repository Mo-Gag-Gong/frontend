// app/src/main/java/kr/ac/uc/test_2025_05_19_k/ui/group/GroupAdminDetailScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.group

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
// import androidx.hilt.navigation.compose.hiltViewModel // ViewModel 연결 시 필요

// 탭 제목 정의 (GroupAdminDetailScreen 내부용)
private val adminDetailTabs = listOf("공지 사항", "멤버", "그룹 목표", "채팅", "모임")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupAdminDetailScreen(
    navController: NavController,
    groupId: Long
    // viewModel: GroupAdminDetailViewModel = hiltViewModel() // 추후 ViewModel 연결
) {
    // TODO: ViewModel에서 그룹 이름 등 상세 정보 로드 필요
    val groupName = "영어 회화 스터디" // 임시 그룹 이름
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(groupName) }, // ViewModel에서 실제 그룹 이름 가져와야 함
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "뒤로가기")
                    }
                }
                // actions = { // 필요시 편집 버튼 등 추가 가능
                //     IconButton(onClick = { navController.navigate("group_edit/$groupId") }) {
                //         Icon(Icons.Filled.Edit, "그룹 정보 수정")
                //     }
                // }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            PrimaryTabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth()
            ) {
                adminDetailTabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title, style = MaterialTheme.typography.titleSmall) }
                    )
                }
            }

            // 선택된 탭에 따라 다른 관리 기능 화면 표시
            when (selectedTabIndex) {
                0 -> AdminNoticesScreen(navController, groupId)
                1 -> AdminMembersScreen(navController, groupId)
                2 -> AdminGoalsScreen(navController, groupId)
                3 -> AdminChatScreen(navController, groupId)
                4 -> AdminMeetingsScreen(navController, groupId)
            }
        }
    }
}

// 각 탭별 관리 화면 플레이스홀더
@Composable
fun AdminNoticesScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("공지사항 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
        // TODO: 공지사항 목록, 작성, 수정, 삭제 UI 구현
    }
}

@Composable
fun AdminMembersScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("멤버 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
        // TODO: 멤버 목록, 신청자 관리, 추방 UI 구현
    }
}

@Composable
fun AdminGoalsScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("그룹 목표 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
        // TODO: 그룹 목표 목록, 추가, 수정, 삭제 UI 구현
    }
}

@Composable
fun AdminChatScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("채팅 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
        // TODO: 그룹 채팅 내용 표시 (관리는 주로 사용자 레벨에서 이루어지므로, 여기서는 보기 위주일 수 있음)
    }
}

@Composable
fun AdminMeetingsScreen(navController: NavController, groupId: Long) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("모임 관리 화면 (그룹 ID: $groupId)", style = MaterialTheme.typography.headlineSmall)
        // TODO: 모임 목록, 추가, 수정, 삭제, 출석 관리 UI 구현
    }
}