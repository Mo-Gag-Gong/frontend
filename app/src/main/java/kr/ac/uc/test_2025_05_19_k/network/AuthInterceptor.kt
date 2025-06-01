//package kr.ac.uc.test_2025_05_19_k.network
//
//import android.content.Context
//import okhttp3.Interceptor
//import okhttp3.Response
//
//// Interceptor를 상속받아 accessToken을 요청 헤더에 자동으로 붙여주는 클래스 정의
//class AuthInterceptor(private val context: Context) : Interceptor {
//
//    // 요청 가로채기 함수 오버라이드
//    override fun intercept(chain: Interceptor.Chain): Response {
//        // SharedPreferences에서 저장된 accessToken을 가져옴
//        val token = context.getSharedPreferences("auth", Context.MODE_PRIVATE)
//            .getString("access_token", null)
//
//        // token이 존재하면 Authorization 헤더 추가
//        val newRequest = if (token != null) {
//            chain.request().newBuilder()
//                .addHeader("Authorization", "Bearer $token") // 토큰 붙이기
//                .build()
//        } else {
//            chain.request() // 토큰 없으면 원래 요청 그대로 사용
//        }
//
//        // 실제 네트워크 요청 진행
//        return chain.proceed(newRequest)
//    }
//}

package kr.ac.uc.test_2025_05_19_k.network

import android.content.Context
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val prefs = context.getSharedPreferences("auth", Context.MODE_PRIVATE)
        val token = prefs.getString("access_token", null)

        // ✅ 토큰 로그 출력
        Log.d("AuthInterceptor", "accessToken: $token")

        val requestBuilder = chain.request().newBuilder()

        if (!token.isNullOrEmpty()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(requestBuilder.build())
    }
}
