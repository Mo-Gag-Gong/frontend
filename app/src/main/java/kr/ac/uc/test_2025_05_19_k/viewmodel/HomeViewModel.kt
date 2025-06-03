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
import kr.ac.uc.test_2025_05_19_k.model.Interest
import kr.ac.uc.test_2025_05_19_k.model.StudyGroup
import kr.ac.uc.test_2025_05_19_k.repository.GroupRepository
import kr.ac.uc.test_2025_05_19_k.repository.InterestRepository
import kr.ac.uc.test_2025_05_19_k.model.PageStudyGroupDto
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val groupRepository: GroupRepository,
    private val interestRepository: InterestRepository // InterestRepository 추가
) : AndroidViewModel(application) {

    private val userPreference = UserPreference(application)

    private val _region = MutableStateFlow("")
    val region: StateFlow<String> = _region

    private val _interests = MutableStateFlow<List<Interest>>(emptyList())
    val interests: StateFlow<List<Interest>> = _interests

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedInterest = MutableStateFlow<String?>(null)
    val selectedInterest: StateFlow<String?> = _selectedInterest

    private val _groupList = MutableStateFlow<List<StudyGroup>>(emptyList())
    val groupList: StateFlow<List<StudyGroup>> = _groupList

    fun initUser() {
        viewModelScope.launch {
            try {
                val location = userPreference.getLocation()
                _region.value = location

                // 전체 관심사 목록 로드
                val fetchedInterests = interestRepository.getAllInterests()
                _interests.value = fetchedInterests

                fetchGroups() // 지역 및 (초기에는 없는) 필터 기준으로 그룹 로드
            } catch (e: Exception) {
                Log.e("HomeViewModel", "초기 사용자 정보 또는 관심사/그룹 불러오기 실패: ${e.message}")
                _interests.value = emptyList() // 관심사 로드 실패 시 빈 리스트
                _groupList.value = emptyList() // 그룹 로드 실패 시 빈 리스트
            }
        }
    }
    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        fetchGroups() // 검색어 변경 시 그룹 목록 다시 로드
    }

    fun onInterestClick(interest: String?) {
        _selectedInterest.value = if (_selectedInterest.value == interest) null else interest
        fetchGroups() // 선택된 관심사 변경 시 그룹 목록 다시 로드
    }

    fun fetchGroups() {
        val keyword = _searchQuery.value.ifBlank { null }
        val interest = _selectedInterest.value
        val region = _region.value

        viewModelScope.launch {
            try {
                // groupRepository.getGroups는 List<StudyGroup>을 반환합니다.
                val resultList: List<StudyGroup> = groupRepository.getGroups(region, keyword, interest)
                _groupList.value = resultList // List<StudyGroup>을 _groupList에 직접 할당
            } catch (e: Exception) {
                Log.e("HomeViewModel", "그룹 불러오기 실패 ViewModel: ${e.message}", e)
                _groupList.value = emptyList()
            }
        }
    }
}
