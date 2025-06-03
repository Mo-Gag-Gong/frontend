package kr.ac.uc.test_2025_05_19_k.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import kr.ac.uc.test_2025_05_19_k.ui.*
import kr.ac.uc.test_2025_05_19_k.ui.gps.RegionSettingScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.create.GroupCreateScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.detail.GroupDetailScreen
import kr.ac.uc.test_2025_05_19_k.ui.home.HomeScreen
import kr.ac.uc.test_2025_05_19_k.ui.profile.SignInProfileSettingScreen
import kr.ac.uc.test_2025_05_19_k.ui.gps.SignInGPSSettingScreen
import kr.ac.uc.test_2025_05_19_k.ui.profile.InterestSelectScreenHost
import kr.ac.uc.test_2025_05_19_k.ui.profile.SignInScreen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import android.util.Log
import kotlinx.coroutines.delay



@Composable
fun LogCurrentScreen(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // 10초마다 현재 route를 로그로 출력
    LaunchedEffect(Unit) {
        while (true) {
            val currentRoute = navBackStackEntry?.destination?.route
            Log.d("CurrentScreenLogger", "현재 화면(route): $currentRoute")
            delay(10_00L)
        }
    }
}



@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "login"


) {

    LogCurrentScreen(navController)

    NavHost(navController = navController, startDestination = startDestination) {
        // 1. 로그인
        composable("login") {
            SignInScreen(
                onNavigateNext = {
                    navController.navigate("profile_input") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        // 2. 프로필 입력
        composable("profile_input") {
            SignInProfileSettingScreen(
                navController = navController,  // ← 이 줄 추가!
                onNext = { name, gender, phone, birth ->
                    navController.navigate("interest_select/$name/$gender/$phone/$birth")
                }
            )
        }
        // 3. 관심사 선택
        composable(
            "interest_select/{name}/{gender}/{phone}/{birth}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("gender") { type = NavType.StringType },
                navArgument("phone") { type = NavType.StringType },
                navArgument("birth") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val gender = backStackEntry.arguments?.getString("gender") ?: ""
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            val birth = backStackEntry.arguments?.getString("birth") ?: ""
            InterestSelectScreenHost(
                userName = name,
                navController = navController,
                onNext = {
                    navController.navigate("gps_setting") {
                        popUpTo("interest_select") { inclusive = true }
                    }
                }
            )

        }
        // 4. 위치 권한 요청
        composable("gps_setting") {
            SignInGPSSettingScreen(
                onBack = { navController.popBackStack() },
                onLocationGranted = {
                    navController.navigate("region_setting") {
                        popUpTo("gps_setting") { inclusive = true }
                    }
                }
            )
        }
        // 5. 지역 선택/확인
        composable("region_setting") {
            // hiltViewModel() 자동 주입 (RegionSettingScreen 파라미터에서 직접 사용)
            RegionSettingScreen(
                navController = navController,
                onBack = { navController.popBackStack() },    // ← 뒤로가기
                onDone = { region ->
                    navController.navigate("home") {          // ← 홈으로 이동
                        popUpTo("region_setting") { inclusive = true }
                    }
                }
                // viewModel은 RegionSettingScreen 내부에서 hiltViewModel()로 주입
            )
        }


        // ==== 그룹/홈 화면 영역 ====
        // 7. 홈 화면
        composable("home") {
            HomeScreen(
                onGroupClick = { groupId ->
                    navController.navigate("group_detail/$groupId")
                },
                onCreateGroupClick = {
                    navController.navigate("group_create")
                }
            )
        }
        // 8. 그룹 상세
        composable(
            "group_detail/{groupId}",
            arguments = listOf(navArgument("groupId") { type = NavType.LongType })
        ) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getLong("groupId") ?: return@composable
            GroupDetailScreen(groupId = groupId, onBack = { navController.popBackStack() })
        }
        // 9. 그룹 생성
        composable("group_create") {
            GroupCreateScreen(navController = navController)
        }
    }
}
