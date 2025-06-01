package kr.ac.uc.test_2025_05_19_k.model.request

data class GroupCreateRequestDto(
    val title: String,
    val interest: String,
    val description: String,
    val locationName: String,
    val startDate: String,
    val endDate: String,
    val maxMembers: Int,
    val requirements: String
)