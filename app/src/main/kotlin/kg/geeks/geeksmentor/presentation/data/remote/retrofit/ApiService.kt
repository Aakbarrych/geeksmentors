package kg.geeks.geeksmentor.presentation.data.remote.retrofit

import kg.geeks.geeksmentor.presentation.data.model.ApiResponse
import kg.geeks.geeksmentor.presentation.data.model.LoginRequest
import kg.geeks.geeksmentor.presentation.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("products")
    suspend fun getAllMentors(): Response<ApiResponse>

    //@GET("products")
    //suspend fun getAllMentors(): List<MentorList>

    // Другие методы API здесь
}
