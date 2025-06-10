package kr.ac.uc.test_2025_05_19_k.model


// 자신이 참여한 스터디 그룹 정보 모델
data class GroupResponse(
    val groupId: Long,
    val title: String,
    val description: String,
    val interestName: String,
    val locationName: String,
    val startDate: String,
    val endDate: String,
    val currentMembers: Int,
    val maxMembers: Int
)