package kr.ac.uc.test_2025_05_19_k.repository

import kr.ac.uc.test_2025_05_19_k.model.AuthUserProfile
import kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse
import kr.ac.uc.test_2025_05_19_k.network.api.UserApi
import kr.ac.uc.test_2025_05_19_k.network.api.UserApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApi: UserApi,
    private val userApiService: UserApiService
) {
    suspend fun getMyProfile(): AuthUserProfile {
        return userApi.getMyProfile()
    }
    suspend fun getUserProfile(userId: Long): UserProfileResponse? {
        return try {
            val response = userApiService.getUserProfile(userId)
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
        }
}
