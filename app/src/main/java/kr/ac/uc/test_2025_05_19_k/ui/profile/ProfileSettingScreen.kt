package kr.ac.uc.test_2025_05_19_k.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.material3.TextField
import kr.ac.uc.test_2025_05_19_k.R


@Composable
fun SignInProfileSettingScreen() {
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf<String?>(null) }
    var phone by remember { mutableStateOf("") }
    var birth by remember { mutableStateOf("") }

    val textFieldColors = TextFieldDefaults.colors(
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedContainerColor = Color(0xFFF1F1F1),
        unfocusedContainerColor = Color(0xFFF1F1F1)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 상단 앱바
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            Button(
                onClick = { /* 다음 버튼 처리 */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
            ) {
                Text("다음", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 환영 메시지
        Text("모각공에 오신 것을 환영합니다!", fontWeight = FontWeight.Bold)
        Text("이제부터 당신에 대해 알려주세요!", fontSize = 13.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // 캐릭터 이미지
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.White, CircleShape)
                .border(1.dp, Color.Black, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.log), // 이미지 리소스
                contentDescription = "Logo",
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 이름
        InputLabel("이름")
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("이름을 입력하세요") },
            colors = textFieldColors
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 성별
        InputLabel("성별")
        Row(modifier = Modifier.fillMaxWidth()) {
            GenderButton("남", gender == "남") { gender = "남" }
            Spacer(modifier = Modifier.width(8.dp))
            GenderButton("여", gender == "여") { gender = "여" }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 전화번호
        InputLabel("전화번호")
        TextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("전화번호 입력") },
            colors = textFieldColors
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 생년월일
        InputLabel("생년월일")
        TextField(
            value = birth,
            onValueChange = { birth = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("예: 2004-05-24") },
            colors = textFieldColors
        )
    }
}

// 레이블 텍스트 공통 처리
@Composable
fun InputLabel(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}

// 성별 버튼 (RowScope 확장 필요)
@Composable
fun RowScope.GenderButton(label: String, selected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.weight(1f),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color.Cyan else Color.LightGray
        )
    ) {
        Text(label, color = if (selected) Color.White else Color.Black)
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewProfileInputScreen() {
    SignInProfileSettingScreen()
}
