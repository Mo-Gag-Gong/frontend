package kr.ac.uc.test_2025_05_19_k.model.user

import kr.ac.uc.test_2025_05_19_k.model.common.InterestDto


data class UserProfileResponse( // 클래스명은 UserProfileDto 또는 UserProfileResponse 등 자유롭게
    val profileId: Long,
    val userId: Long,
    val email: String,
    val name: String,
    val gender: String,
    val phoneNumber: String,
    val birthYear: Int,
    val profileImage: String,
    val interests: List<InterestDto>,
    val onboardingCompleted: Boolean
)