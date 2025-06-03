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

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onGroupClick: (Long) -> Unit,
    onCreateGroupClick: () -> Unit
) {
    val region by viewModel.region.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val interests by viewModel.interests.collectAsState()
    val selectedInterest by viewModel.selectedInterest.collectAsState()
    val groupList by viewModel.groupList.collectAsState()

    // 초기 사용자 데이터 및 관심사 로드
    LaunchedEffect(Unit) {
        viewModel.initUser()
    }

    // 검색어 또는 선택된 관심사 변경 시 그룹 목록 업데이트 (백엔드 호출)
    LaunchedEffect(searchQuery, selectedInterest) {
        viewModel.fetchGroups()
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
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(text = "${region} 지역 스터디 추천", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.onSearchQueryChange(it) },
                label = { Text("스터디 검색") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

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

            // 지역 및 관심사로 필터링된 그룹 목록 생성
            val filteredGroupList = remember(groupList, selectedInterest, region) { // region도 remember의 키에 추가
                groupList.filter { group ->
                    val matchesRegion = group.locationName.contains(region, ignoreCase = true) // 사용자의 지역 정보와 스터디 그룹의 지역 정보 비교
                    val matchesInterest = if (selectedInterest == null) {
                        true // 관심사가 선택되지 않았으면 모든 관심사를 포함
                    } else {
                        group.interestName == selectedInterest // 선택된 관심사와 일치하는지 확인
                    }
                    matchesRegion && matchesInterest
                }
            }

            // 필터링된 그룹 목록을 화면에 표시
            filteredGroupList.forEach { group ->
                GroupCard(group = group) {
                    onGroupClick(group.groupId)
                }
            }
        }
    }
}