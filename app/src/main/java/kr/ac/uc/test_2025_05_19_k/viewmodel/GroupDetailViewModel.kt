package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.model.group.StudyGroupResponseDto
import kr.ac.uc.test_2025_05_19_k.repository.GroupRepository
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class GroupDetailViewModel @Inject constructor(
    private val groupRepository: GroupRepository
) : ViewModel() {

    private val _groupDetail = MutableStateFlow<StudyGroupResponseDto?>(null)
    val groupDetail: StateFlow<StudyGroupResponseDto?> = _groupDetail

    private val _applySuccess = MutableStateFlow<Boolean?>(null)
    val applySuccess: StateFlow<Boolean?> = _applySuccess

    private val _isAlreadyApplied = MutableStateFlow<Boolean>(false)
    val isAlreadyApplied: StateFlow<Boolean> = _isAlreadyApplied

    fun loadGroupDetail(groupId: Long) {
        viewModelScope.launch {
            try {
                val detail = groupRepository.getGroupDetail(groupId)
                _groupDetail.value = detail
                // 여기서 추가적으로 사용자의 가입 상태를 확인하는 로직을 넣을 수 있습니다.
                // 예: checkApplicationStatus(groupId)
            } catch (e: Exception) {
                _groupDetail.value = null // 또는 오류 상태 별도 관리
            }
        }
    }

    // 예시: 사용자의 해당 그룹 가입 신청 상태를 확인하는 함수
    // 실제 구현은 API 명세에 따라 달라집니다. (예: GET /api/groups/{groupId}/members/me)
    // fun checkApplicationStatus(groupId: Long) {
    //     viewModelScope.launch {
    //         try {
    //             // val userMembershipStatus = groupRepository.getUserMembershipStatus(groupId)
    //             // _isAlreadyApplied.value = userMembershipStatus.isApplied() // DTO 구조에 따라
    //         } catch (e: Exception) {
    //             _isAlreadyApplied.value = false // 오류 발생 시 기본값
    //         }
    //     }
    // }


    fun applyToGroup(groupId: Long) {
        viewModelScope.launch {
            try {
                groupRepository.applyToGroup(groupId) // 반환값이 있다면 활용
                _applySuccess.value = true
                // 가입 신청 성공 후, 상세 정보를 다시 로드하거나
                // isAlreadyApplied 상태를 true로 직접 업데이트할 수 있습니다.
                _isAlreadyApplied.value = true // 직접 업데이트하는 경우
                // 또는 loadGroupDetail(groupId) // 서버에서 최신 정보를 다시 가져오는 경우
            } catch (e: Exception) {
                _applySuccess.value = false
            }
        }
    }

    fun resetApplyStatus() {
        _applySuccess.value = null
    }
}