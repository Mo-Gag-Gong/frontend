package kr.ac.uc.test_2025_05_19_k.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.model.Interest
import kr.ac.uc.test_2025_05_19_k.network.ApiService
import kr.ac.uc.test_2025_05_19_k.repository.InterestRepository
import javax.inject.Inject


@HiltViewModel
class InterestViewModel @Inject constructor(
    private val repository: InterestRepository
) : ViewModel() {
    var interests by mutableStateOf<List<Interest>>(emptyList())
    var error by mutableStateOf<String?>(null)
    var isLoading by mutableStateOf(false)

    fun loadInterests() {
        viewModelScope.launch {
            isLoading = true
            try {
                interests = repository.getAllInterests()
            } catch (e: Exception) {
                error = "관심사 목록을 불러오지 못했습니다."
                Log.d("관심사 목록을 불러오지 못했습니다.", e.toString())
            } finally {
                isLoading = false
            }
        }
    }
}

// 예시: InterestSelectViewModel.kt
class InterestSelectViewModel : ViewModel() {
    var userName by mutableStateOf("")
    var gender by mutableStateOf("")
    var phone by mutableStateOf("")
    var birth by mutableStateOf("")

    fun setUserInfo(name: String, gender: String, phone: String, birth: String) {
        this.userName = name
        this.gender = gender
        this.phone = phone
        this.birth = birth
    }
}