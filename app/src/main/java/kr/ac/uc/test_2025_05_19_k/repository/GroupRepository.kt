package kr.ac.uc.test_2025_05_19_k.repository

import kr.ac.uc.test_2025_05_19_k.model.StudyGroup
import kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail
import kr.ac.uc.test_2025_05_19_k.network.api.GroupApi
import kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequest
import kr.ac.uc.test_2025_05_19_k.model.PageStudyGroupDto
import javax.inject.Inject

class GroupRepository @Inject constructor(
    private val groupApi: GroupApi
) {
    suspend fun getGroups(region: String, keyword: String?, interest: String?, page: Int? = 0, size: Int? = 10): List<StudyGroup> {
        val pageResult: PageStudyGroupDto = groupApi.getGroups(region, keyword, interest, page, size)
        return pageResult.content // 반환 타입: List<StudyGroup>
    }

    suspend fun getGroupDetail(groupId: Long): StudyGroupDetail {
        return groupApi.getGroupDetail(groupId)
    }

    suspend fun applyToGroup(groupId: Long) {
        groupApi.applyToGroup(groupId)
    }

    suspend fun createGroup(request: GroupCreateRequest) {
        groupApi.createGroup(request)
    }

}
