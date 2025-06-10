// app/src/main/java/kr/ac/uc/test_2025_05_19_k/ui/profile/MyProfileScreen.kt
package kr.ac.uc.test_2025_05_19_k.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import kr.ac.uc.test_2025_05_19_k.repository.TokenManager
import kr.ac.uc.test_2025_05_19_k.viewmodel.UserProfileViewModel



@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyProfileScreen(

    viewModel: UserProfileViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val profileState = viewModel.userProfile.value



    LaunchedEffect(Unit) {
        viewModel.loadUserProfile()
    }


    // 초기 로딩 or null 상태 예외 처리
    if (profileState == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    val profile = profileState!!

    Column(modifier = Modifier.padding(16.dp)) {
        Text("마이 프로필", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))

        // 🔹 사용자 정보 카드
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation()
        ) {
            Box {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = rememberAsyncImagePainter(profile.profileImage),
                            contentDescription = "프로필",
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(profile.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                            Text("성별: ${profile.gender ?: "미입력"}")
                            Text("전화번호: ${profile.phoneNumber ?: "미입력"}")
                            Text("생년월일: ${profile.birthYear ?: "미입력"}")
                        }
                    }
                }

                IconButton(
                    onClick = { /* 정보 수정 */ },
                    modifier = Modifier.align(Alignment.TopEnd).padding(8.dp)
                ) {
                    Icon(Icons.Default.Edit, contentDescription = "정보 수정")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 관심사 카드
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation()
        ) {
            Box {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("“${profile.name}”의 관심사", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(12.dp))

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        profile.interests.forEach {
                            Button(
                                onClick = {},
                                shape = RoundedCornerShape(20.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
                            ) {
                                Text(it.interestName)
                            }
                        }
                    }
                }

                IconButton(
                    onClick = { /* 관심사 수정 */ },
                    modifier = Modifier.align(Alignment.TopEnd).padding(8.dp)
                ) {
                    Icon(Icons.Default.Edit, contentDescription = "관심사 수정")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 통계 카드
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("통계", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("그룹 참여 횟수: ${profile.groupParticipationCount}회")
                Text("총 모임 수: ${profile.totalMeetings}회")
                Text("출석률: ${profile.attendanceRate}%")
            }
        }
    }
}




@Preview(showBackground = true, name = "MyProfileScreen Preview")
@Composable
fun MyProfileScreenPreview() {
    MyProfileScreen(navController = NavController(LocalContext.current) as NavHostController)
}
