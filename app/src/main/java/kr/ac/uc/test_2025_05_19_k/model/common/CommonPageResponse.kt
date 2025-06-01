package kr.ac.uc.test_2025_05_19_k.model.common

data class CommonPageResponse<T>(
    val content: List<T>,
    val pageable: PageableDto,
    val totalPages: Int,
    val totalElements: Long,
    val last: Boolean,
    val size: Int,
    val number: Int,
    val sort: SortDto,
    val numberOfElements: Int,
    val first: Boolean,
    val empty: Boolean
)