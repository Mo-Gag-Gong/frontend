package kr.ac.uc.test_2025_05_19_k.network

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import dagger.Lazy
import kr.ac.uc.test_2025_05_19_k.network.ApiService

import kr.ac.uc.test_2025_05_19_k.network.RefreshTokenRequest
import kr.ac.uc.test_2025_05_19_k.repository.TokenManager

class AuthInterceptor(
    private val tokenManager: TokenManager,
    private val apiService: Lazy<ApiService>

) : Interceptor {



    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val accessToken = tokenManager.getAccessToken()

        // 1. accessToken이 있으면 Authorization 헤더에 추가
        if (!accessToken.isNullOrBlank()) {
            request = request.newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()
        }

        var response = chain.proceed(request)

        // 2. 만약 401(Unauthorized)이면 refresh 시도 (자동 갱신)
        if (response.code == 401) {
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
                    response = chain.proceed(newRequest)
                } else {
                    // 리프레시도 실패 → 로그아웃 처리 등 (토큰 삭제)
                    tokenManager.clearTokens()
                }
            }
        }
        return response
    }

    // 토큰 새로고침 함수
    suspend fun refreshTokenIfNeeded(tokenManager: TokenManager, apiService: ApiService): Boolean {
        val refreshToken = tokenManager.getRefreshToken() ?: return false
        val response = apiService.refreshToken(RefreshTokenRequest(refreshToken))
        return if (response.isSuccessful && response.body() != null) {
            val tokenRes = response.body()!!
            tokenManager.saveTokens(tokenRes.accessToken, tokenRes.refreshToken)
            true
        } else {
            tokenManager.clearTokens()
            false
        }
    }
}

//package kr.ac.uc.test_2025_05_19_k.network
//
//import android.content.Context
//import android.util.Log
//import okhttp3.Interceptor
//import okhttp3.Response
//
//class AuthInterceptor(private val context: Context) : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val prefs = context.getSharedPreferences("auth", Context.MODE_PRIVATE)
//        val token = prefs.getString("accessToken", null)
//
//        // ✅ 토큰 로그 출력
//        Log.d("AuthInterceptor", "accessToken: $token")
//
//        val requestBuilder = chain.request().newBuilder()
//
//        if (!token.isNullOrEmpty()) {
//            requestBuilder.addHeader("Authorization", "Bearer $token")
//        }
//
//        return chain.proceed(requestBuilder.build())
//    }
//}
