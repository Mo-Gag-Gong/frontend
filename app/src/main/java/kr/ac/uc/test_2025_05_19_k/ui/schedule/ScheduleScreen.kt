// ui/schedule/ScheduleScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.schedule

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.viewmodel.GoalResponse
import kr.ac.uc.test_2025_05_19_k.viewmodel.GoalViewModel
import java.time.LocalDate
import java.time.YearMonth

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen
            (
    navController: NavController,
    groupId: Long


) {

    val viewModel: GoalViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()

    val today = LocalDate.now()
    var selectedDate by remember { mutableStateOf(today) }
    var currentMonth by remember { mutableStateOf(YearMonth.now()) }

    val goalMap by viewModel.goalMap.collectAsState()

    // ✅ 모달 상태
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var selectedGoals by remember { mutableStateOf<List<GoalResponse>>(emptyList()) }

    // ✅ 데이터 로딩
    LaunchedEffect(Unit) {
        viewModel.loadGoalsFromMyGroups()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("📅 스케줄") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // 🔸 월 변경
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { currentMonth = currentMonth.minusMonths(groupId) }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "이전 달")
                }
                Text(
                    "${currentMonth.year}.${currentMonth.monthValue.toString().padStart(2, '0')}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = { currentMonth = currentMonth.plusMonths(groupId) }) {
                    Icon(Icons.Default.ArrowForward, contentDescription = "다음 달")
                }
            }

            Spacer(Modifier.height(8.dp))

            // 🔸 달력 출력
            CalendarGrid(currentMonth) { clickedDate ->
                selectedDate = clickedDate
                selectedGoals = goalMap[clickedDate] ?: emptyList()
                scope.launch {
                    sheetState.show()
                }
            }
        }

        // 🔸 상세 모달
        if (sheetState.isVisible) {
            ModalBottomSheet(
                onDismissRequest = { scope.launch { sheetState.hide() } },
                sheetState = sheetState
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("📌 ${selectedDate} 목표", style = MaterialTheme.typography.titleMedium)
                    if (selectedGoals.isEmpty()) {
                        Text("등록된 목표 없음")
                    } else {
                        selectedGoals.forEach {
                            Text("• ${it.title}")
                        }
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarGrid(month: YearMonth, onDateClick: (LocalDate) -> Unit) {
    val firstDay = month.atDay(1)
    val lastDay = month.lengthOfMonth()
    val firstWeekday = (firstDay.dayOfWeek.value % 7) // 일요일 시작

    val totalCells = ((firstWeekday + lastDay + 6) / 7) * 7
    val dates = (0 until totalCells).map { index ->
        val day = index - firstWeekday + 1
        if (day in 1..lastDay) month.atDay(day) else null
    }

    Column {
        // 🔸 요일 헤더
        Row(Modifier.fillMaxWidth()) {
            listOf("일", "월", "화", "수", "목", "금", "토").forEach {
                Text(
                    it,
                    modifier = Modifier.weight(1f),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // 🔸 날짜 출력
        dates.chunked(7).forEach { week ->
            Row(Modifier.fillMaxWidth()) {
                week.forEach { date ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(4.dp)
                            .clip(CircleShape)
                            .background(if (date == LocalDate.now()) Color.LightGray else Color.Transparent)
                            .clickable(enabled = date != null) {
                                date?.let { onDateClick(it) }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = date?.dayOfMonth?.toString() ?: "")
                    }
                }
            }
        }
    }
}
