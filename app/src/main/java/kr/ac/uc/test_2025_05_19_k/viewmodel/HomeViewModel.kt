package kr.ac.uc.test_2025_05_19_k.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.data.local.UserPreference
import kr.ac.uc.test_2025_05_19_k.model.common.InterestDto
import kr.ac.uc.test_2025_05_19_k.model.group.StudyGroupResponseDto
import kr.ac.uc.test_2025_05_19_k.repository.GroupRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val groupRepository: GroupRepository
) : AndroidViewModel(application) {

    private val userPreference = UserPreference(application)

    private val _region = MutableStateFlow("")
    val region: StateFlow<String> = _region

    private val _interests = MutableStateFlow<List<InterestDto>>(emptyList())
    val interests: StateFlow<List<InterestDto>> = _interests

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedInterest = MutableStateFlow<String?>(null)
    val selectedInterest: StateFlow<String?> = _selectedInterest

    // StudyGroupResponseDto 사용하도록 타입 변경
    private val _groupList = MutableStateFlow<List<StudyGroupResponseDto>>(emptyList())
    val groupList: StateFlow<List<StudyGroupResponseDto>> = _groupList

    // --- 페이징 관련 상태 변수 (기본적인 첫 페이지만 로드하는 형태로 단순화) ---
    // 추후 UI에서 "더 보기" 등 페이징 기능 구현 시 이 부분을 확장해야 합니다.
    private var currentPage = 0
    private val pageSize = 20 // 한 번에 가져올 아이템 수 (예시)
    private var isLoadingApi = false
    private var canLoadMore = true // 더 로드할 페이지가 있는지 여부

    // --- 관심사 목록 로드 로직 (API 명세에 따라 추가 필요) ---
    // initUser 또는 별도의 함수에서 GET /api/users/interests 를 호출하여 _interests를 채워야 합니다.
    // 예시:
    // fun loadInterests() {
    //     viewModelScope.launch {
    //         try {
    //             // userRepository.getAllInterests() 와 같은 메소드가 필요
    //             // _interests.value = userRepository.getAllInterests()
    //         } catch (e: Exception) {
    //             Log.e("HomeViewModel", "관심사 목록 불러오기 실패: ${e.message}")
    //         }
    //     }
    // }

    fun initUser() {
        viewModelScope.launch {
            try {
                val location = userPreference.getLocation()
                _region.value = location
                // loadInterests() // 관심사 목록 로드 호출 (필요 시)
                fetchGroupsFirstPage() // 초기 그룹 목록 로드
            } catch (e: Exception) {
                Log.e("HomeViewModel", "위치 불러오기 실패: ${e.message}")
                _groupList.value = emptyList()
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        fetchGroupsFirstPage()
    }

    fun onInterestClick(interest: String?) {
        _selectedInterest.value = interest
        fetchGroupsFirstPage()
    }

    // 첫 페이지 그룹 목록을 가져오는 함수
    fun fetchGroupsFirstPage() {
        currentPage = 0 // 페이지 초기화
        canLoadMore = true // 더 로드할 수 있다고 가정
        _groupList.value = emptyList() // 기존 목록 비우기
        fetchGroupsInternal()
    }

    // 다음 페이지 그룹 목록을 가져오는 함수 (UI에서 "더 보기" 등에 사용)
    fun fetchMoreGroups() {
        if (canLoadMore && !isLoadingApi) {
            currentPage++
            fetchGroupsInternal()
        }
    }

    private fun fetchGroupsInternal() {
        if (isLoadingApi) return

        isLoadingApi = true
        val keyword = _searchQuery.value.ifEmpty { null } // API가 빈 문자열 대신 null을 기대할 수 있음
        val interest = _selectedInterest.value
        val region = _region.value

        viewModelScope.launch {
            try {
                val response = groupRepository.getGroups(
                    region = region,
                    keyword = keyword,
                    interest = interest,
                    page = currentPage,
                    size = pageSize
                )
                // CommonPageResponse에서 content (실제 그룹 목록)를 추출하여 할당
                if (currentPage == 0) {
                    _groupList.value = response.content
                } else {
                    _groupList.value = _groupList.value + response.content // 기존 목록에 추가
                }
                canLoadMore = !response.last // 마지막 페이지면 더 이상 로드할 수 없음
            } catch (e: Exception) {
                Log.e("HomeViewModel", "그룹 불러오기 실패: ${e.message}")
                if (currentPage == 0) { // 첫 페이지 로드 실패 시 목록 비움
                    _groupList.value = emptyList()
                }
                // 필요하다면 사용자에게 오류 메시지 표시 로직 추가
            } finally {
                isLoadingApi = false
            }
        }
    }
}