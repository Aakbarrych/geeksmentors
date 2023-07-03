package kg.geeks.geeksmentor.presentation.repository

import kg.geeks.geeksmentor.data.model.LoginResponse

interface LoginRepository {
    suspend fun login(username: String, password: String): LoginResponse
}