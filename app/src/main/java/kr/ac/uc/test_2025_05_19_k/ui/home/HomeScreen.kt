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

    LaunchedEffect(Unit) {
        viewModel.initUser()
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

            Row(modifier = Modifier.fillMaxWidth()) {
                interests.forEach { interest ->
                    InterestTag(
                        name = interest.name,
                        isSelected = selectedInterest == interest.name,
                        onClick = {
                            viewModel.onInterestClick(interest.name)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            groupList.forEach { group ->
                GroupCard(group = group) {
                    onGroupClick(group.groupId)
                }
            }
        }
    }
}
