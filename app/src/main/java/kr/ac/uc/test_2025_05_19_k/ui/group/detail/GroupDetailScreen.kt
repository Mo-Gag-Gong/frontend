package kr.ac.uc.test_2025_05_19_k.ui.group.detail

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.ac.uc.test_2025_05_19_k.viewmodel.GroupDetailViewModel

@Composable
fun GroupDetailScreen(
    groupId: Long,
    viewModel: GroupDetailViewModel = viewModel(),
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val groupDetail by viewModel.groupDetail.collectAsState()
    val applySuccess by viewModel.applySuccess.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadGroupDetail(groupId)
    }

    applySuccess?.let {
        if (it) {
            Toast.makeText(context, "가입 신청 완료", Toast.LENGTH_SHORT).show()
            viewModel.resetApplyStatus()
        } else {
            Toast.makeText(context, "가입 신청 실패", Toast.LENGTH_SHORT).show()
            viewModel.resetApplyStatus()
        }
    }

    groupDetail?.let { group ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            Text(text = group.name, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = group.description)
            Spacer(modifier = Modifier.height(16.dp))

            if (group.alreadyApplied) {
                Text(
                    text = "가입 신청 완료",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                Button(
                    onClick = { viewModel.applyToGroup(group.id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("가입 신청")
                }
            }
        }
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
