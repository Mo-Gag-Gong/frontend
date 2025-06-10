package kr.ac.uc.test_2025_05_19_k.network

import kr.ac.uc.test_2025_05_19_k.model.*
import kr.ac.uc.test_2025_05_19_k.model.auth.TokenResponse
import kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

/**
 * 서버 API 호출용 Retrofit 인터페이스
 */
interface ApiService {

    // [GET] 사용자 자신의 프로필 조회
    @GET("/api/users/profile")
    suspend fun getMyProfile(): UserProfileResponse

    // [PUT] 사용자 프로필 업데이트
    @PUT("/api/users/profile")
    suspend fun updateProfile(
        @Body profileRequest: ProfileUpdateRequest
    ): Response<UserProfileResponse>

    // [GET] 온보딩 완료 여부 확인
    @GET("/api/users/onboarding-status")
    suspend fun getOnboardingStatus(): OnboardingStatusResponse

    // [GET] 내가 선택한 관심사 목록 조회
    @GET("/api/users/my-interests")
    suspend fun getMyInterests(): List<Interest>

    // [GET] 전체 관심사 목록 조회
    @GET("/api/users/interests")
    suspend fun getAllInterests(): List<InterestDto>

    // [POST] 관심사 추가
    @POST("/api/users/interests/{interestId}")
    suspend fun addInterest(
        @Path("interestId") id: Int
    ): ResponseBody

    // [DELETE] 관심사 제거
    @DELETE("/api/users/interests/{interestId}")
    suspend fun removeInterest(
        @Path("interestId") id: Int
    ): ResponseBody

    // [GET] 현재 로그인한 사용자 정보 (OAuth 토큰 기반)
    @GET("/api/auth/me")
    suspend fun getCurrentUser(): UserProfileResponse

    // [POST] 토큰 리프레시 요청
    @POST("/api/auth/token/refresh")
    suspend fun refreshToken(
        @Body refreshTokenRequest: RefreshTokenRequest
    ): Response<TokenResponse>

    // --- 그룹/스터디 관련 추가 API (예시) ---
    @GET("/api/groups")
    suspend fun getGroups(
        @Query("region") region: String,
        @Query("keyword") keyword: String?,
        @Query("interest") interest: String?
    ): List<StudyGroup>

    @GET("/api/groups/{id}")
    suspend fun getGroupDetail(@Path("id") groupId: Long): StudyGroupDetail

    @POST("/api/groups/{groupId}/apply")
    suspend fun applyToGroup(@Path("groupId") groupId: Long)

    @POST("/api/groups")
    suspend fun createGroup(@Body request: GroupCreateRequest)

    // --- 인증/로그인 ---
    @POST("/api/users/login")
    suspend fun login(@Body request: LoginRequest): TokenResponse

    @POST("/api/users/join")
    suspend fun register(@Body request: RegisterRequest): ResponseBody

    // --- 기타 OAuth 인증 코드 전송(예시) ---
    @FormUrlEncoded
    @POST("oauth/code")
    fun sendAuthCode(@Field("code") code: String): Call<ResponseBody>
}
