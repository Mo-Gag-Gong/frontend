// app/src/main/java/kr/ac/uc/test_2025_05_19_k/model/UserProfileResponse.kt
package kr.ac.uc.test_2025_05_19_k.model

/**
 * 사용자 프로필 조회 응답 모델
 * 서버 응답 필드에 맞게 수정/확장 필요
 */
data class UserProfileResponse(
    val profileId: Long,                // 프로필 고유 ID
    val userId: Long,                   // 유저 고유 ID
    val email: String,                  // 이메일
    val name: String,                   // 이름
    val gender: String,                 // 성별
    val phoneNumber: String,            // 전화번호
    val birthYear: Int,                 // 출생연도
    val mentorScore: Int,               // 멘토 점수 (추가)
    val profileImage: String?,          // 프로필 이미지 URL (nullable, 추가)
    val interests: List<InterestDto>?,  // 관심사(복수)
    val onboardingCompleted: Boolean    // 온보딩 완료 여부 (추가)
    // val locationName: String,        // 필요시 주석 해제(서버에 해당 필드가 있는지 확인)
)
