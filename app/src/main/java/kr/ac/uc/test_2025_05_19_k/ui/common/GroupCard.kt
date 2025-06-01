package kr.ac.uc.test_2025_05_19_k.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.ac.uc.test_2025_05_19_k.model.group.StudyGroupResponseDto

@Composable
fun GroupCard(
    group: StudyGroupResponseDto, // 파라미터 타입을 StudyGroupResponseDto로 변경
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = group.title, // group.name에서 group.title로 변경
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = group.description, // 변경 없음
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row {
                Text(
                    text = "#${group.interestName}", // group.category에서 group.interestName으로 변경
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(end = 12.dp)
                )

                Text(
                    // group.memberCount에서 group.currentMembers로 변경
                    // 필요하다면 최대 인원도 함께 표시: "인원 ${group.currentMembers}/${group.maxMembers}명"
                    text = "인원 ${group.currentMembers}명",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}