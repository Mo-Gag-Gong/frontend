// app/src/main/java/kr/ac/uc/test_2025_05_19_k/navigation/AppNavGraph.kt
package kr.ac.uc.test_2025_05_19_k.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.material3.Text // Text 임포트 추가 (오류 처리용)
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import kr.ac.uc.test_2025_05_19_k.ui.home.HomeScreen
import kr.ac.uc.test_2025_05_19_k.ui.schedule.ScheduleScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.GroupManagementScreen
import kr.ac.uc.test_2025_05_19_k.ui.profile.MyProfileScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
import kr.ac.uc.test_2025_05_19_k.ui.profile.SignInScreen
import kr.ac.uc.test_2025_05_19_k.ui.profile.SignInProfileSettingScreen
import kr.ac.uc.test_2025_05_19_k.ui.profile.InterestSelectScreenHost
import kr.ac.uc.test_2025_05_19_k.ui.gps.SignInGPSSettingScreen
import kr.ac.uc.test_2025_05_19_k.ui.gps.RegionSettingScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.create.GroupCreateScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.detail.GroupDetailScreen // GroupDetailScreen 임포트 확인
import kr.ac.uc.test_2025_05_19_k.ui.search.SearchScreen
import kr.ac.uc.test_2025_05_19_k.ui.search.SearchResultScreen
import kotlinx.coroutines.delay
import kr.ac.uc.test_2025_05_19_k.ui.group.GroupAdminDetailScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.GroupEditScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.NoticeCreateScreen
import java.net.URLDecoder // URL 디코딩을 위해 추가
import java.net.URLEncoder // URL 인코딩을 위해 추가
import java.nio.charset.StandardCharsets
import kr.ac.uc.test_2025_05_19_k.ui.group.NoticeEditScreen


// 현재 화면 로깅을 위한 Composable 함수 (이전과 동일)
@Composable
fun LogCurrentScreen(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    LaunchedEffect(Unit) {
        while (true) {
            val currentRoute = navBackStackEntry?.destination?.route
            Log.d("CurrentScreenLogger", "현재 화면(route): $currentRoute")
            delay(10000L)
        }
    }
}

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    LogCurrentScreen(navController)

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        // ... (login, profile_input, interest_select, gps_setting, region_setting 라우트 동일) ...
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
                    navController.navigate("interest_select/$name/$gender/$phone/$birth")
                }
            )
        }
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
                        popUpTo("interest_select/$name/$gender/$phone/$birth") {
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
            route = "group_detail/{groupId}",
            arguments = listOf(navArgument("groupId") { type = NavType.LongType })
        ) { backStackEntry ->
            val groupIdArg = backStackEntry.arguments?.getLong("groupId") ?: -1L
            if (groupIdArg != -1L) {
                GroupDetailScreen(
                    navController = navController,
                    groupId = groupIdArg
                )
            } else {
                Text("오류: 유효하지 않은 그룹 ID입니다.")
            }
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
        // 그룹 편집 화면 라우트 (이전에 추가한 내용)
        composable(
            route = "group_edit/{groupId}",
            arguments = listOf(navArgument("groupId") { type = NavType.LongType })
        ) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getLong("groupId") ?: -1L
            if (groupId != -1L) {
                GroupEditScreen(navController = navController, groupId = groupId)
            } else {
                Text("오류: 유효하지 않은 그룹 ID 입니다.")
            }
        }
        composable(
            route = "group_admin_detail/{groupId}",
            arguments = listOf(navArgument("groupId") { type = NavType.LongType })
        ) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getLong("groupId") ?: -1L
            if (groupId != -1L) {
                GroupAdminDetailScreen(navController = navController, groupId = groupId)
            } else {
                Text("오류: 유효하지 않은 그룹 ID 입니다. (관리자 상세)")
            }
        }
        composable(
            route = "notice_create/{groupId}",
            arguments = listOf(navArgument("groupId") { type = NavType.LongType })
        ) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getLong("groupId") ?: -1L
            if (groupId != -1L) {
                NoticeCreateScreen(navController = navController, groupId = groupId)
            }
        }
        composable(
            route = "notice_edit/{groupId}/{noticeId}?title={title}&content={content}",
            arguments = listOf(
                navArgument("groupId") { type = NavType.LongType },
                navArgument("noticeId") { type = NavType.LongType },
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val groupId = backStackEntry.arguments?.getLong("groupId") ?: -1L
            val noticeId = backStackEntry.arguments?.getLong("noticeId") ?: -1L
            // URL로 전달된 문자열은 디코딩해야 할 수 있습니다.
            val title = backStackEntry.arguments?.getString("title")?.let { URLDecoder.decode(it, StandardCharsets.UTF_8.toString()) } ?: ""
            val content = backStackEntry.arguments?.getString("content")?.let { URLDecoder.decode(it, StandardCharsets.UTF_8.toString()) } ?: ""

            if (groupId != -1L && noticeId != -1L) {
                NoticeEditScreen(
                    navController = navController,
                    groupId = groupId,
                    noticeId = noticeId,
                    initialTitle = title,
                    initialContent = content
                )
            }
        }
    }
}