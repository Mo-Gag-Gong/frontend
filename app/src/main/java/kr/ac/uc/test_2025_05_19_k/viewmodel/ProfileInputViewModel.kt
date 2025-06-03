package kr.ac.uc.test_2025_05_19_k.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.*
import kr.ac.uc.test_2025_05_19_k.model.Interest
import kr.ac.uc.test_2025_05_19_k.model.ProfileUpdateRequest
import kr.ac.uc.test_2025_05_19_k.repository.InterestRepository
import kr.ac.uc.test_2025_05_19_k.repository.ProfileCacheManager
import kr.ac.uc.test_2025_05_19_k.repository.ProfileRepository

@HiltViewModel
class ProfileInputViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val interestRepository: InterestRepository,
    private val cacheManager: ProfileCacheManager
) : ViewModel() {

    // 관심사 목록 및 상태
    var interests by mutableStateOf<List<Interest>>(emptyList())
    var interestError by mutableStateOf<String?>(null)
    var interestLoading by mutableStateOf(false)

    // 선택된 관심사 (ID만)
    var selectedInterestIds by mutableStateOf<List<Long>>(emptyList())

    // 입력값
    var name by mutableStateOf("")
    var gender by mutableStateOf<String?>(null)
    var phoneNumber by mutableStateOf("")
    var birthYear by mutableStateOf("")
    var locationName by mutableStateOf("")

    // 저장 상태
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    init {
        // 프로필 입력값 복원
        cacheManager.loadProfile()?.let {
            name = it.name
            gender = it.gender
            phoneNumber = it.phone
            birthYear = it.birth
            locationName = it.location
        }
        // 관심사 복원
        selectedInterestIds = cacheManager.loadInterests()
    }

    /** 관심사 목록 불러오기 */
    fun loadInterests() {
        viewModelScope.launch {
            var interestLoading = true
            interestError = null
            try {
                interests = interestRepository.getAllInterests()
            } catch (e: Exception) {
                interestError = e.localizedMessage ?: "관심사 불러오기 실패"
            } finally {
                interestLoading = false
            }
        }
    }

    /** 관심사 토글 선택 */
    fun toggleInterest(interestId: Long) {
        selectedInterestIds = if (selectedInterestIds.contains(interestId)) {
            selectedInterestIds - interestId
        } else {
            if (selectedInterestIds.size < 2) selectedInterestIds + interestId else selectedInterestIds
        }
        saveInterestsToCache() // ← 관심사 바뀔 때마다 캐시에 저장
    }
    private fun saveInterestsToCache() {
        cacheManager.saveInterests(selectedInterestIds)
    }

    // 입력값 setter
    fun updateName(newName: String) {
        name = newName
        saveProfileToCache()
    }
    fun updateGender(newGender: String?) {
        gender = newGender
        saveProfileToCache()
    }
    fun updatePhoneNumber(newNumber: String) {
        phoneNumber = newNumber
        saveProfileToCache()
    }
    fun updateBirthYear(newBirth: String) {
        birthYear = newBirth
        saveProfileToCache()
    }
    fun updateLocationName(newLocation: String) {
        locationName = newLocation
        saveProfileToCache()
    }
    private fun saveProfileToCache() {
        cacheManager.saveProfile(
            name = name,
            gender = gender ?: "",
            phone = phoneNumber,
            birth = birthYear,
            location = locationName
        )
    }


    /** 프로필 저장 (관심사 포함) */
    fun submitProfile(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        isLoading = true
        errorMessage = null

        // 유효성 체크
        val birthYearInt = birthYear.toIntOrNull()
        if (birthYearInt == null) {
            onError("생년월일(출생연도)을 올바르게 입력하세요."); isLoading = false; return
        }
        if (name.isBlank()) { onError("이름을 입력하세요."); isLoading = false; return }
        if (gender.isNullOrBlank()) { onError("성별을 선택하세요."); isLoading = false; return }
        if (phoneNumber.isBlank()) { onError("전화번호를 입력하세요."); isLoading = false; return }
        if (locationName.isBlank()) { onError("위치를 선택하세요."); isLoading = false; return }
        if (selectedInterestIds.isEmpty()) { onError("관심사를 1개 이상 선택하세요."); isLoading = false; return }

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
                val result = profileRepository.updateProfile(profileRequest)
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

private fun ProfileCacheManager.saveProfile(
    name: String,
    gender: String,
    phone: String,
    birth: String,
    location: String
) {
}
