// app/src/main/java/kr/ac/uc/test_2025_05_19_k/ui/group/GroupManagementScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.group

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // LazyColumn의 items 임포트
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect // LaunchedEffect 임포트
import androidx.compose.runtime.collectAsState // collectAsState 임포트
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel // hiltViewModel 임포트
import androidx.navigation.NavController
import kr.ac.uc.test_2025_05_19_k.model.StudyGroup // StudyGroup 임포트
import kr.ac.uc.test_2025_05_19_k.ui.common.GroupCard // GroupCard 임포트
import kr.ac.uc.test_2025_05_19_k.viewmodel.GroupManagementViewModel // ViewModel 임포트

// 탭 제목 정의
private val tabs = listOf("참여한 그룹", "만든 그룹")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupManagementScreen(
    navController: NavController,
    viewModel: GroupManagementViewModel = hiltViewModel() // ViewModel 주입
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    // 선택된 탭에 따라 ViewModel의 해당 데이터 로드 함수 호출
    LaunchedEffect(selectedTabIndex) {
        when (selectedTabIndex) {
            0 -> viewModel.fetchMyJoinedGroups()
            1 -> viewModel.fetchMyOwnedGroups()
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        PrimaryTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = title, style = MaterialTheme.typography.titleSmall) },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        when (selectedTabIndex) {
            0 -> {
                val joinedGroups by viewModel.joinedGroups.collectAsState()
                val isLoading by viewModel.isLoadingJoined.collectAsState()
                val errorMessage by viewModel.errorMessage.collectAsState() // 오류 메시지 관찰
                GroupListContent(
                    groups = joinedGroups,
                    isLoading = isLoading,
                    errorMessage = errorMessage, // 오류 메시지 전달
                    navController = navController,
                    emptyListMessage = "참여한 스터디 그룹이 없습니다."
                )
            }
            1 -> {
                val ownedGroups by viewModel.ownedGroups.collectAsState()
                val isLoading by viewModel.isLoadingOwned.collectAsState()
                val errorMessage by viewModel.errorMessage.collectAsState() // 오류 메시지 관찰
                GroupListContent(
                    groups = ownedGroups,
                    isLoading = isLoading,
                    errorMessage = errorMessage, // 오류 메시지 전달
                    navController = navController,
                    emptyListMessage = "만든 스터디 그룹이 없습니다."
                )
            }
        }
    }
}

/**
 * 스터디 그룹 목록을 표시하는 공통 Composable 함수
 */
@Composable
fun GroupListContent(
    groups: List<StudyGroup>,
    isLoading: Boolean,
    errorMessage: String?,
    navController: NavController,
    emptyListMessage: String
) {
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (errorMessage != null) { // 오류 메시지 표시
        Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
            Text(text = errorMessage, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.error)
        }
    } else if (groups.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
            Text(text = emptyListMessage, style = MaterialTheme.typography.bodyLarge)
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp), // 상단 패딩 추가
            verticalArrangement = Arrangement.spacedBy(8.dp) // 카드 간 간격
        ) {
            items(items = groups, key = { group -> group.groupId }) { group ->
                GroupCard(group = group) {
                    // 그룹 상세 화면으로 이동
                    navController.navigate("group_detail/${group.groupId}")
                }
            }
        }
    }
}