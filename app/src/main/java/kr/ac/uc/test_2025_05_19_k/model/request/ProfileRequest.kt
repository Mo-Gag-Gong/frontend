package kr.ac.uc.test_2025_05_19_k.model.request // 또는 model.user.request

data class ProfileUpdateRequest( // 클래스명 변경 고려
    val name: String,
    val gender: String,
    val phoneNumber: String,
    val birthYear: Int,
    val locationName: String, // 추가
    val interestIds: List<Long> // 추가
)