package kr.ac.uc.test_2025_05_19_k

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.uc.test_2025_05_19_k.navigation.AppNavGraph
import kr.ac.uc.test_2025_05_19_k.ui.theme.MogackoTheme

import kr.ac.uc.test_2025_05_19_k.data.local.UserPreference

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --- 테스트를 위한 임시 코드 시작 ---
        // !!주의!! 테스트 완료 후 이 부분은 반드시 제거하거나 주석 처리해야 합니다.

        // 1. SharedPreferences 키 이름 통일 (AuthInterceptor와 맞추기)
        //    AuthInterceptor가 "accessToken"을 사용한다면 아래 키도 "accessToken"으로,
        //    "access_token"을 사용한다면 아래 키도 "access_token"으로 맞춰주세요.
        //    여기서는 "access_token"을 사용한다고 가정 (AuthCallbackActivity 기준)
        val tokenKeyForInterceptor = "access_token" // 또는 "accessToken" - Interceptor와 일치시킬 것

        // 가지고 있는 유효한 액세스 토큰을 여기에 입력
        val myValidAccessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2NSIsImVtYWlsIjoieXVoeXVuanVuMDhAZ21haWwuY29tIiwicm9sZSI6IlJPTEVfR1VFU1QiLCJ0b2tlblR5cGUiOiJBQ0NFU1MiLCJpYXQiOjE3NDg3ODIyMjksImV4cCI6MTc0ODg2ODYyOX0.3568su3OMkVGkuXLUJMwMksOZD_7rZzkJLVDXRPSlFQ"
        val myValidRefreshToken = "refreshToken\": \"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2NSIsInRva2VuVHlwZSI6IlJFRlJFU0giLCJpYXQiOjE3NDgzMTQ3MTEsImV4cCI6MTc3OTg1MDcxMX0.rKTwQoNJeN5yPMy392P8WJwMODnpTrRVDYPszJd37DM" // 필요하다면
        val myUserId = "65" // 필요하다면

        // "auth" SharedPreferences에 토큰 저장 (AuthCallbackActivity, AuthInterceptor가 사용하는 파일)
        val authPrefs = getSharedPreferences("auth", Context.MODE_PRIVATE)
        with(authPrefs.edit()) {
            putString(tokenKeyForInterceptor, myValidAccessToken)
            // 필요에 따라 refreshToken과 userId도 저장
            // putString("refresh_token", myValidRefreshToken)
            // putString("user_id", myUserId)
            apply()
        }

        // UserPreference에 테스트용 위치 정보 저장 (HomeViewModel에서 사용)
        val userPreference = UserPreference(applicationContext)
        userPreference.saveLocation("울산광역시 남구") // 테스트하고 싶은 지역명 입력

        // --- 테스트를 위한 임시 코드 종료 ---
        setContent {
            MogackoTheme {
                AppNavGraph()
            }
        }
    }
}
