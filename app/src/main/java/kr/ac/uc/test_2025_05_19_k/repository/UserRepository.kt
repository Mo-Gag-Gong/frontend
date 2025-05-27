package kr.ac.uc.test_2025_05_19_k.repository

import kr.ac.uc.test_2025_05_19_k.network.ApiService
import kr.ac.uc.test_2025_05_19_k.network.AuthUserProfile
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApi: ApiService
) {
    suspend fun getMyProfile(): AuthUserProfile {
        return userApi.getMyProfile()
    }
}
