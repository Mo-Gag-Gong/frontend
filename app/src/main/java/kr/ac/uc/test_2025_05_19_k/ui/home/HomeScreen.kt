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
import androidx.compose.material.icons.filled.Search
import androidx.navigation.NavController
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController, // NavController 추가
    onGroupClick: (Long) -> Unit,
    onCreateGroupClick: () -> Unit,
    onNavigateToSearch: () -> Unit // 검색 화면으로 이동하는 콜백 추가
) {
    val region by viewModel.region.collectAsState()
    val interests by viewModel.interests.collectAsState()
    val selectedInterest by viewModel.selectedInterest.collectAsState()
    val groupList by viewModel.groupList.collectAsState()

    // 초기 사용자 데이터 및 관심사 로드
    LaunchedEffect(Unit) {
        viewModel.initUser()
    }

    // interests 상태가 변경될 때마다 로그 출력
    LaunchedEffect(interests) {
        Log.d("HomeScreen", "관심사 상태 업데이트 감지: ${interests.size}개, 데이터: $interests")
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
                title = { Text(text = "${region} 지역 스터디 추천") },
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
                .padding(horizontal = 16.dp, vertical = 0.dp) // 상단 패딩 제거
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            // 검색 바 대신 이제 검색 아이콘으로 이동합니다.
            // OutlinedTextField(
            //     value = searchQuery,
            //     onValueChange = { viewModel.onSearchQueryChange(it) },
            //     label = { Text("스터디 검색") },
            //     modifier = Modifier.fillMaxWidth()
            // )
            // Spacer(modifier = Modifier.height(12.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
            ) {
                if (interests.isNotEmpty()) {
                    interests.forEach { interest ->
                        InterestTag(
                            name = interest.name,
                            isSelected = selectedInterest == interest.name,
                            onClick = {
                                if (selectedInterest == interest.name) {
                                    viewModel.onInterestClick(null)
                                } else {
                                    viewModel.onInterestClick(interest.name)
                                }
                            }
                        )
                    }
                } else {
                    Text("관심사 로딩 중이거나 없음...", color = MaterialTheme.colorScheme.error)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 검색어 또는 선택된 관심사 변경 시 그룹 목록 업데이트 (백엔드 호출)
            // 홈 화면에서는 관심사 필터링만 적용되도록 수정
            LaunchedEffect(selectedInterest) {
                viewModel.fetchGroups()
            }

            // 필터링된 그룹 목록을 화면에 표시
            if (groupList.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("해당 조건의 스터디 그룹이 없습니다.")
                }
            } else {
                groupList.forEach { group -> // 필터링은 ViewModel에서 처리하도록 변경되었으므로, 여기서는 바로 groupList를 사용
                    GroupCard(group = group) {
                        onGroupClick(group.groupId)
                    }
                }
            }
        }
    }
}