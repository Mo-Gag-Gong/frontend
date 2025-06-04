// app/src/main/java/kr/ac/uc/test_2025_05_19_k/ui/group/GroupManagementScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.group

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun GroupManagementScreen(navController: NavController) {
    // 실제 그룹 관리 화면 구현 필요 (desgin.pdf page 13 참고 - 참여한 그룹/만든 그룹 탭)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("그룹 관리 화면", style = MaterialTheme.typography.headlineMedium)
        Text("참여한 그룹과 만든 그룹 목록이 표시될 예정입니다.", style = MaterialTheme.typography.bodyLarge)
    }
}