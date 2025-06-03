package kr.ac.uc.test_2025_05_19_k.model // 패키지 경로는 실제 파일 위치에 맞게

import kr.ac.uc.test_2025_05_19_k.model.StudyGroup

data class PageStudyGroupDto(
    val content: List<StudyGroup>, // <--- 이 필드가 정확히 정의되어 있는지 확인!
    val totalPages: Int,
    val totalElements: Long,
    val size: Int,
    val number: Int, // 현재 페이지 번호 (0부터 시작)
    // API_Final.md의 PageStudyGroupDto 스키마에 있는 'pageable', 'sort', 'numberOfElements', 'first', 'last', 'empty' 등도 필요에 따라 추가/확인
    val first: Boolean,
    val last: Boolean,
    val empty: Boolean,
    val numberOfElements: Int // content 리스트의 실제 요소 개수
)