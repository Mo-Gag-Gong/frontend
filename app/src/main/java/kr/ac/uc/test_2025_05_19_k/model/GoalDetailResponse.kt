package kr.ac.uc.test_2025_05_19_k.model

import com.google.gson.annotations.SerializedName

//일정 List  DTO
//GoalDto 에서 사용

// 목표 상세 항목 모델
data class GoalDetailResponse(
    val detailId: Long,
    val goalId: Long,
    val description: String,
    val isCompleted: Boolean
)