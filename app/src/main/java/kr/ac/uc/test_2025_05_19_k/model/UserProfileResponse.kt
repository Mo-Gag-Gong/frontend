package kr.ac.uc.test_2025_05_19_k.model

data class UserProfileResponse(
    val userId: Long,
    val email: String,
    val name: String,
    val gender: String,
    val phoneNumber: String,
    val birthYear: Int,
    val locationName: String,
    val interests: List<InterestDto>?
    // 서버에서 내려오는 필드에 맞게 필요시 추가/삭제
)