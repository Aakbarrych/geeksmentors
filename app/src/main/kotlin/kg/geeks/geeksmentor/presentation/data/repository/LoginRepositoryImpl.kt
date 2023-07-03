package kg.geeks.geeksmentor.presentation.data.repository

import kg.geeks.geeksmentor.data.model.LoginRequest
import kg.geeks.geeksmentor.data.model.LoginResponse
import kg.geeks.geeksmentor.data.remote.retrofit.ApiService
import kg.geeks.geeksmentor.data.remote.retrofit.RetrofitClient
import kg.geeks.geeksmentor.repository.LoginRepository

class LoginRepositoryImpl : LoginRepository {
    private val apiService: ApiService = RetrofitClient.apiService

    override suspend fun login(username: String, password: String): LoginResponse {
        val request = LoginRequest(username, password)
        return apiService.login(request)
    }
}