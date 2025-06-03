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
import kr.ac.uc.test_2025_05_19_k.model.StudyGroup

@Composable
fun GroupCard(
    group: StudyGroup,
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
                text = group.title, // 'name'에서 'title'로 변경
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            // group.description 필드는 StudyGroup 모델에 그대로 존재한다고 가정합니다.
            // 만약 StudyGroup 모델에서 description 필드명이 변경되었다면 이 부분도 수정해야 합니다.
            Text(
                text = group.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row {
                Text(
                    text = "#${group.interestName}", // 'category'에서 'interestName'으로 변경
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(end = 12.dp)
                )

                Text(
                    text = "인원 ${group.currentMembers}명", // 'memberCount'에서 'currentMembers'로 변경
                    style = MaterialTheme.typography.labelSmall
                )
                // 만약 최대 인원도 표시하고 싶다면, StudyGroup 모델에 maxMembers 필드가 있는지 확인 후 추가할 수 있습니다.
                // 예: text = "인원 ${group.currentMembers}/${group.maxMembers}명"
            }
        }
    }
}