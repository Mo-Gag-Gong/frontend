// mo-gag-gong/frontend/frontend-dev-hj/app/src/main/java/kr/ac/uc/test_2025_05_19_k/viewmodel/HomeViewModel.kt
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
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val groupRepository: GroupRepository,
    private val interestRepository: InterestRepository
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

    private val _recentSearches = MutableStateFlow<List<String>>(emptyList())
    val recentSearches: StateFlow<List<String>> = _recentSearches

    init {
        initUser()
        loadRecentSearches()
    }

    fun initUser() {
        viewModelScope.launch {
            try {
                val location = userPreference.getLocation()
                _region.value = location
                Log.d("HomeViewModel", "사용자 지역 정보 로드: ${_region.value}")
                fetchInterests() // 관심사 목록 먼저 로드
                // ViewModel 초기화 시 홈 화면의 그룹 목록을 지역 기반으로 로드합니다.
                // 초기에는 선택된 관심사가 없으므로 null로 호출합니다.
                fetchGroups(query = null, interestNameToFilter = _selectedInterest.value)
            } catch (e: Exception) {
                Log.e("HomeViewModel", "초기 데이터 불러오기 실패: ${e.message}")
                _groupList.value = emptyList()
                _interests.value = emptyList()
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onInterestClick(interestName: String?) {
        _selectedInterest.value = interestName
        Log.d("HomeViewModel", "관심사 선택 변경: $interestName. 그룹 목록 새로고침.")
        // 관심사 선택이 변경되면 홈 화면의 그룹 목록을 다시 불러옵니다.
        // 검색어는 없으므로 query는 null, 변경된 관심사를 interestNameToFilter로 전달합니다.
        fetchGroups(query = null, interestNameToFilter = _selectedInterest.value)
    }

    private fun fetchInterests() {
        viewModelScope.launch {
            try {
                val allInterests = interestRepository.getAllInterests()
                _interests.value = allInterests
                Log.d("HomeViewModel", "관심사 목록 로드 성공: ${allInterests.size}개")
            } catch (e: Exception) {
                Log.e("HomeViewModel", "관심사 목록 로드 실패: ${e.message}")
                _interests.value = emptyList()
            }
        }
    }

    fun fetchGroups(query: String? = null, interestNameToFilter: String? = _selectedInterest.value) {
        val currentRegion = _region.value
        val keywordForSearch = query

        Log.d("HomeViewModel", "fetchGroups 시작 - Region: $currentRegion, Query: $keywordForSearch, InterestFilter: $interestNameToFilter")

        viewModelScope.launch {
            try {
                val groupsFromServer: List<StudyGroup>
                if (!keywordForSearch.isNullOrBlank()) {
                    // 검색 결과 화면 로직: 검색 API 호출
                    Log.d("HomeViewModel", "SearchGroups API 호출 - Keyword: $keywordForSearch")
                    groupsFromServer = groupRepository.searchGroups(keyword = keywordForSearch)
                    Log.d("HomeViewModel", "SearchGroups API 결과 수신: ${groupsFromServer.size}개")
                } else {
                    // 홈 화면 로직: 지역 및 (서버에서 지원한다면) 관심사로 필터링된 그룹 목록 API 호출
                    // API_Final.md에 따르면 getGroups는 region과 interest 파라미터를 받습니다.
                    Log.d("HomeViewModel", "GetGroups API 호출 - Region: $currentRegion, Interest: $interestNameToFilter")
                    groupsFromServer = groupRepository.getGroups(region = currentRegion, interest = interestNameToFilter, keyword = null)
                    Log.d("HomeViewModel", "GetGroups API 결과 수신: ${groupsFromServer.size}개")
                }

                // --- 클라이언트 사이드 필터링 ---
                // 1. 지역 필터링 (항상 적용)
                // UserPreference에 저장된 지역명과 StudyGroup의 locationName이 정확히 일치하는 경우만 필터링
                val regionFilteredGroups = groupsFromServer.filter { group ->
                    group.locationName == currentRegion
                }
                Log.d("HomeViewModel", "지역($currentRegion) 필터링 후: ${regionFilteredGroups.size}개")

                // 2. 관심사 필터링 (홈 화면이고, 관심사가 선택된 경우에만 적용)
                val finalFilteredGroups = if (keywordForSearch.isNullOrBlank() && !interestNameToFilter.isNullOrBlank()) {
                    regionFilteredGroups.filter { group ->
                        group.interestName == interestNameToFilter
                    }
                } else {
                    regionFilteredGroups // 검색 시에는 관심사 필터링은 ViewModel 레벨에서 추가로 하지 않음 (서버 검색 결과 존중 또는 별도 UI 필요)
                }
                Log.d("HomeViewModel", "관심사($interestNameToFilter) 필터링 후: ${finalFilteredGroups.size}개")

                _groupList.value = finalFilteredGroups
                Log.d("HomeViewModel", "최종 UI 그룹 목록 업데이트: ${finalFilteredGroups.size}개. 데이터: $finalFilteredGroups")

            } catch (e: Exception) {
                Log.e("HomeViewModel", "그룹 불러오기 중 오류 발생: ${e.message}", e)
                _groupList.value = emptyList()
            }
        }
    }

    fun loadRecentSearches() {
        _recentSearches.value = userPreference.getRecentSearches().sortedByDescending { it }
    }

    fun addRecentSearch(query: String) {
        if (query.isNotBlank()) {
            userPreference.addRecentSearch(query)
            loadRecentSearches()
        }
    }

    fun removeRecentSearch(query: String) {
        userPreference.removeRecentSearch(query)
        loadRecentSearches()
    }

    fun clearAllRecentSearches() {
        userPreference.clearRecentSearches()
        loadRecentSearches()
    }
}