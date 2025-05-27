package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.network.ProfileRequest
import kr.ac.uc.test_2025_05_19_k.repository.ProfileRepository
import javax.inject.Inject
import androidx.compose.runtime.*

@HiltViewModel
class ProfileInputViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {

    var name by mutableStateOf("")
    var gender by mutableStateOf<String?>(null)
    var phoneNumber by mutableStateOf("")
    var birthYear by mutableStateOf("")

    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    fun submitProfile(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        isLoading = true

        val profileRequest = ProfileRequest(
            name = name,
            gender = gender ?: "",
            phoneNumber = phoneNumber,
            birthYear = birthYear.toIntOrNull() ?: 0
        )

        viewModelScope.launch {
            try {
                val result = repository.updateProfile(profileRequest)
                if (result.isSuccessful) {
                    onSuccess()
                } else {
                    onError("서버 오류: ${result.code()}")
                }
            } catch (e: Exception) {
                onError("네트워크 오류: ${e.localizedMessage}")
            } finally {
                isLoading = false
            }
        }
    }
}
