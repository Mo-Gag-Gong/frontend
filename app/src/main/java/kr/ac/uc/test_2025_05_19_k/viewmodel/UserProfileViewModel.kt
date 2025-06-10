package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State as ComposeState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse
import kr.ac.uc.test_2025_05_19_k.repository.TokenManager
import kr.ac.uc.test_2025_05_19_k.repository.UserRepository
import javax.inject.Inject

// viewmodel/UserProfileViewModel.kt
@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val tokenManager: TokenManager // ← 여기 주입
) : ViewModel() {

    private val _userProfile = mutableStateOf<UserProfileResponse?>(null)
    val userProfile: ComposeState<UserProfileResponse?> = _userProfile

    fun loadUserProfile() {
        val userId = tokenManager.getUserId() // SharedPreferences에서 가져오기
        if (userId != null) {
            viewModelScope.launch {
                _userProfile.value = userRepository.getUserProfile(userId)
            }
        }
    }
}

