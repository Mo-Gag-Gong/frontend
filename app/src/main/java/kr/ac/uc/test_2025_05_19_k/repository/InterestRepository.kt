package kr.ac.uc.test_2025_05_19_k.repository

import kr.ac.uc.test_2025_05_19_k.network.ApiService
import kr.ac.uc.test_2025_05_19_k.network.Interest
import javax.inject.Inject

class InterestRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllInterests(): List<Interest> {
        return apiService.getAllInterests()
    }
}