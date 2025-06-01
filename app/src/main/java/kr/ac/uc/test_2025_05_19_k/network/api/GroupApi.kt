package kr.ac.uc.test_2025_05_19_k.network.api

import kr.ac.uc.test_2025_05_19_k.model.common.CommonPageResponse
import kr.ac.uc.test_2025_05_19_k.model.group.StudyGroupResponseDto
import kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequestDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Body
import retrofit2.http.Query

interface GroupApi {

    @GET("/api/groups")
    suspend fun getGroups(
        @Query("region") region: String,
        @Query("keyword") keyword: String?,
        @Query("interest") interest: String?,
        @Query("page") page: Int? = null,
        @Query("size") size: Int? = null
    ): CommonPageResponse<StudyGroupResponseDto>

    @GET("/api/groups/{id}")
    suspend fun getGroupDetail(@Path("id") groupId: Long): StudyGroupResponseDto

    @POST("/api/groups/{groupId}/apply")
    suspend fun applyToGroup(@Path("groupId") groupId: Long)

    @POST("/api/groups")
    suspend fun createGroup(@Body request: GroupCreateRequestDto)
}