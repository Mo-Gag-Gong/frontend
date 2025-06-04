// app/src/main/java/kr/ac/uc/test_2025_05_19_k/network/AuthInterceptor.kt
package kr.ac.uc.test_2025_05_19_k.network

import android.content.Context
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import dagger.Lazy
import kr.ac.uc.test_2025_05_19_k.model.RefreshTokenRequest
import kr.ac.uc.test_2025_05_19_k.network.ApiService
import kr.ac.uc.test_2025_05_19_k.repository.TokenManager
import android.util.Log // Log import 추가

class AuthInterceptor(
    private val tokenManager: TokenManager,
    private val apiService: Lazy<ApiService>
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val accessToken = tokenManager.getAccessToken()

        Log.d("AuthInterceptor", "현재 AccessToken: ${accessToken?.take(10)}...") // AccessToken 존재 여부 및 일부 출력

        // 1. accessToken이 있으면 Authorization 헤더에 추가
        if (!accessToken.isNullOrBlank()) {
            request = request.newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()
            Log.d("AuthInterceptor", "Authorization 헤더 추가됨.")
        } else {
            Log.w("AuthInterceptor", "AccessToken이 없습니다. 인증 없이 요청합니다.")
        }

        var response = chain.proceed(request)

        Log.d("AuthInterceptor", "응답 코드: ${response.code} for URL: ${response.request.url}") // 응답 코드 출력

        // 2. 만약 401(Unauthorized)이면 refresh 시도 (자동 갱신)
        if (response.code == 401) {
            Log.w("AuthInterceptor", "401 Unauthorized 응답 받음. 토큰 갱신 시도...")
            runBlocking {
                val refreshed = refreshTokenIfNeeded(tokenManager, apiService.get())
                if (refreshed) {
                    // 토큰 갱신 성공 시 Authorization 헤더에 새 토큰으로 재요청
                    val newAccessToken = tokenManager.getAccessToken()
                    val newRequest = request.newBuilder()
                        .removeHeader("Authorization")
                        .addHeader("Authorization", "Bearer $newAccessToken")
                        .build()
                    response.close()
                    Log.d("AuthInterceptor", "토큰 갱신 성공, 새로운 AccessToken으로 재요청.")
                    response = chain.proceed(newRequest)
                } else {
                    // 리프레시도 실패 → 로그아웃 처리 등 (토큰 삭제)
                    tokenManager.clearTokens()
                    Log.e("AuthInterceptor", "토큰 갱신 실패! 모든 토큰을 지웁니다.")
                }
            }
        }
        return response
    }

    // 토큰 새로고침 함수
    suspend fun refreshTokenIfNeeded(tokenManager: TokenManager, apiService: ApiService): Boolean {
        val refreshToken = tokenManager.getRefreshToken() ?: run {
            Log.w("AuthInterceptor", "리프레시 토큰이 없어 갱신할 수 없습니다.")
            return false
        }
        Log.d("AuthInterceptor", "리프레시 토큰으로 갱신 요청 중...")
        val response = apiService.refreshToken(RefreshTokenRequest(refreshToken))
        return if (response.isSuccessful && response.body() != null) {
            val tokenRes = response.body()!!
            // userId를 추가로 전달
            tokenManager.saveTokens(tokenRes.accessToken, tokenRes.refreshToken, tokenRes.userId) // userId 추가
            Log.d("AuthInterceptor", "리프레시 토큰으로 AccessToken 갱신 성공.")
            true
        } else {
            Log.e("AuthInterceptor", "리프레시 토큰 갱신 API 실패: ${response.code()} / ${response.message()}")
            tokenManager.clearTokens()
            false
        }
    }
}