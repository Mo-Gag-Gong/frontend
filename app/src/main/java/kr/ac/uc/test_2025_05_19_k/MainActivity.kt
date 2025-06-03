package kr.ac.uc.test_2025_05_19_k

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.uc.test_2025_05_19_k.navigation.AppNavGraph
import kr.ac.uc.test_2025_05_19_k.ui.theme.MogackoTheme

import kr.ac.uc.test_2025_05_19_k.data.local.UserPreference
import kr.ac.uc.test_2025_05_19_k.repository.TokenManager

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MogackoTheme {
                // 1. TokenManager 준비 (context 넘김)
                val tokenManager = TokenManager(applicationContext)
                // 2. 토큰이 있으면 바로 프로필 입력부터 시작!
                val startDestination =
                    if (tokenManager.hasValidToken()) "profile_input" else "login"
                AppNavGraph(startDestination = startDestination)
            }
        }
    }
}