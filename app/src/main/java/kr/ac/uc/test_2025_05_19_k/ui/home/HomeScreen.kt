package kr.ac.uc.test_2025_05_19_k.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn // LazyColumn으로 변경하여 스크롤 및 더 보기 기능 토대 마련
import androidx.compose.foundation.lazy.items // LazyColumn의 items 사용
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

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onGroupClick: (Long) -> Unit,
    onCreateGroupClick: () -> Unit
) {
    val region by viewModel.region.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val interests by viewModel.interests.collectAsState() // 이제 List<InterestDto> 타입
    val selectedInterest by viewModel.selectedInterest.collectAsState()
    val groupList by viewModel.groupList.collectAsState() // 이제 List<StudyGroupResponseDto> 타입

    LaunchedEffect(Unit) {
        viewModel.initUser() // 내부적으로 fetchGroupsFirstPage() 호출
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
                .padding(horizontal = 16.dp) // 수평 패딩만 Column에 직접 적용
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp)) // 상단 여백
            Text(
                text = "${region} 지역 스터디 추천",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.onSearchQueryChange(it) }, // 내부적으로 첫 페이지부터 다시 로드
                label = { Text("스터디 검색") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 관심사 태그 목록 (스크롤 가능하도록 Row를 LazyRow 등으로 변경 고려)
            Row(
                modifier = Modifier.fillMaxWidth()
                // horizontalArrangement = Arrangement.spacedBy(8.dp) // 태그 간 간격
                // TODO: 관심사가 많을 경우 LazyRow 등으로 변경하여 가로 스크롤 지원
            ) {
                interests.forEach { interestDto -> // it의 타입은 InterestDto
                    InterestTag(
                        name = interestDto.interestName, // interest.name에서 interestDto.interestName으로 변경
                        isSelected = selectedInterest == interestDto.interestName, // 비교 대상도 interestDto.interestName으로 변경
                        onClick = {
                            if (selectedInterest == interestDto.interestName) {
                                viewModel.onInterestClick(null)
                            } else {
                                // viewModel.onInterestClick에는 관심사 '이름(String)'을 전달
                                viewModel.onInterestClick(interestDto.interestName)
                            }
                        }
                    )
                    Spacer(Modifier.width(8.dp)) // 태그 간 간격 수동 추가
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 그룹 목록 (LazyColumn 사용)
            if (groupList.isEmpty() && searchQuery.isNotEmpty() && viewModel.searchQuery.value.isNotEmpty()) { // isLoading 상태 추가 고려
                Text("검색 결과가 없습니다.")
            } else if (groupList.isEmpty() && selectedInterest != null) {
                Text("선택한 관심사에 해당하는 스터디 그룹이 없습니다.")
            }
            else if (groupList.isEmpty()){
                Text("스터디 그룹이 없습니다. 직접 만들어보세요!")
            }
            else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 72.dp) // FAB와 겹치지 않도록 하단 여백 추가
                ) {
                    items(groupList) { group -> // group의 타입은 StudyGroupResponseDto
                        GroupCard(group = group) {
                            onGroupClick(group.groupId) // group.id에서 group.groupId로 변경
                        }
                    }

                    // "더 보기" 로직 (예시)
                    // item {
                    //     if (viewModel.canLoadMore.value && !viewModel.isLoadingApi.value) { // ViewModel에 해당 상태 필요
                    //         Button(onClick = { viewModel.fetchMoreGroups() }, modifier = Modifier.fillMaxWidth()) {
                    //             Text("더 보기")
                    //         }
                    //     }
                    // }
                }
            }
        }
    }
}