package kr.ac.uc.test_2025_05_19_k.network.api

import kr.ac.uc.test_2025_05_19_k.model.PageStudyGroupDto
import kr.ac.uc.test_2025_05_19_k.model.StudyGroup
import kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail
import kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequest
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Body

interface GroupApi {
    @GET("/api/groups")
    suspend fun getGroups(
        @retrofit2.http.Query("region") region: String,
        @retrofit2.http.Query("keyword") keyword: String?,
        @retrofit2.http.Query("interest") interest: String?,
        @retrofit2.http.Query("page") page: Int? = 0,
        @retrofit2.http.Query("size") size: Int? = 10
    ): PageStudyGroupDto // 반환 타입: PageStudyGroupDto

    @GET("/api/groups/{id}")
    suspend fun getGroupDetail(@Path("id") groupId: Long): StudyGroupDetail

    @POST("/api/groups/{groupId}/apply")
    suspend fun applyToGroup(@Path("groupId") groupId: Long)

    @POST("/api/groups")
    suspend fun createGroup(@Body request: GroupCreateRequest)
}
