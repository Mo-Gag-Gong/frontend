package kr.ac.uc.test_2025_05_19_k.viewmodel

import com.google.gson.annotations.SerializedName
import kr.ac.uc.test_2025_05_19_k.model.GoalDetailResponse

// 목표 전체 모델
data class GoalResponse(
    val goalId: Long,
    val groupId: Long,
    val creatorId: Long,
    val creatorName: String,
    val title: String,
    val pointValue: Int,
    val startDate: String, // "yyyy-MM-dd"
    val endDate: String,
    val details: List<GoalDetailResponse>,
    val completedCount: Int,
    val totalCount: Int
)