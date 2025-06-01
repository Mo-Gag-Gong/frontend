package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.model.request.ProfileUpdateRequest // 수정된 DTO import 가정
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

    var locationName by mutableStateOf("") // 위치 정보 (예: "울산광역시 남구")
    var selectedInterestIds by mutableStateOf<List<Long>>(emptyList())

    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    fun submitProfile(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        isLoading = true

        // birthYear 문자열을 Int로 변환, 실패 시 0 또는 적절한 기본값/오류 처리
        val birthYearInt = birthYear.toIntOrNull()
        if (birthYearInt == null) {
            onError("생년월일 형식이 올바르지 않습니다.")
            isLoading = false
            return
        }

        val currentGender = gender ?: ""
        if (currentGender.isEmpty()) {
            onError("성별을 선택해주세요.")
            isLoading = false
            return
        }


        val profileRequest = ProfileUpdateRequest(
            name = name,
            gender = currentGender,
            phoneNumber = phoneNumber,
            birthYear = birthYearInt,
            locationName = locationName,        // 추가된 필드 사용
            interestIds = selectedInterestIds   // 추가된 필드 사용
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

    // UI에서 locationName을 업데이트하기 위한 함수 (예시)
    fun updateLocationName(newName: String) {
        locationName = newName
    }

    // UI에서 관심사 선택을 업데이트하기 위한 함수 (예시)
    fun updateSelectedInterests(newInterestIds: List<Long>) {
        selectedInterestIds = newInterestIds
    }

    // UI에서 성별을 업데이트하기 위한 함수 (예시)
    fun updateGender(newGender: String?) {
        gender = newGender
    }
}