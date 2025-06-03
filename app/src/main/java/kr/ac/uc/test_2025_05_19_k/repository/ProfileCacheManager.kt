package kr.ac.uc.test_2025_05_19_k.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kr.ac.uc.test_2025_05_19_k.ui.profile.ProfileState

class ProfileCacheManager @Inject constructor(
    @ApplicationContext private val context: Context // 반드시 ApplicationContext 어노테이션 붙이기!
) {
    private val prefs = context.getSharedPreferences("onboarding_profile_cache", Context.MODE_PRIVATE)

    // 1. 프로필(기본정보) 저장
    // ProfileState 전체 저장
    fun saveProfile(profile: ProfileState) {
        prefs.edit()
            .putString("name", profile.name)
            .putString("gender", profile.gender)
            .putString("phone", profile.phone)
            .putString("birth", profile.birth)
            .putString("location", profile.location)
            .putString("interests", profile.interests.joinToString(","))
            .apply()
    }

    // 2. 프로필(기본정보) 불러오기
    fun loadProfile(): CachedProfile? {
        val name = prefs.getString("name", null) ?: return null
        val gender = prefs.getString("gender", null)
        val phone = prefs.getString("phone", null) ?: ""
        val birth = prefs.getString("birth", null) ?: ""
        val location = prefs.getString("location", null) ?: ""
        return CachedProfile(name, gender, phone, birth, location)
    }

    // 3. 관심사 저장 (ID 목록을 콤마로 저장)
    fun saveInterests(ids: List<Long>) {
        prefs.edit().putString("interest_ids", ids.joinToString(",")).apply()
    }
    // 4. 관심사 불러오기
    fun loadInterests(): List<Long> {
        return prefs.getString("interest_ids", "")!!.split(",").mapNotNull { it.toLongOrNull() }
    }

    fun clear() { prefs.edit().clear().apply() }
}

data class CachedProfile(
    val name: String,
    val gender: String?,
    val phone: String,
    val birth: String,
    val location: String
)
