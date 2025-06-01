package kr.ac.uc.test_2025_05_19_k.model.user

data class OnboardingStatusResponse(
    val onboardingCompleted: Boolean,
    val role: String // 추가
)