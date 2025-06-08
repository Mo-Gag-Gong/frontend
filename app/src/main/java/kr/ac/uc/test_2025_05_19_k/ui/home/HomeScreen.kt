// mo-gag-gong/frontend/frontend-dev-hj/app/src/main/java/kr/ac/uc/test_2025_05_19_k/ui/home/HomeScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.ac.uc.test_2025_05_19_k.ui.common.GroupCard
import kr.ac.uc.test_2025_05_19_k.ui.common.InterestTag
import kr.ac.uc.test_2025_05_19_k.viewmodel.HomeViewModel

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn // LazyColumn 임포트
import androidx.compose.foundation.lazy.items // items 임포트
import androidx.compose.foundation.lazy.rememberLazyListState // rememberLazyListState 임포트
import androidx.compose.material.icons.filled.Search
import androidx.navigation.NavController
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
    onGroupClick: (Long) -> Unit,
    onCreateGroupClick: () -> Unit,
    onNavigateToSearch: () -> Unit
) {
    val region by viewModel.region.collectAsState()
    val interests by viewModel.interests.collectAsState()
    val selectedInterest by viewModel.selectedInterest.collectAsState()
    val groupList by viewModel.groupList.collectAsState()

    // --- 페이지네이션 관련 상태 ---
    val isLoadingInitial by viewModel.isLoadingInitial.collectAsState()
    val isLoadingNextPage by viewModel.isLoadingNextPage.collectAsState()
    val isLastPage by viewModel.isLastPage.collectAsState()
    val lazyListState = rememberLazyListState()

    // 스크롤 리스너: 리스트의 끝에 도달하면 다음 페이지 로드
    LaunchedEffect(lazyListState, isLoadingNextPage, isLastPage, groupList) {
        snapshotFlow { lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collect { lastVisibleItemIndex ->
                val totalItemsCount = lazyListState.layoutInfo.totalItemsCount
                // groupList가 비어있지 않고, 마지막에서 1~2개 아이템이 보일 때 미리 로드, 로딩 중이 아니고, 마지막 페이지가 아닐 때
                if (groupList.isNotEmpty() && lastVisibleItemIndex != null &&
                    lastVisibleItemIndex >= totalItemsCount - 3 && // 마지막에서 3번째 아이템 보이면 미리 로드
                    !isLoadingInitial && !isLoadingNextPage && !isLastPage
                ) {
                    Log.d("HomeScreen", "스크롤 끝 감지, 다음 페이지 로드 요청. LastVisible: $lastVisibleItemIndex, TotalItems: $totalItemsCount")
                    viewModel.loadNextGroupPage()
                }
            }
    }
    // ViewModel 초기화는 ViewModel의 init 블록에서 처리되므로 별도 호출 불필요
    // LaunchedEffect(Unit) {
    //     viewModel.initUser() -> ViewModel의 init에서 호출
    // }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onCreateGroupClick() },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "그룹 생성")
            }
        },
        topBar = {
            TopAppBar(
                title = { Text(text = if (region.isNotBlank()) "${region} 지역 스터디 추천" else "스터디 추천") },
                actions = {
                    IconButton(onClick = onNavigateToSearch) {
                        Icon(Icons.Default.Search, contentDescription = "검색")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 0.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                if (interests.isNotEmpty()) {
                    interests.forEach { interest ->
                        InterestTag(
                            name = interest.interestName,
                            isSelected = selectedInterest == interest.interestName,
                            onClick = {
                                viewModel.onInterestClick(if (selectedInterest == interest.interestName) null else interest.interestName)
                            }
                        )
                    }
                } else if (!isLoadingInitial) { // 로딩 중이 아닐 때만 "관심사 없음" 표시
                    Text("관심사 로딩 중이거나 없음...", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isLoadingInitial) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (groupList.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("표시할 스터디 그룹이 없습니다.", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                }
            } else {
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp) // 카드 간 간격
                ) {
                    items(items = groupList, key = { group -> group.groupId }) { group ->
                        GroupCard(group = group) {
                            onGroupClick(group.groupId)
                        }
                    }
                    // 다음 페이지 로딩 인디케이터
                    if (isLoadingNextPage) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                }
            }
        }
    }
}