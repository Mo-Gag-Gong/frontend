package kr.ac.uc.test_2025_05_19_k.model.group

data class StudyGroupResponseDto(
    val groupId: Long,
    val creatorId: Long,
    val creatorName: String,
    val title: String,
    val interestName: String,
    val description: String,
    val locationName: String,
    val startDate: String,
    val endDate: String,
    val maxMembers: Int,
    val currentMembers: Int,
    val requirements: String,
    val isActive: Boolean,
    val createdAt: String,
    val updatedAt: String
)