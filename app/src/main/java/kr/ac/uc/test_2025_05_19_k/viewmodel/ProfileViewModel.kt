package kr.ac.uc.test_2025_05_19_k.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.repository.ProfileRepository
import javax.inject.Inject
import androidx.compose.runtime.*
import kr.ac.uc.test_2025_05_19_k.model.ProfileUpdateRequest
import kr.ac.uc.test_2025_05_19_k.model.Interest

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {

    // 상태 변수들 (UI 바인딩용)
    var name by mutableStateOf("")
    var gender by mutableStateOf<String?>(null)
    var phoneNumber by mutableStateOf("")
    var birth by mutableStateOf("")      // "YYYY-MM-DD"
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

    /**
     * 프로필 저장 함수 (상태 기반)
     */
    fun submitProfile(
        name: String,
        gender: String,
        phone: String,
        birth: String,
        selectedInterests: List<Interest>,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        Log.d("ProfileViewModel", "submitProfile start, repository=$repository")
        isLoading = true
        errorMessage = null

        // 생년(YYYY-MM-DD)에서 연도만 추출
        val birthYearValue = birth.take(4).toIntOrNull() ?: 0

        // 관심사 id 추출
        val interestIds = selectedInterests.map { it.interestId }

        // 유효성 체크 (필수)
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

        // DTO 변환
        val profileRequest = ProfileUpdateRequest(
            name = name,
            gender = gender ?: "",
            phoneNumber = phoneNumber,
            birthYear = birthYearInt,
            locationName = locationName,
            interestIds = selectedInterestIds
        )
        Log.d("ProfileViewModel", "profileRequest=$profileRequest")

        viewModelScope.launch {
            try {
                val result = repository.updateProfile(profileRequest)
                if (result.isSuccessful) {
                    Log.d("ProfileViewModel", "프로필 업데이트 성공!")
                    onSuccess()
                } else {
                    Log.e("ProfileViewModel", "서버 오류: ${result.code()} / ${result.message()}")
                    onError("서버 오류: ${result.code()} / ${result.message()}")
                }
            } catch (e: Exception) {
                Log.e("ProfileViewModel", "네트워크 예외 발생: ${e.localizedMessage}")
                onError("네트워크 오류: ${e.localizedMessage ?: "알 수 없는 오류"}")
            } finally {
                isLoading = false
                Log.d("ProfileViewModel", "submitProfile finally!")
            }
        }
    }
}
