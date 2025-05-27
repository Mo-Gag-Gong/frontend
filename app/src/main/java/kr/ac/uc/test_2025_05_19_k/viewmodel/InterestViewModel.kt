package kr.ac.uc.test_2025_05_19_k.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.network.ApiService
import kr.ac.uc.test_2025_05_19_k.network.Interest
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