package kr.ac.uc.test_2025_05_19_k.viewmodel

import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import android.app.Application
import kr.ac.uc.test_2025_05_19_k.repository.ProfileCacheManager
import kr.ac.uc.test_2025_05_19_k.ui.profile.ProfileState


class OnboardingViewModel @Inject constructor(
    private val cacheManager: ProfileCacheManager, // Hilt로 DI 주입 권장
    application: Application
) : AndroidViewModel(application) {

    private val _profileState = MutableStateFlow(ProfileState())
    val profileState: StateFlow<ProfileState> = _profileState

    init {
        // 앱 시작 시 SharedPreferences에서 캐시 로드
        cacheManager.loadProfile()?.let {
            _profileState.value = ProfileState(
                name = it.name,
                gender = it.gender ?: "",
                phone = it.phone,
                birth = it.birth,
                location = it.location
            )
        }
    }
}


    // location, interests까지 같이 처리


