package kr.ac.uc.test_2025_05_19_k.ui.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.*
import androidx.navigation.NavController

import androidx.hilt.navigation.compose.hiltViewModel
import kr.ac.uc.test_2025_05_19_k.model.Interest
import kr.ac.uc.test_2025_05_19_k.viewmodel.ProfileInputViewModel

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun InterestSelectScreenHost(
    userName: String,
    navController: NavController,
    viewModel: ProfileInputViewModel = hiltViewModel(),
    onNext: () -> Unit = {}
) {
    // 관심사 로드
    val interests = viewModel.interests
    val loading = viewModel.interestLoading
    val error = viewModel.interestError
    val selectedIds = viewModel.selectedInterestIds

    // 진입 시 관심사 목록 불러오기
    LaunchedEffect(Unit) { viewModel.loadInterests() }

    when {
        loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        !error.isNullOrBlank() -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(error!!, color = Color.Red)
        }
        else -> InterestSelectScreen(
            interests = interests,
            selectedIds = selectedIds,
            userName = userName,
            navController = navController,
            onToggle = { id -> viewModel.toggleInterest(id) },
            onNext = onNext
        )
    }
}


@Composable
fun InterestSelectScreen(
    interests: List<Interest>,
    selectedIds: List<Long>,
    userName: String,
    navController: NavController,
    onToggle: (Long) -> Unit,
    onNext: () -> Unit
) {
    var errorMsg by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp, vertical = 18.dp)
    ) {
        // 상단 바
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Button(
                onClick = {
                    if (selectedIds.isEmpty()) {
                        errorMsg = "관심사를 1개 이상 선택해 주세요."
                    } else {
                        errorMsg = null
                        onNext()
                    }
                },
                enabled = selectedIds.isNotEmpty(),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedIds.isNotEmpty()) Color(0xFF14C7E5) else Color.LightGray
                ),
                modifier = Modifier.height(44.dp)
            ) {
                Text("다음", color = Color.White, fontSize = 17.sp)
            }
        }

        Spacer(modifier = Modifier.height(36.dp))
        Text("반갑습니다 ${userName}님!", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.fillMaxWidth(), color = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        Text("이제부터 ${userName}님의 관심사를 설정할게요!", fontSize = 14.sp, modifier = Modifier.fillMaxWidth(), color = Color.Black)
        Spacer(modifier = Modifier.height(28.dp))

        // 관심사 2열 그리드
        InterestCardGrid(
            interests = interests,
            selectedIds = selectedIds,
            onToggle = onToggle
        )

        errorMsg?.let {
            Spacer(modifier = Modifier.height(10.dp))
            Text(it, color = Color.Red, fontSize = 13.sp)
        }
    }
}

@Composable
fun InterestCardGrid(
    interests: List<Interest>,
    selectedIds: List<Long>,
    onToggle: (Long) -> Unit
) {
    val rows = interests.chunked(2)
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        rows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { interest ->
                    InterestCard(
                        interest = interest,
                        selected = selectedIds.contains(interest.id),
                        onClick = { onToggle(interest.id) }
                    )
                }
                if (row.size == 1) {
                    Spacer(modifier = Modifier.width(140.dp))
                }
            }
        }
    }
}

@Composable
fun InterestCard(
    interest: Interest,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 140.dp, height = 92.dp)
            .background(
                color = if (selected) Color(0xFF14C7E5) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = if (selected) 2.dp else 1.dp,
                color = if (selected) Color(0xFF14C7E5) else Color.Gray,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 0.dp, vertical = 0.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = interest.name, // name 속성으로 출력
            color = if (selected) Color.White else Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
}
