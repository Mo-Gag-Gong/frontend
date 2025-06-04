// app/src/main/java/kr/ac/uc/test_2025_05_19_k/MainActivity.kt
package kr.ac.uc.test_2025_05_19_k

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.uc.test_2025_05_19_k.data.local.UserPreference
import kr.ac.uc.test_2025_05_19_k.navigation.AppNavGraph
import kr.ac.uc.test_2025_05_19_k.navigation.BottomNavItem
import kr.ac.uc.test_2025_05_19_k.navigation.BottomNavigationBar
import kr.ac.uc.test_2025_05_19_k.navigation.bottomNavItems // bottomNavItems 임포트
import kr.ac.uc.test_2025_05_19_k.ui.theme.MogackoTheme
import kr.ac.uc.test_2025_05_19_k.repository.TokenManager
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userPreference: UserPreference
    @Inject
    lateinit var tokenManager: TokenManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MogackoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val isLoggedIn = tokenManager.hasValidToken()
                    val isOnboardingComplete = userPreference.isOnboardingCompleted()

                    val startDestination = when {
                        isLoggedIn && isOnboardingComplete -> BottomNavItem.Home.route
                        isLoggedIn && !isOnboardingComplete -> "profile_input" // 온보딩 라우트
                        else -> "login" // 로그인 라우트
                    }

                    MainScreen(
                        navController = navController,
                        startDestination = startDestination
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController, startDestination: String) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // 하단 네비게이션 바를 표시해야 하는 라우트인지 확인
    val shouldShowBottomBar = bottomNavItems.any { it.route == currentRoute }

    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        AppNavGraph(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding) // NavHost에 패딩 적용
        )
    }
}