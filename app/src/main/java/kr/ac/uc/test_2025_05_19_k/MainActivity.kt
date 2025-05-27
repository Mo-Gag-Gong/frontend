package kr.ac.uc.test_2025_05_19_k

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.uc.test_2025_05_19_k.navigation.AppNavGraph
import kr.ac.uc.test_2025_05_19_k.ui.theme.MogackoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MogackoTheme {
                AppNavGraph()
            }
        }
    }
}
