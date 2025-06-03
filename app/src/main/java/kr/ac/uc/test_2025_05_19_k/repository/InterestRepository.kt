package kr.ac.uc.test_2025_05_19_k.repository

import android.util.Log
import kr.ac.uc.test_2025_05_19_k.model.Interest
import kr.ac.uc.test_2025_05_19_k.network.ApiService
import javax.inject.Inject
import kotlin.collections.map

// InterestRepository.kt
class InterestRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun getAllInterests(): List<Interest> {
        return try {
            val dtoList = api.getAllInterests()
            Log.d("InterestRepository", "서버에서 관심사 수신: ${dtoList.size}개, 데이터=$dtoList") // 이 로그를 확인
            dtoList.map { dto ->
                Interest(
                    id = dto.interestId,
                    name = dto.interestName
                )
            }
        } catch (e: Exception) {
            Log.e("InterestRepository", "관심사 목록 조회 실패", e) // 이 로그를 확인
            emptyList()
        }
    }
}
