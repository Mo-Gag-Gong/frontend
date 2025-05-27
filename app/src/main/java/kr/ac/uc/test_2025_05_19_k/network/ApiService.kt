package kr.ac.uc.test_2025_05_19_k.network

import retrofit2.http.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

// 🔸 사용자 프로필 업데이트 요청 DTO
data class ProfileRequest(
    val name: String,
    val gender: String,
    val phoneNumber: String,
    val birthYear: Int,
    val interestIds: List<Int> = emptyList() // 추가!
)

data class StudyGroup(
    val id: Long,
    val name: String,
    val description: String,
    val category: String,
    val memberCount: Int,
    val maxMembers: Int
)

data class StudyGroupDetail(
    val id: Long,
    val name: String,
    val description: String,
    val category: String,
    val memberCount: Int,
    val maxMembers: Int,
    val alreadyApplied: Boolean
)

data class UserProfile(
    val id: Long,
    val nickname: String,
    val email: String,
    val interests: List<Interest>,
    val profileImageUrl: String
)

data class GroupCreateRequest(
    val title: String,
    val description: String,
    val requirements: String,
    val category: String,
    val maxMembers: Int,
    val locationName: String
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(
    val email: String,
    val password: String,
    val nickname: String
)

data class TokenResponse_cy(
    val accessToken: String,
    val refreshToken: String,
    val grantType: String,
    val accessTokenExpiresIn: Long
)

data class RefreshTokenRequest(val refreshToken: String)

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val userId: Int
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
data class AuthUserProfile(
    val userId: Long,
    val email: String,
    val profileImage: String,
    val oauthId: String,
    val provider: String,
    val role: String,
    val createdAt: String,
    val updatedAt: String
)



// ✅ 서버 API를 호출하는 Retrofit 인터페이스
interface ApiService {

    // 🔹 [GET] 사용자 자신의 프로필 조회
//    @GET("/api/users/profile")
//    suspend fun getMyProfile(): ProfileResponse
    @GET("/api/auth/me")
    suspend fun getMyProfile(): AuthUserProfile

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
    suspend fun refreshToken(
        @Body refreshTokenRequest: RefreshTokenRequest
    ): Response<TokenResponse_cy>

    @GET("/api/groups")
    suspend fun getGroups(
        @retrofit2.http.Query("region") region: String,
        @retrofit2.http.Query("keyword") keyword: String?,
        @retrofit2.http.Query("interest") interest: String?
    ): List<StudyGroup>

    @FormUrlEncoded
    @POST("oauth/code") // 예: 서버에서 이 엔드포인트를 열어둔 경우
    fun sendAuthCode(@Field("code") code: String): Call<ResponseBody>
    @GET("/api/groups/{id}")
    suspend fun getGroupDetail(@Path("id") groupId: Long): StudyGroupDetail

    @POST("/api/groups/{groupId}/apply")
    suspend fun applyToGroup(@Path("groupId") groupId: Long)

    @POST("/api/groups")
    suspend fun createGroup(@Body request: GroupCreateRequest)

    @POST("/api/users/login")
    suspend fun login(
        @Body request: LoginRequest
    ): TokenResponse_cy

    @POST("/api/users/join")
    suspend fun register(
        @Body request: RegisterRequest
    ): Void


}
