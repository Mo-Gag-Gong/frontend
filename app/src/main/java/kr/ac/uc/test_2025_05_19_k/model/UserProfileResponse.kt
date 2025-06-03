package kr.ac.uc.test_2025_05_19_k.model

data class UserProfileResponse(
    val profileId: Long, // 추가
    val userId: Long,
    val email: String,
    val name: String,
    val gender: String,
    val phoneNumber: String,
    val birthYear: Int,
    val mentorScore: Int, // 추가
    val profileImage: String?, // 추가 (nullable 여부는 API 응답에 따라 결정)
    val interests: List<InterestDto>?,
    val onboardingCompleted: Boolean, // 추가
    // val locationName: String, // API 스키마에 없음, 필요시 서버 확인 후 유지 또는 제거
)