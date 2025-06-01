package kr.ac.uc.test_2025_05_19_k.repository

import kr.ac.uc.test_2025_05_19_k.model.request.ProfileUpdateRequest
import kr.ac.uc.test_2025_05_19_k.model.user.UserProfileResponse
import kr.ac.uc.test_2025_05_19_k.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun updateProfile(profileRequest: ProfileUpdateRequest): Response<UserProfileResponse> {
        return apiService.updateProfile(profileRequest)
    }
}