package kr.ac.uc.test_2025_05_19_k.model

data class StudyGroup(
    val id: Long,
    val name: String,
    val description: String,
    val category: String,
    val memberCount: Int,
    val maxMembers: Int
)
