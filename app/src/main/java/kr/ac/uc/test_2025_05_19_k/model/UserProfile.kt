package kr.ac.uc.test_2025_05_19_k.model

data class UserProfile(
    val id: Long,
    val nickname: String,
    val email: String,
    val interests: List<Interest>,
    val profileImageUrl: String
)
