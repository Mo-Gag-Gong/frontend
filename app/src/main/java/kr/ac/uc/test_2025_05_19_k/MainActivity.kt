package kr.ac.uc.test_2025_05_19_k

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.*
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.uc.test_2025_05_19_k.R
import kr.ac.uc.test_2025_05_19_k.ui.signin.*;
import kr.ac.uc.test_2025_05_19_k.navigation.AppNavGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ✅ SharedPreferences에서 access_token 유무 확인
        val isLoggedIn = getSharedPreferences("auth", MODE_PRIVATE)
            .getString("access_token", null) != null

        setContent {
            // ✅ 토큰 있으면 바로 프로필 화면으로 이동
            val startDestination = if (isLoggedIn) "profile_input" else "login"
            AppNavGraph(startDestination)
        }
    }
}


