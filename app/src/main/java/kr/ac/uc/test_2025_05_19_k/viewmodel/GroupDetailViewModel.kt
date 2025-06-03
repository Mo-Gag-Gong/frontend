package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel // HiltViewModel import 추가
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail
import kr.ac.uc.test_2025_05_19_k.repository.GroupRepository
import javax.inject.Inject

@HiltViewModel // 이 어노테이션을 추가해주세요
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
                // 이미 신청된 상태로 UI를 즉시 업데이트 하기 위해 StudyGroupDetail 모델의 alreadyApplied 필드를 true로 변경
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