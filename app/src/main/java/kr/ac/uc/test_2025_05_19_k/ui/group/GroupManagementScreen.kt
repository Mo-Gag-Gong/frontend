// app/src/main/java/kr/ac/uc/test_2025_05_19_k/ui/group/GroupManagementScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.group

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row // Row 임포트
import androidx.compose.foundation.layout.Spacer // Spacer 임포트
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size // size 임포트
import androidx.compose.foundation.layout.width // width 임포트
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons // Icons 임포트
import androidx.compose.material.icons.filled.Edit // Edit 아이콘 임포트
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton // IconButton 임포트
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.ac.uc.test_2025_05_19_k.model.StudyGroup
import kr.ac.uc.test_2025_05_19_k.ui.common.GroupCard
import kr.ac.uc.test_2025_05_19_k.viewmodel.GroupManagementViewModel

private val tabs = listOf("참여한 그룹", "만든 그룹")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupManagementScreen(
    navController: NavController,
    viewModel: GroupManagementViewModel = hiltViewModel()
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(selectedTabIndex) {
        when (selectedTabIndex) {
            0 -> viewModel.fetchMyJoinedGroups()
            1 -> viewModel.fetchMyOwnedGroups()
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        PrimaryTabRow(
            selectedTabIndex = selectedTabIndex,
            // ... (이전 코드와 동일) ...
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
                val errorMessage by viewModel.errorMessage.collectAsState()
                GroupListContent( // 참여한 그룹은 기존 GroupListContent 사용
                    groups = joinedGroups,
                    isLoading = isLoading,
                    errorMessage = errorMessage,
                    navController = navController,
                    emptyListMessage = "참여한 스터디 그룹이 없습니다."
                )
            }
            1 -> { // "만든 그룹" 탭을 위한 별도 Composable 호출
                CreatedGroupsTabContent(navController = navController, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun CreatedGroupsTabContent(
    navController: NavController,
    viewModel: GroupManagementViewModel // ViewModel 직접 전달
) {
    val ownedGroups by viewModel.ownedGroups.collectAsState()
    val isLoading by viewModel.isLoadingOwned.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (errorMessage != null) {
        Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
            // 또는 안전 호출 사용
            errorMessage?.let { msg ->
                Text(text = msg, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.error)
            }
        }
    } else if (ownedGroups.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
            Text(text = "만든 스터디 그룹이 없습니다.", style = MaterialTheme.typography.bodyLarge)
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = ownedGroups, key = { group -> group.groupId }) { group ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.weight(1f)) { // GroupCard가 남은 공간을 채우도록
                        GroupCard(group = group) {
                            // 만든 그룹 카드 클릭 시 상세 화면으로 이동 (기존과 동일)
                            navController.navigate("group_detail/${group.groupId}")
                        }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = {
                        // 그룹 편집 화면으로 이동 (groupId 전달)
                        navController.navigate("group_edit/${group.groupId}")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "그룹 수정",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}


// GroupListContent 함수는 이전과 동일하게 유지 (참여한 그룹 탭에서 사용)
@Composable
fun GroupListContent(
    groups: List<StudyGroup>,
    isLoading: Boolean,
    errorMessage: String?,
    navController: NavController,
    emptyListMessage: String,
    onGroupClick: (Long) -> Unit = { groupId -> navController.navigate("group_detail/$groupId") }
) {
    // ... (이전 GroupListContent 코드와 동일)
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (errorMessage != null) {
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
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = groups, key = { group -> group.groupId }) { group ->
                GroupCard(group = group) {
                    onGroupClick(group.groupId)
                }
            }
        }
    }
}