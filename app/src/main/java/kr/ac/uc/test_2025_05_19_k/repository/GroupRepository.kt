package kr.ac.uc.test_2025_05_19_k.repository

import kr.ac.uc.test_2025_05_19_k.network.ApiService
import kr.ac.uc.test_2025_05_19_k.network.GroupCreateRequest
import kr.ac.uc.test_2025_05_19_k.network.StudyGroup
import kr.ac.uc.test_2025_05_19_k.network.StudyGroupDetail
import javax.inject.Inject

class GroupRepository @Inject constructor(
    private val groupApi: ApiService
) {
    suspend fun getGroups(region: String, keyword: String?, interest: String?): List<StudyGroup> {
        return groupApi.getGroups(region, keyword, interest)
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
