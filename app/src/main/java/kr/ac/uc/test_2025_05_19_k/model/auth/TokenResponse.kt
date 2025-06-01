package kr.ac.uc.test_2025_05_19_k.model.auth

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val userId: Long
)