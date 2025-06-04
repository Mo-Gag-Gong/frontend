// app/src/main/java/kr/ac/uc/test_2025_05_19_k/MainActivity.kt
package kr.ac.uc.test_2025_05_19_k

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.uc.test_2025_05_19_k.data.local.UserPreference //
import kr.ac.uc.test_2025_05_19_k.navigation.AppNavGraph //
import kr.ac.uc.test_2025_05_19_k.ui.theme.MogackoTheme //
import kr.ac.uc.test_2025_05_19_k.repository.TokenManager
import javax.inject.Inject

@AndroidEntryPoint // Hilt를 사용한 의존성 주입을 위해 필요
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userPreference: UserPreference // UserPreference 주입
    @Inject
    lateinit var tokenManager: TokenManager // TokenManager 주입

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MogackoTheme { //
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 로그인 상태 및 온보딩 완료 상태 확인
                    val isLoggedIn = tokenManager.hasValidToken() // TokenManager로 로그인 상태 확인
                    val isOnboardingComplete = userPreference.isOnboardingCompleted() //

                    // 시작 화면 동적 결정
                    val startDestination = when {
                        isLoggedIn && isOnboardingComplete -> "home" // 로그인 O, 온보딩 O -> 홈 화면
                        isLoggedIn && !isOnboardingComplete -> {
                            // 로그인 O, 온보딩 X -> 온보딩 첫 화면 또는 중간 화면
                            // (여기서는 예시로 profile_input으로 설정, 필요시 더 세분화된 로직 추가 가능)
                            // 예를 들어, UserPreference에 마지막 온보딩 단계를 저장하고 불러올 수 있습니다.
                            "profile_input" //
                        }
                        else -> "login" // 로그인 X -> 로그인 화면
                    }

                    AppNavGraph(startDestination = startDestination) //
                }
            }
        }
    }
}