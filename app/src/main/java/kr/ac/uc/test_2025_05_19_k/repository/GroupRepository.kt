package kr.ac.uc.test_2025_05_19_k.repository

import kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto
import kr.ac.uc.test_2025_05_19_k.model.PageGroupNoticeDto
import kr.ac.uc.test_2025_05_19_k.model.PageStudyGroupDto
import kr.ac.uc.test_2025_05_19_k.model.StudyGroup
import kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail
import kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequest
import kr.ac.uc.test_2025_05_19_k.model.request.GroupNoticeCreateRequest
import kr.ac.uc.test_2025_05_19_k.network.api.GroupApi
import retrofit2.Response
import javax.inject.Inject

/**
 * 그룹(스터디) 관련 데이터 통신 Repository
 * - 모든 API 통신은 GroupApi를 통해 DI로 주입받음
 */
class GroupRepository @Inject constructor(
    private val groupApi: GroupApi
) {
    /**
     * 전체 스터디 그룹 목록 조회 (페이지네이션 지원)
     */
    suspend fun getGroups(region: String, keyword: String?, interest: String?, page: Int, size: Int): PageStudyGroupDto {
        return groupApi.getGroups(region, keyword, interest, page, size)
    }

    /**
     * 그룹 상세정보 조회
     */
    suspend fun getGroupDetail(groupId: Long): StudyGroupDetail {
        return groupApi.getGroupDetail(groupId)
    }

    /**
     * 그룹 참가 신청
     */
    suspend fun applyToGroup(groupId: Long) {
        groupApi.applyToGroup(groupId)
    }

    /**
     * 그룹 생성
     */
    suspend fun createGroup(request: GroupCreateRequest) {
        groupApi.createGroup(request)
    }

    /**
     * 그룹 키워드 검색 (페이지네이션 지원)
     */
    suspend fun searchGroups(keyword: String, page: Int? = 0, size: Int? = 10): List<StudyGroup> {
        val pageResult: PageStudyGroupDto = groupApi.searchGroups(keyword, page, size)
        return pageResult.content
    }

    /**
     * 내가 참가한 그룹 리스트 조회
     */
    suspend fun getMyJoinedGroups(): List<StudyGroup> {
        return groupApi.getMyJoinedGroups()
    }

    /**
     * 내가 만든(소유) 그룹 리스트 조회
     */
    suspend fun getMyOwnedGroups(): List<StudyGroup> {
        return groupApi.getMyOwnedGroups()
    }

    /**
     * 그룹 정보 수정
     */
    suspend fun updateGroup(groupId: Long, request: GroupCreateRequest): Response<StudyGroupDetail> {
        return groupApi.updateGroup(groupId, request)
    }

    /**
     * 그룹 공지 목록(페이지네이션) 조회
     */
    suspend fun getGroupNotices(groupId: Long, page: Int, size: Int): PageGroupNoticeDto {
        return groupApi.getGroupNotices(groupId, page, size)
    }

    /**
     * 그룹 공지 생성
     */
    suspend fun createNotice(groupId: Long, request: GroupNoticeCreateRequest): GroupNoticeDto {
        return groupApi.createNotice(groupId, request)
    }

    /**
     * 그룹 공지 삭제
     */
    suspend fun deleteNotice(groupId: Long, noticeId: Long): Response<Void> {
        return groupApi.deleteNotice(groupId, noticeId)
    }

    /**
     * 그룹 공지 수정
     */
    suspend fun updateNotice(groupId: Long, noticeId: Long, request: GroupNoticeCreateRequest): GroupNoticeDto {
        return groupApi.updateNotice(groupId, noticeId, request)
    }
}
