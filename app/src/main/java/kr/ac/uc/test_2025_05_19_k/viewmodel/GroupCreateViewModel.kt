package kr.ac.uc.test_2025_05_19_k.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequestDto
import kr.ac.uc.test_2025_05_19_k.repository.GroupRepository
import kr.ac.uc.test_2025_05_19_k.data.local.UserPreference
import javax.inject.Inject

@HiltViewModel
class GroupCreateViewModel @Inject constructor(
    application: Application,
    private val groupRepository: GroupRepository
) : AndroidViewModel(application) {

    private val userPreference = UserPreference(application)

    fun createGroup(
        title: String,
        description: String,
        requirements: String?,
        interest: String,
        maxMembers: Int,
        startDate: String,
        endDate: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val location = userPreference.getLocation()

        val request = GroupCreateRequestDto(
            title = title,
            description = description,
            requirements = requirements ?: "",
            interest = interest,
            maxMembers = maxMembers,
            locationName = location,
            startDate = startDate,
            endDate = endDate
        )

        viewModelScope.launch {
            try {
                groupRepository.createGroup(request)
                onSuccess()
            } catch (e: Exception) {
                Log.e("GroupCreate", "생성 실패: ${e.message}")
                onError(e.message ?: "알 수 없는 오류")
            }
        }
    }
}