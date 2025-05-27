package kr.ac.uc.test_2025_05_19_k.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.ac.uc.test_2025_05_19_k.ui.group.create.GroupCreateScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.detail.GroupDetailScreen
import kr.ac.uc.test_2025_05_19_k.ui.home.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "home") {
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

        composable("groupDetail/{groupId}") { backStackEntry ->
            val groupId = backStackEntry.arguments?.getString("groupId")?.toLongOrNull() ?: return@composable
            GroupDetailScreen(groupId = groupId, onBack = { navController.popBackStack() })
        }

        composable("group_create") {
            GroupCreateScreen(navController = navController)
        }

    }
}
