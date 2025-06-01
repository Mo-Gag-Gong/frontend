package kr.ac.uc.test_2025_05_19_k.model.common

data class PageableDto(
    val pageNumber: Int,
    val pageSize: Int,
    val sort: SortDto,
    val offset: Long,
    val paged: Boolean,
    val unpaged: Boolean
)