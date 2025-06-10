package kr.ac.uc.test_2025_05_19_k.model
//일정 표시 DTO
data class GoalDto(
    val goalId: Int,
    val groupId: Int,
    val creatorId: Int,
    val creatorName: String,
    val title: String,
    val pointValue: Int,
    val startDate: String, // "2025-06-08"
    val endDate: String,
    val details: List<GoalDetailResponse>,
    val completedCount: Int,
    val totalCount: Int
)