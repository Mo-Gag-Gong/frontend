package kr.ac.uc.test_2025_05_19_k.network.api

import kr.ac.uc.test_2025_05_19_k.model.*
import kr.ac.uc.test_2025_05_19_k.model.auth.RegisterRequest
import kr.ac.uc.test_2025_05_19_k.model.auth.TokenResponse
import kr.ac.uc.test_2025_05_19_k.model.auth.LoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST("/api/users/login")
    suspend fun login(
        @Body request: LoginRequest
    ): TokenResponse

    @POST("/api/users/join")
    suspend fun register(
        @Body request: RegisterRequest
    ): Void

    @GET("/api/auth/me")
    suspend fun getMyProfile(): AuthUserProfile
}
