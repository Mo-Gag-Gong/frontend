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

    private val _searchQuery = MutableStateFlow("") // 검색 화면에서 사용할 수 있도록 유지
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
                fetchInterests()
                fetchGroups() // 초기 그룹 로드
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

    fun onInterestClick(interest: String?) {
        _selectedInterest.value = interest
    }

    private fun fetchInterests() {
        viewModelScope.launch {
            try {
                val allInterests = interestRepository.getAllInterests()
                _interests.value = allInterests
                Log.d("HomeViewModel", "관심사 목록 업데이트 성공: ${allInterests.size}개")
            } catch (e: Exception) {
                Log.e("HomeViewModel", "관심사 목록 불러오기 실패: ${e.message}")
                _interests.value = emptyList()
            }
        }
    }

    fun fetchGroups(query: String? = null) { // query 파라미터를 추가하여 검색어 필터링 지원
        val keyword = query ?: _searchQuery.value // 파라미터로 넘어온 query가 있으면 사용, 없으면 _searchQuery.value 사용
        val interest = _selectedInterest.value // 선택된 관심사 값
        val region = _region.value

        Log.d("HomeViewModel", "fetchGroups 호출됨 - region: $region, keyword: $keyword, interest: $interest") // 로그 추가

        viewModelScope.launch {
            try {
                val result = groupRepository.getGroups(region, keyword, interest)
                _groupList.value = result
                Log.d("HomeViewModel", "그룹 불러오기 성공: ${result.size}개, 데이터: $result") // 로그 추가
            } catch (e: Exception) {
                Log.e("HomeViewModel", "그룹 불러오기 실패: ${e.message}")
                _groupList.value = emptyList()
            }
        }
    }
}