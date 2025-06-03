package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.repository.ProfileRepository
import javax.inject.Inject
import androidx.compose.runtime.*
import kr.ac.uc.test_2025_05_19_k.model.ProfileUpdateRequest

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {

    // 상태 변수들 (UI 바인딩용)
    var name by mutableStateOf("")
    var gender by mutableStateOf<String?>(null)
    var phoneNumber by mutableStateOf("")
    var birthYear by mutableStateOf("")
    var locationName by mutableStateOf("")
    var selectedInterestIds by mutableStateOf<List<Long>>(emptyList())

    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    // 상태 업데이트 함수
    fun updateName(newName: String) { name = newName }
    fun updateGender(newGender: String?) { gender = newGender }
    fun updatePhoneNumber(newNumber: String) { phoneNumber = newNumber }
    fun updateBirthYear(newBirth: String) { birthYear = newBirth }
    fun updateLocationName(newLocation: String) { locationName = newLocation }
    fun updateSelectedInterests(newIds: List<Long>) { selectedInterestIds = newIds }

    // 프로필 저장 함수 (파라미터 없이 상태 기반)
    fun submitProfile(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        isLoading = true
        errorMessage = null

        // 유효성 체크
        val birthYearInt = birthYear.toIntOrNull()
        if (birthYearInt == null) {
            onError("생년월일(출생연도)을 올바르게 입력하세요.")
            isLoading = false
            return
        }
        if (name.isBlank()) {
            onError("이름을 입력하세요.")
            isLoading = false
            return
        }
        if (gender.isNullOrBlank()) {
            onError("성별을 선택하세요.")
            isLoading = false
            return
        }
        if (phoneNumber.isBlank()) {
            onError("전화번호를 입력하세요.")
            isLoading = false
            return
        }
        if (locationName.isBlank()) {
            onError("위치를 선택하세요.")
            isLoading = false
            return
        }
        if (selectedInterestIds.isEmpty()) {
            onError("관심사를 1개 이상 선택하세요.")
            isLoading = false
            return
        }

        // DTO 생성
        val profileRequest = ProfileUpdateRequest(
            name = name,
            gender = gender!!,
            phoneNumber = phoneNumber,
            birthYear = birthYearInt,
            locationName = locationName,
            interestIds = selectedInterestIds
        )

        viewModelScope.launch {
            try {
                val result = repository.updateProfile(profileRequest)
                if (result.isSuccessful) {
                    onSuccess()
                } else {
                    onError("서버 오류: ${result.code()} / ${result.message()}")
                }
            } catch (e: Exception) {
                onError("네트워크 오류: ${e.localizedMessage ?: "알 수 없는 오류"}")
            } finally {
                isLoading = false
            }
        }
    }
}
