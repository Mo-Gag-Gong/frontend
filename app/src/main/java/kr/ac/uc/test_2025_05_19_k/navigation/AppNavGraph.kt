// app/src/main/java/kr/ac/uc/test_2025_05_19_k/navigation/AppNavGraph.kt
package kr.ac.uc.test_2025_05_19_k.navigation

import android.util.Log // Log 임포트 추가
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect // LaunchedEffect 임포트 추가
import androidx.compose.runtime.getValue // getValue 임포트 추가
import androidx.compose.ui.Modifier
import androidx.navigation.NavController // NavController 임포트 (NavHostController의 상위 인터페이스)
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState // currentBackStackEntryAsState 임포트 추가
// ... 기존 import ...
import kr.ac.uc.test_2025_05_19_k.ui.home.HomeScreen
import kr.ac.uc.test_2025_05_19_k.ui.schedule.ScheduleScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.GroupManagementScreen
import kr.ac.uc.test_2025_05_19_k.ui.profile.MyProfileScreen
// ... 나머지 화면 import ...
import androidx.navigation.NavType
import androidx.navigation.navArgument
import kr.ac.uc.test_2025_05_19_k.ui.profile.SignInScreen
import kr.ac.uc.test_2025_05_19_k.ui.profile.SignInProfileSettingScreen
import kr.ac.uc.test_2025_05_19_k.ui.profile.InterestSelectScreenHost
import kr.ac.uc.test_2025_05_19_k.ui.gps.SignInGPSSettingScreen
import kr.ac.uc.test_2025_05_19_k.ui.gps.RegionSettingScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.create.GroupCreateScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.detail.GroupDetailScreen
import kr.ac.uc.test_2025_05_19_k.ui.search.SearchScreen
import kr.ac.uc.test_2025_05_19_k.ui.search.SearchResultScreen
import kotlinx.coroutines.delay // delay 임포트 추가


// 현재 화면 로깅을 위한 Composable 함수
@Composable
fun LogCurrentScreen(navController: NavController) { // NavController 타입 사용 가능
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // LaunchedEffect를 사용하여 현재 route를 주기적으로 로그로 출력 (디버깅용)
    // 실제 프로덕션 코드에서는 제거하거나 필요에 따라 조건부로 실행하는 것이 좋습니다.
    LaunchedEffect(Unit) {
        while (true) {
            val currentRoute = navBackStackEntry?.destination?.route
            Log.d("CurrentScreenLogger", "현재 화면(route): $currentRoute")
            delay(10000L) // 10초 간격 (기존 1000L에서 변경)
        }
    }
}

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {

    LogCurrentScreen(navController) // 여기에서 LogCurrentScreen 함수 호출

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        // --- 기존 온보딩/로그인 라우트 ---
        composable("login") {
            SignInScreen(
                onNavigateNext = {
                    navController.navigate("profile_input") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("profile_input") {
            SignInProfileSettingScreen(
                navController = navController,
                onNext = { name, gender, phone, birth ->
                    // gender, phone, birth 인자도 함께 전달하도록 수정
                    navController.navigate("interest_select/$name/$gender/$phone/$birth")
                }
            )
        }
        composable(
            "interest_select/{name}/{gender}/{phone}/{birth}", // gender, phone, birth 인자 추가
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("gender") { type = NavType.StringType }, // gender 인자 정의
                navArgument("phone") { type = NavType.StringType },  // phone 인자 정의
                navArgument("birth") { type = NavType.StringType }   // birth 인자 정의
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            // gender, phone, birth 값도 필요시 여기서 가져와서 InterestSelectScreenHost로 전달 가능
            // val gender = backStackEntry.arguments?.getString("gender") ?: ""
            // val phone = backStackEntry.arguments?.getString("phone") ?: ""
            // val birth = backStackEntry.arguments?.getString("birth") ?: ""
            InterestSelectScreenHost(
                userName = name,
                navController = navController,
                onNext = {
                    navController.navigate("gps_setting") {
                        // popUpTo 경로 수정: 모든 파라미터를 포함한 정확한 경로 또는 ID 사용
                        popUpTo("interest_select/${name}/${backStackEntry.arguments?.getString("gender") ?: ""}/${backStackEntry.arguments?.getString("phone") ?: ""}/${backStackEntry.arguments?.getString("birth") ?: ""}") {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable("gps_setting") {
            SignInGPSSettingScreen(
                onBack = { navController.popBackStack() },
                onLocationGranted = {
                    navController.navigate(BottomNavItem.Home.route) {
                        popUpTo("gps_setting") { inclusive = true }
                    }
                }
            )
        }
        composable("region_setting") {
            RegionSettingScreen(
                navController = navController,
                onBack = { navController.popBackStack() },
                onDone = {
                    navController.navigate(BottomNavItem.Home.route) {
                        popUpTo("region_setting") { inclusive = true }
                    }
                }
            )
        }

        // --- 하단 네비게이션 바 대상 화면 ---
        composable(BottomNavItem.Home.route) {
            HomeScreen(
                navController = navController,
                onGroupClick = { groupId ->
                    navController.navigate("group_detail/$groupId")
                },
                onCreateGroupClick = {
                    navController.navigate("group_create")
                },
                onNavigateToSearch = {
                    navController.navigate("search")
                }
            )
        }
        composable(BottomNavItem.Schedule.route) {
            ScheduleScreen(navController = navController)
        }
        composable(BottomNavItem.GroupManagement.route) {
            GroupManagementScreen(navController = navController)
        }
        composable(BottomNavItem.MyProfile.route) {
            MyProfileScreen(navController = navController)
        }

        // --- 기타 화면 라우트 ---
        composable(
            "group_detail/{groupId}",
            arguments = listOf(navArgument("groupId") { type = NavType.LongType })
        ) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getLong("groupId") ?: return@composable
            GroupDetailScreen(groupId = groupId, onBack = { navController.popBackStack() })
        }
        composable("group_create") {
            GroupCreateScreen(navController = navController)
        }
        composable("search") {
            SearchScreen(
                navController = navController,
                onSearch = { query ->
                    navController.navigate("search_result/${query}")
                }
            )
        }
        composable(
            "search_result/{query}",
            arguments = listOf(navArgument("query") { type = NavType.StringType })
        ) { backStackEntry ->
            val query = backStackEntry.arguments?.getString("query") ?: ""
            SearchResultScreen(
                navController = navController,
                searchQuery = query,
                onGroupClick = { groupId ->
                    navController.navigate("group_detail/$groupId")
                }
            )
        }
    }
}