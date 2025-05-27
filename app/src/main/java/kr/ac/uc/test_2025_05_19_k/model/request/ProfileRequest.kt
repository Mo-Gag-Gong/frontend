package kr.ac.uc.test_2025_05_19_k.model.request

import kr.ac.uc.test_2025_05_19_k.network.ApiService
import kr.ac.uc.test_2025_05_19_k.network.ProfileRequest
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun getProfile() = api.getMyProfile()
    suspend fun updateProfile(request: ProfileRequest) = api.updateProfile(request)
}
