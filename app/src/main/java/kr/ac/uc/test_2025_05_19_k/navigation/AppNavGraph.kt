package kr.ac.uc.test_2025_05_19_k.navigation

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kr.ac.uc.test_2025_05_19_k.R
import kr.ac.uc.test_2025_05_19_k.ui.group.create.GroupCreateScreen
import kr.ac.uc.test_2025_05_19_k.ui.group.detail.GroupDetailScreen
import kr.ac.uc.test_2025_05_19_k.ui.home.HomeScreen
import kr.ac.uc.test_2025_05_19_k.ui.signin.InterestSelectScreenHost
import kr.ac.uc.test_2025_05_19_k.ui.signin.OnboardingDoneScreen
import kr.ac.uc.test_2025_05_19_k.ui.signin.SignInProfileSettingScreen

@Composable
fun AppNavGraph( startDestination: String = "login") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
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
                        onRegisterInterest = { selectedInterests ->
                            // 관심사 선택 후 → 위치 권한 요청
                            navController.navigate("gps_setting") {
                                popUpTo("interest_select") { inclusive = true }
                            }
                            true
                        }
                    )
                }
                // 4. 위치 권한 요청
//        composable("gps_setting") {
//            SignInGPSSettingScreen(
//                onBack = { navController.popBackStack() },
//                onLocationGranted = {
//                    // 위치 권한 허용 시 → 지역 선택 화면
//                    navController.navigate("region_setting") {
//                        popUpTo("gps_setting") { inclusive = true }
//                    }
//                }
//            )
//        }
                // 5. 지역 선택/확인
                /*composable("region_setting") {
                    RegionSettingScreen(
                        onBack = { navController.popBackStack() },
                        onDone = {
                            // 지역 설정 완료 시 온보딩 완료
                            navController.navigate("onboarding_done") {
                                popUpTo("region_setting") { inclusive = true }
                            }
                        },
                        onSearch = { /* 지역 검색 기능 구현 */ }
                    )
                }*/
                // 6. 온보딩 완료
                composable("onboarding_done") {
                    OnboardingDoneScreen(navController)
                }
            }
        }




        @Composable
        fun SignInScreen(onNavigateNext: () -> Unit = {}) {
            val context = LocalContext.current

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                Image(
                    painter = painterResource(id = R.drawable.log),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Mo-Gag-Gong", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Create an account\n")
                        }
                        append("Enter your email to sign up for this app")
                    },
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                GoogleLoginButton {
                    Google_Login(context)
                    onNavigateNext()
                }

                Spacer(modifier = Modifier.height(22.dp))

                Text(
                    buildAnnotatedString {
                        append("By clicking continue, you agree to our")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(" Terms of Service and Privacy Policy ")
                        }
                    },
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        @Composable
        fun GoogleLoginButton(onClick: () -> Unit) {
            Button(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB4B4B4))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.log),
                    contentDescription = "Google Logo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Continue with Google", color = Color.Black)
            }
        }

        // 🌐 Google OAuth 로그인 실행
        fun Google_Login(context: Context) {
            val loginUrl =
                "http://springboot-developer-env.eba-mikwqecm.ap-northeast-2.elasticbeanstalk.com/oauth2/authorization/google"

            val customTabsIntent = CustomTabsIntent.Builder()
                .setShowTitle(true)
                .build()

            customTabsIntent.launchUrl(context, Uri.parse(loginUrl))
        }

        @Preview(showBackground = true)
        @Composable
        fun PreviewSignInScreen() {
            SignInScreen()
        }


