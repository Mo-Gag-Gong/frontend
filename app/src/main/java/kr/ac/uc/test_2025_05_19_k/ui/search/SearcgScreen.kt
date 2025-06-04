// mo-gag-gong/frontend/frontend-dev-hj/app/src/main/java/kr/ac/uc/test_2025_05_19_k/ui/search/SearchScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.ac.uc.test_2025_05_19_k.viewmodel.HomeViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(), // HomeViewModel을 사용하여 지역명 가져오기
    onSearch: (String) -> Unit
) {
    val region by viewModel.region.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    val recentSearches = remember { mutableStateListOf("영어 회화", "자격증 공부") } // 임시 최근 검색어

    LaunchedEffect(Unit) {
        viewModel.initUser() // 지역명 로드를 위해 초기화
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") }, // 제목은 비워두고 검색창으로 대체
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "뒤로가기")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            // 검색 바
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("${region} 근처에서 검색", color = Color.Gray) }, // 지역명 표시
                singleLine = true,
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "검색 아이콘")
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = {
                            if (searchQuery.isNotBlank()) {
                                onSearch(searchQuery)
                            }
                        }) {
                            Icon(Icons.Default.Search, contentDescription = "검색 실행")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        if (searchQuery.isNotBlank()) {
                            onSearch(searchQuery)
                        }
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 최근 검색어
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "최근 검색어",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                TextButton(onClick = { recentSearches.clear() }) {
                    Text("모두 지우기", color = MaterialTheme.colorScheme.primary)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            FlowRow( // 자동 줄바꿈을 위한 FlowRow
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                recentSearches.forEach { search ->
                    AssistChip(
                        onClick = { onSearch(search) },
                        label = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(search)
                                Spacer(Modifier.width(4.dp))
                                Icon(Icons.Default.Close, contentDescription = "삭제", modifier = Modifier.size(16.dp))
                            }
                        },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Color(0xFFE0E0E0),
                            labelColor = Color.Black
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    val navController = rememberNavController()
    SearchScreen(navController = navController, onSearch = {})
}