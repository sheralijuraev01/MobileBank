package uz.sher.bank.data.network.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import uz.sher.bank.data.network.model.ResponseModel
import uz.sher.bank.data.network.model.SignInPost
import uz.sher.bank.data.network.model.SignUpPost

interface ApiService {

    @POST("login")
    suspend fun loginUser(@Body signInPost: SignInPost): Response<ResponseModel>

    @POST("register")
    suspend fun createUser(@Body signUpPost: SignUpPost): Response<ResponseModel>

    @POST("verify")
    suspend fun verifyUser(
        @Header("Authorization") apiKey: String,
        @Query("code") query: String
    ): Response<ResponseModel>
}