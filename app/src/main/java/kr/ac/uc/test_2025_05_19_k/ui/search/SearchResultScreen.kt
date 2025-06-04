package kr.ac.uc.test_2025_05_19_k.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.ac.uc.test_2025_05_19_k.ui.common.GroupCard
import kr.ac.uc.test_2025_05_19_k.viewmodel.HomeViewModel
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import android.util.Log // Log import

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResultScreen(
    navController: NavController,
    searchQuery: String,
    viewModel: HomeViewModel = hiltViewModel(),
    onGroupClick: (Long) -> Unit
) {
    val region by viewModel.region.collectAsState() // 지역명
    val groupList by viewModel.groupList.collectAsState() // 검색 결과 그룹 목록

    LaunchedEffect(searchQuery) {
        // 검색어 변경 시 그룹 목록 다시 불러오기
        Log.d("SearchResultScreen", "검색어: $searchQuery, 지역: $region. 그룹 목록 불러오기 시작.")
        viewModel.fetchGroups(searchQuery)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("검색 결과", fontSize = 18.sp, fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "뒤로가기")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("group_create") },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "그룹 생성")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "\"${searchQuery}\" 검색 결과",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            if (groupList.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("검색 결과가 없습니다.", style = MaterialTheme.typography.bodyLarge)
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(groupList.size) { index ->
                        val group = groupList[index]
                        GroupCard(group = group) {
                            onGroupClick(group.groupId)
                        }
                    }
                }
            }
        }
    }
}