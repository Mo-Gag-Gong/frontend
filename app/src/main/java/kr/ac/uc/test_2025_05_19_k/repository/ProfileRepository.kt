package kr.ac.uc.test_2025_05_19_k.repository



import kr.ac.uc.test_2025_05_19_k.network.ApiService
import kr.ac.uc.test_2025_05_19_k.network.ProfileRequest
import kr.ac.uc.test_2025_05_19_k.network.ProfileResponse
import retrofit2.Response
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun updateProfile(profileRequest: ProfileRequest): Response<ProfileResponse> {
        return apiService.updateProfile(profileRequest)
    }

}
