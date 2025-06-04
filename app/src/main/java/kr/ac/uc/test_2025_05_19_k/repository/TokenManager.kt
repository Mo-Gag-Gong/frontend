// app/src/main/java/kr/ac/uc/test_2025_05_19_k/repository/TokenManager.kt
package kr.ac.uc.test_2025_05_19_k.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenManager @Inject constructor(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(AUTH_PREFERENCES_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val AUTH_PREFERENCES_NAME = "auth_prefs"
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
        private const val KEY_USER_ID = "user_id"
    }

    fun saveTokens(accessToken: String, refreshToken: String, userId: Long) {
        prefs.edit {
            putString(KEY_ACCESS_TOKEN, accessToken)
            putString(KEY_REFRESH_TOKEN, refreshToken)
            putLong(KEY_USER_ID, userId)
            apply()
        }
    }

    fun getAccessToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, null)
    fun getRefreshToken(): String? = prefs.getString(KEY_REFRESH_TOKEN, null)
    fun getUserId(): Long? {
        val userId = prefs.getLong(KEY_USER_ID, -1L)
        return if (userId == -1L) null else userId
    }

    fun hasValidToken(): Boolean = !getAccessToken().isNullOrBlank()

    fun clearTokens() {
        prefs.edit {
            remove(KEY_ACCESS_TOKEN)
            remove(KEY_REFRESH_TOKEN)
            remove(KEY_USER_ID)
            apply()
        }
    }
}