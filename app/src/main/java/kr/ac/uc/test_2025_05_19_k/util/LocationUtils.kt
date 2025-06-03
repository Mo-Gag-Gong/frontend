// 파일: kr/ac/uc/test_2025_05_19_k/util/LocationUtils.kt

package kr.ac.uc.test_2025_05_19_k.util

import android.content.Context

// 관심사 ID 리스트를 SharedPreferences에 저장
fun saveInterestIds(context: Context, ids: List<Long>) {
    val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    prefs.edit().putStringSet("interest_ids", ids.map { it.toString() }.toSet()).apply()
}

// SharedPreferences에서 관심사 ID 리스트 조회
fun getInterestIds(context: Context): List<Long> {
    val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    return prefs.getStringSet("interest_ids", emptySet())
        ?.mapNotNull { it.toLongOrNull() }
        ?: emptyList()
}




// 유저 정보 임시 저장
fun saveUserInputInfo(
    context: Context,
    name: String,
    gender: String,
    phone: String,
    birth: String
) {
    val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    prefs.edit()
        .putString("user_name", name)
        .putString("user_gender", gender)
        .putString("user_phone", phone)
        .putString("user_birth", birth)
        .apply()
}

// 유저 정보 임시 조회
fun getUserInputInfo(context: Context): UserInputInfo {
    val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    return UserInputInfo(
        name = prefs.getString("user_name", "") ?: "",
        gender = prefs.getString("user_gender", "") ?: "",
        phone = prefs.getString("user_phone", "") ?: "",
        birth = prefs.getString("user_birth", "") ?: ""
    )
}

// 데이터 클래스 (입력값 구조)
data class UserInputInfo(
    val name: String,
    val gender: String,
    val phone: String,
    val birth: String
)
