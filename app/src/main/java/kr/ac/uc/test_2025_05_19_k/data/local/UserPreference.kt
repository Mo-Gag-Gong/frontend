// app/src/main/java/kr/ac/uc/test_2025_05_19_k/data/local/UserPreference.kt
package kr.ac.uc.test_2025_05_19_k.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreference @Inject constructor(@ApplicationContext context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(USER_PREFERENCES_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val USER_PREFERENCES_NAME = "user_prefs"
        private const val KEY_ONBOARDING_COMPLETED = "onboarding_completed"
        private const val KEY_LOCATION = "location_name" // 지역 정보 저장 키
    }

    /**
     * 사용자의 온보딩 완료 상태를 저장합니다.
     * @param completed 온보딩 완료 여부 (true: 완료, false: 미완료)
     */
    fun setOnboardingCompleted(completed: Boolean) {
        prefs.edit {
            putBoolean(KEY_ONBOARDING_COMPLETED, completed)
        }
    }

    /**
     * 사용자의 온보딩 완료 상태를 조회합니다.
     * @return 온보딩 완료 여부. 저장된 값이 없으면 false를 반환합니다.
     */
    fun isOnboardingCompleted(): Boolean {
        return prefs.getBoolean(KEY_ONBOARDING_COMPLETED, false)
    }


    fun saveLocation(location: String) {
        prefs.edit().putString(KEY_LOCATION, location).apply()
    }

    fun getLocation(): String {
        return prefs.getString(KEY_LOCATION, "") ?: ""
    }

    fun clearOnboardingAndLocation() {
        prefs.edit {
            remove(KEY_ONBOARDING_COMPLETED)
            remove(KEY_LOCATION)
        }
    }
}