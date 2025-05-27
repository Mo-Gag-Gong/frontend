package kr.ac.uc.test_2025_05_19_k.network

import retrofit2.http.*
import okhttp3.ResponseBody
import retrofit2.Response

// 🔸 사용자 프로필 업데이트 요청 DTO
data class ProfileRequest(
    val name: String,
    val gender: String,
    val phoneNumber: String,
    val birthYear: Int
)

// 🔸 사용자 프로필 응답 DTO
data class ProfileResponse(
    val profileId: Int,
    val userId: Int,
    val email: String,
    val name: String,
    val gender: String,
    val phoneNumber: String,
    val birthYear: Int,
    val mentorScore: Int,
    val profileImage: String?,             // 프로필 이미지 (nullable)
    val interests: List<Interest>,         // 관심사 목록
    val onboardingCompleted: Boolean       // 온보딩 완료 여부
)

// 🔸 관심사 DTO
data class Interest(
    val interestId: Int,
    val interestName: String
)

// 🔸 온보딩 상태 응답 DTO
data class OnboardingStatusResponse(
    val onboardingCompleted: Boolean
)

// ✅ 서버 API를 호출하는 Retrofit 인터페이스
interface ApiService {

    // 🔹 [GET] 사용자 자신의 프로필 조회
    @GET("/api/users/profile")
    suspend fun getMyProfile(): ProfileResponse

    // 🔹 [PUT] 사용자 프로필 업데이트
    @PUT("/api/users/profile")
    suspend fun updateProfile(
        @Body profileRequest: ProfileRequest
    ): Response<ProfileResponse>

    // 🔹 [GET] 온보딩 완료 여부 확인
    @GET("/api/users/onboarding-status")
    suspend fun getOnboardingStatus(): OnboardingStatusResponse

    // 🔹 [GET] 내가 선택한 관심사 목록 조회
    @GET("/api/users/my-interests")
    suspend fun getMyInterests(): List<Interest>

    // 🔹 [GET] 전체 관심사 목록 조회
    @GET("/api/users/interests")
    suspend fun getAllInterests(): List<Interest>

    // 🔹 [POST] 관심사 추가
    @POST("/api/users/interests/{interestId}")
    suspend fun addInterest(
        @Path("interestId") id: Int
    ): ResponseBody

    // 🔹 [DELETE] 관심사 제거
    @DELETE("/api/users/interests/{interestId}")
    suspend fun removeInterest(
        @Path("interestId") id: Int
    ): ResponseBody

    // 🔹 [GET] 현재 로그인한 사용자 정보 (OAuth 토큰 기반)
    @GET("/api/auth/me")
    suspend fun getCurrentUser(): ProfileResponse

    // 🔹 [POST] 토큰 리프레시 요청
    @POST("/api/auth/token/refresh")
    suspend fun refreshToken(): ResponseBody
}
