package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.network.ProfileRequest
import kr.ac.uc.test_2025_05_19_k.repository.ProfileRepository
import javax.inject.Inject
import androidx.compose.runtime.*
import kr.ac.uc.test_2025_05_19_k.network.Interest

@HiltViewModel
class ProfileInputViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {

    var name by mutableStateOf("")
    var gender by mutableStateOf<String?>(null)
    var phoneNumber by mutableStateOf("")
    var birth by mutableStateOf("")      // "YYYY-MM-DD"
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    fun submitProfile(
        name: String,
        gender: String,
        phone: String,
        birth: String,
        selectedInterests: List<Interest>,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        isLoading = true
        errorMessage = null

        val birthYearValue = birth.take(4).toIntOrNull() ?: 0

        // 관심사 id 추출!
        val interestIds = selectedInterests.map { it.interestId }

        val profileRequest = ProfileRequest(
            name = name,
            gender = gender ?: "",
            phoneNumber = phone,
            birthYear = birthYearValue,
            interestIds = interestIds
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
