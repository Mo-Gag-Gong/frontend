package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.network.StudyGroupDetail
import kr.ac.uc.test_2025_05_19_k.repository.GroupRepository
import javax.inject.Inject

class GroupDetailViewModel @Inject constructor(
    private val groupRepository: GroupRepository
) : ViewModel() {

    private val _groupDetail = MutableStateFlow<StudyGroupDetail?>(null)
    val groupDetail: StateFlow<StudyGroupDetail?> = _groupDetail

    private val _applySuccess = MutableStateFlow<Boolean?>(null)
    val applySuccess: StateFlow<Boolean?> = _applySuccess

    fun loadGroupDetail(groupId: Long) {
        viewModelScope.launch {
            _groupDetail.value = groupRepository.getGroupDetail(groupId)
        }
    }

    fun applyToGroup(groupId: Long) {
        viewModelScope.launch {
            try {
                groupRepository.applyToGroup(groupId)
                _applySuccess.value = true
                _groupDetail.update { it?.copy(alreadyApplied = true) }
            } catch (e: Exception) {
                _applySuccess.value = false
            }
        }
    }

    fun resetApplyStatus() {
        _applySuccess.value = null
    }
}
