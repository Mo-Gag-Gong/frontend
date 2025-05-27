package kr.ac.uc.test_2025_05_19_k.viewmodel

data class ProfileUiState(
    val name: String = "",
    val gender: String = "",
    val phoneNumber: String = "",
    val birthYear: Int = 2000,
    val errorMessage: String? = null
)
