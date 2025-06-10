package kr.ac.uc.test_2025_05_19_k.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
    val searchQuery by viewModel.searchQuery.collectAsState()

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
                // groupList가 비어있지 않고, 마지막에서 3번째 아이템 보이면 미리 로드
                if (groupList.isNotEmpty() && lastVisibleItemIndex != null &&
                    lastVisibleItemIndex >= totalItemsCount - 3 &&
                    !isLoadingInitial && !isLoadingNextPage && !isLastPage
                ) {
                    Log.d("HomeScreen", "스크롤 끝 감지, 다음 페이지 로드 요청. LastVisible: $lastVisibleItemIndex, TotalItems: $totalItemsCount")
                    viewModel.loadNextGroupPage()
                }
            }
    }

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

            // --- 검색 입력창 ---
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.onSearchQueryChange(it) },
                label = { Text("스터디 검색") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // --- 관심사 태그 목록 (가로 스크롤) ---
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
                                viewModel.onInterestClick(
                                    if (selectedInterest == interest.interestName) null else interest.interestName
                                )
                            }
                        )
                    }
                } else if (!isLoadingInitial) {
                    Text("관심사 로딩 중이거나 없음...", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // --- 그룹 리스트/로딩/없음 처리 ---
            if (isLoadingInitial) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (groupList.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        "표시할 스터디 그룹이 없습니다.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            } else {
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(items = groupList, key = { group -> group.groupId }) { group ->
                        GroupCard(group = group) {
                            onGroupClick(group.groupId)
                        }
                    }
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
