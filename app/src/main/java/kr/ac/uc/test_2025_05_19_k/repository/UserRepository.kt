package kr.ac.uc.test_2025_05_19_k.repository

import kr.ac.uc.test_2025_05_19_k.model.AuthUserProfile
import kr.ac.uc.test_2025_05_19_k.network.api.UserApi
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApi: UserApi
) {
    suspend fun getMyProfile(): AuthUserProfile {
        return userApi.getMyProfile()
    }
}
