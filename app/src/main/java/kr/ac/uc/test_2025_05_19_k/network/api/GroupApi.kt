// mo-gag-gong/frontend/frontend-dev-hj/app/src/main/java/kr/ac/uc/test_2025_05_19_k/network/api/GroupApi.kt
package kr.ac.uc.test_2025_05_19_k.network.api

import kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto
import kr.ac.uc.test_2025_05_19_k.model.GroupResponse
import kr.ac.uc.test_2025_05_19_k.model.PageGroupNoticeDto
import kr.ac.uc.test_2025_05_19_k.model.PageStudyGroupDto
import kr.ac.uc.test_2025_05_19_k.model.StudyGroup
import kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail
import kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequest
import kr.ac.uc.test_2025_05_19_k.model.request.GroupNoticeCreateRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Query

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

    // ✅ 추가: 스터디 그룹 검색 API (제목 또는 설명에 키워드 포함)
    @GET("/api/groups/search")
    suspend fun searchGroups(
        @retrofit2.http.Query("keyword") keyword: String, // 키워드 필수
        @retrofit2.http.Query("page") page: Int? = 0,
        @retrofit2.http.Query("size") size: Int? = 10
    ): PageStudyGroupDto


    @GET("/api/groups/my-owned-groups")
    suspend fun getMyOwnedGroups(): List<StudyGroup> // API 응답이 List<StudyGroupDto> 형태일 것으로 예상
    @PUT("/api/groups/{groupId}")
    suspend fun updateGroup(
        @Path("groupId") groupId: Long,
        @Body request: GroupCreateRequest // 요청 본문은 GroupCreateRequest DTO 사용
    ): Response<StudyGroupDetail>

    @GET("/api/groups/{groupId}/notices")
    suspend fun getGroupNotices(
        @Path("groupId") groupId: Long,
        @Query("page") page: Int? = 0,
        @Query("size") size: Int? = 10 // 페이지네이션 지원
    ): PageGroupNoticeDto

    @POST("/api/groups/{groupId}/notices")
    suspend fun createNotice(
        @Path("groupId") groupId: Long,
        @Body request: GroupNoticeCreateRequest
    ): GroupNoticeDto // API 명세에 따르면 성공 시 생성된 GroupNoticeDto 반환

    @GET("/api/groups/my-joined-groups")
    suspend fun getJoinedGroups(): List<GroupResponse>//사용자가 참여하고 있는 스터디 그룹 목록을 가져오는 API
}