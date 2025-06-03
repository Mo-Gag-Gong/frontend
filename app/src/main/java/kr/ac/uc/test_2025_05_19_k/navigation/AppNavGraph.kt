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
import androidx.compose.runtime.remember // remember 추가
import androidx.compose.ui.platform.LocalContext // LocalContext 추가
import kr.ac.uc.test_2025_05_19_k.data.local.UserPreference // UserPreference import 추가
import kr.ac.uc.test_2025_05_19_k.ui.profile.SignInScreen //
import kr.ac.uc.test_2025_05_19_k.ui.gps.RegionSettingScreen //

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
    startDestination: String = "login" //
) {

    LogCurrentScreen(navController) //

    NavHost(navController = navController, startDestination = startDestination) {
        // 1. 로그인
        composable("login") {
            SignInScreen( //
                onNavigateNext = {
                    navController.navigate("profile_input") { //
                        popUpTo("login") { inclusive = true } //
                    }
                }
            )
        }
        // 2. 프로필 입력
        composable("profile_input") { //
            SignInProfileSettingScreen( //
                navController = navController,
                onNext = { name, gender, phone, birth ->
                    navController.navigate("interest_select/$name/$gender/$phone/$birth") //
                }
            )
        }
        // 3. 관심사 선택
        composable( //
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
            InterestSelectScreenHost( //
                userName = name,
                navController = navController,
                onNext = {
                    navController.navigate("gps_setting") { //
                        popUpTo("interest_select/{name}/{gender}/{phone}/{birth}") { inclusive = true } // 수정: popUpTo 경로 명시적 지정
                    }
                }
            )
        }
        // 4. 위치 권한 요청
        composable("gps_setting") { //
            val context = LocalContext.current
            // UserPreference는 @Singleton으로 Hilt에 의해 관리되지만,
            // NavGraph Composable에서 직접 주입받는 것은 일반적이지 않습니다.
            // 이 코드는 임시 방편이며, 원래는 ViewModel을 통해 UserPreference에 접근해야 합니다.
            val userPreference = remember { UserPreference(context) } //

            SignInGPSSettingScreen( //
                onBack = { navController.popBackStack() },
                onLocationGranted = {
                    // --- 임시 수정 로직 시작 ---
                    userPreference.saveLocation("울산") // 지역 정보 "울산"으로 강제 저장
                    userPreference.setOnboardingCompleted(true) // 온보딩 완료 처리

                    navController.navigate("home") { // 홈 화면으로 이동
                        popUpTo("gps_setting") { inclusive = true } // 현재 화면(gps_setting)은 스택에서 제거
                        // 필요시 이전 온보딩 스택 전체를 날리려면 popUpTo("login") 또는 popUpTo(navController.graph.findStartDestination().id) 등을 고려할 수 있습니다.
                        // 현재는 gps_setting 이전의 profile_input은 스택에 남아있게 됩니다.
                    }
                    // --- 임시 수정 로직 끝 ---

                    // // 원래 로직 주석 처리
                    // navController.navigate("region_setting") {
                    //     popUpTo("gps_setting") { inclusive = true }
                    // }
                }
            )
        }
        // 5. 지역 선택/확인 (현재는 이 화면으로 가지 않음)
        composable("region_setting") { //
            RegionSettingScreen( //
                navController = navController,
                onBack = { navController.popBackStack() },
                onDone = { region ->
                    // 이 부분은 userPreference를 통해 이미 저장되었으므로,
                    // 홈으로만 이동하도록 단순화하거나, 또는 현재 로직을 유지해도 됩니다.
                    // 여기서는 UserPreference 저장 로직이 이미 onLocationGranted에서 수행되었으므로,
                    // onDone 콜백은 중복 작업을 피하기 위해 홈으로만 이동하게 둘 수 있습니다.
                    navController.navigate("home") { //
                        popUpTo("region_setting") { inclusive = true } //
                    }
                }
            )
        }

        // ==== 그룹/홈 화면 영역 ====
        // 7. 홈 화면
        composable("home") { //
            HomeScreen( //
                onGroupClick = { groupId ->
                    navController.navigate("group_detail/$groupId") //
                },
                onCreateGroupClick = {
                    navController.navigate("group_create") //
                }
            )
        }
        // 8. 그룹 상세
        composable( //
            "group_detail/{groupId}",
            arguments = listOf(navArgument("groupId") { type = NavType.LongType })
        ) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getLong("groupId") ?: return@composable
            GroupDetailScreen(groupId = groupId, onBack = { navController.popBackStack() }) //
        }
        // 9. 그룹 생성
        composable("group_create") { //
            GroupCreateScreen(navController = navController) //
        }
    }
}