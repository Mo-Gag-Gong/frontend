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
import kr.ac.uc.test_2025_05_19_k.network.Interest
import kr.ac.uc.test_2025_05_19_k.network.StudyGroup
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
                fetchGroups()
            } catch (e: Exception) {
                Log.e("HomeViewModel", "위치 불러오기 실패: ${e.message}")
                _groupList.value = emptyList()
            }
        }
    }
    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onInterestClick(interest: String?) {
        _selectedInterest.value = interest
    }

    fun fetchGroups() {
        val keyword = _searchQuery.value
        val interest = _selectedInterest.value
        val region = _region.value

        viewModelScope.launch {
            try {
                val result = groupRepository.getGroups(region, keyword, interest)
                _groupList.value = result
            } catch (e: Exception) {
                Log.e("HomeViewModel", "그룹 불러오기 실패: ${e.message}")
                _groupList.value = emptyList()
            }
        }
    }
}
