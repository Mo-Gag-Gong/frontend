// viewmodel/GoalViewModel.kt
package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.ac.uc.test_2025_05_19_k.repository.GoalRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class GoalViewModel @Inject constructor(
    private val repository: GoalRepository
) : ViewModel() {

    private val _goalMap = MutableStateFlow<Map<LocalDate, List<GoalResponse>>>(emptyMap())
    val goalMap: StateFlow<Map<LocalDate, List<GoalResponse>>> = _goalMap

    // ✅ 자신이 참여 중인 그룹의 모든 목표 불러오기
    fun loadGoalsFromMyGroups() {
        viewModelScope.launch {
            val groupIds = repository.getJoinedGroupIds()
            val allGoals = mutableListOf<GoalResponse>()

            for (groupId in groupIds) {
                val goals = repository.getGoalsByGroup(groupId)
                allGoals += goals
            }

            // ✅ 목표들을 날짜 기준으로 매핑
            val dateMap = mutableMapOf<LocalDate, MutableList<GoalResponse>>()
            for (goal in allGoals) {
                val start = LocalDate.parse(goal.startDate)
                val end = LocalDate.parse(goal.endDate)
                var date = start
                while (!date.isAfter(end)) {
                    dateMap.getOrPut(date) { mutableListOf() }.add(goal)
                    date = date.plusDays(1)
                }
            }

            _goalMap.value = dateMap
        }
    }
}
