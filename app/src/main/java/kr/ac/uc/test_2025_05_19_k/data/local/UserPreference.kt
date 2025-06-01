package kr.ac.uc.test_2025_05_19_k.data.local

import android.content.Context
import android.content.SharedPreferences

class UserPreference(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_LOCATION = "user_location"
    }

    fun saveLocation(location: String) {
        prefs.edit().putString(KEY_LOCATION, location).apply()
    }

    fun getLocation(): String {
        return prefs.getString(KEY_LOCATION, "") ?: ""
    }
}