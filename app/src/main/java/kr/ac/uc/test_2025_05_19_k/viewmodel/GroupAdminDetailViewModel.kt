// app/src/main/java/kr/ac/uc/test_2025_05_19_k/viewmodel/GroupAdminDetailViewModel.kt
package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail
import kr.ac.uc.test_2025_05_19_k.repository.GroupRepository
import javax.inject.Inject
import android.util.Log
import kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto // GroupNoticeDto 임포트

@HiltViewModel
class GroupAdminDetailViewModel @Inject constructor(
    private val groupRepository: GroupRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val groupId: Long = savedStateHandle.get<Long>("groupId") ?: -1L

    // --- 그룹 상세 정보 (기존 코드) ---
    private val _groupDetail = MutableStateFlow<StudyGroupDetail?>(null)
    val groupDetail: StateFlow<StudyGroupDetail?> = _groupDetail.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // --- 공지사항 관리 상태 추가 ---
    private val _groupNotices = MutableStateFlow<List<GroupNoticeDto>>(emptyList())
    val groupNotices: StateFlow<List<GroupNoticeDto>> = _groupNotices.asStateFlow()

    private val _isLoadingNotices = MutableStateFlow(false)
    val isLoadingNotices: StateFlow<Boolean> = _isLoadingNotices.asStateFlow()

    // 공지사항 페이지네이션 상태 (추후 확장을 위해)
    private var currentNoticePage = 0
    private val noticePageSize = 20
    private var isLastNoticePage = false

    private val _showDeleteConfirmDialog = MutableStateFlow(false)
    val showDeleteConfirmDialog: StateFlow<Boolean> = _showDeleteConfirmDialog.asStateFlow()

    private var noticeIdToDelete: Long? = null


    init {
        if (groupId != -1L) {
            fetchGroupDetails()
            // 화면 진입 시 첫 번째 탭인 공지사항 목록을 바로 불러옵니다.
            fetchNoticesFirstPage()
        }
    }

    private fun fetchGroupDetails() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _groupDetail.value = groupRepository.getGroupDetail(groupId)
            } catch (e: Exception) {
                Log.e("GroupAdminDetailVM", "그룹 상세 정보 로드 실패: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    // --- 공지사항 로드 함수 추가 ---
    fun fetchNoticesFirstPage() {
        if (groupId == -1L) return
        currentNoticePage = 0
        isLastNoticePage = false
        _groupNotices.value = emptyList()
        fetchNoticesPage(currentNoticePage)
    }

    private fun fetchNoticesPage(page: Int) {
        viewModelScope.launch {
            _isLoadingNotices.value = true
            try {
                // Repository의 getGroupNotices 함수를 호출합니다.
                val noticePage = groupRepository.getGroupNotices(groupId, page, noticePageSize)
                // 현재는 페이지네이션을 UI에 구현하지 않았으므로, 첫 페이지만 가져와서 목록을 교체합니다.
                _groupNotices.value = noticePage.content
                isLastNoticePage = noticePage.last
                currentNoticePage = noticePage.number
                Log.d("GroupAdminDetailVM", "공지사항 로드 성공: ${noticePage.content.size}개")
            } catch (e: Exception) {
                Log.e("GroupAdminDetailVM", "공지사항 로드 실패: ${e.message}", e)
                // TODO: 오류 상태 관리
            } finally {
                _isLoadingNotices.value = false
            }
        }
    }

    fun onOpenDeleteDialog(noticeId: Long) {
        noticeIdToDelete = noticeId
        _showDeleteConfirmDialog.value = true
    }

    /**
     * 삭제 확인 대화상자를 닫습니다.
     */
    fun onDismissDeleteDialog() {
        noticeIdToDelete = null
        _showDeleteConfirmDialog.value = false
    }

    /**
     * 저장된 noticeIdToDelete를 사용하여 공지사항을 삭제합니다.
     */
    fun deleteNotice(onError: (String) -> Unit) {
        val noticeId = noticeIdToDelete
        if (noticeId == null) {
            onError("삭제할 공지사항이 선택되지 않았습니다.")
            onDismissDeleteDialog()
            return
        }

        viewModelScope.launch {
            try {
                val response = groupRepository.deleteNotice(groupId, noticeId)
                if (response.isSuccessful) {
                    Log.d("GroupAdminDetailVM", "공지사항 삭제 성공 (ID: $noticeId)")
                    // 삭제 성공 후 목록 새로고침
                    fetchNoticesFirstPage()
                } else {
                    val errorBody = response.errorBody()?.string() ?: "알 수 없는 서버 오류"
                    Log.e("GroupAdminDetailVM", "공지사항 삭제 API 실패: ${response.code()} - $errorBody")
                    onError("공지사항 삭제에 실패했습니다.")
                }
            } catch (e: Exception) {
                Log.e("GroupAdminDetailVM", "공지사항 삭제 중 예외 발생: ${e.message}", e)
                onError("오류가 발생하여 공지사항을 삭제하지 못했습니다.")
            } finally {
                onDismissDeleteDialog() // 대화상자 닫기
            }
        }
    }
}