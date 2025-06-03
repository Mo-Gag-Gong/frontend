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
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_ONBOARDING_COMPLETED = "onboarding_completed"
        private const val KEY_LOCATION = "location_name" // 지역 정보 저장 키
    }

    // 토큰 관련 메서드
    fun saveTokens(accessToken: String, refreshToken: String, userId: Long) {
        prefs.edit {
            putString(KEY_ACCESS_TOKEN, accessToken)
            putString(KEY_REFRESH_TOKEN, refreshToken)
            putLong(KEY_USER_ID, userId)
        }
    }

    fun getAccessToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, null)
    fun getRefreshToken(): String? = prefs.getString(KEY_REFRESH_TOKEN, null)
    fun getUserId(): Long? {
        val userId = prefs.getLong(KEY_USER_ID, -1L)
        return if (userId == -1L) null else userId
    }

    fun clearTokens() {
        prefs.edit {
            remove(KEY_ACCESS_TOKEN)
            remove(KEY_REFRESH_TOKEN)
            remove(KEY_USER_ID)
            remove(KEY_ONBOARDING_COMPLETED) // 온보딩 완료 상태도 함께 초기화
            remove(KEY_LOCATION)      // 지역 정보도 함께 초기화
        }
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
}
