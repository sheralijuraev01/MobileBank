package uz.sher.bank.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import uz.sher.bank.model.ResponseAuth
import uz.sher.bank.model.SignInPost
import uz.sher.bank.model.SignUpPost

interface ApiService {

    @POST("login")
    fun loginUser(@Body signInPost: SignInPost): Call<ResponseAuth>

    @POST("register")
    fun createUser(@Body signUpPost: SignUpPost): ResponseAuth

    @POST("verify")
    fun verifyUser(
        @Header("Authorization") apiKey: String,
        @Query("code") query: String
    ): ResponseAuth
}