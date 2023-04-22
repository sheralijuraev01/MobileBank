package uz.sher.bank.datasource

import retrofit2.Call
import retrofit2.Response
import uz.sher.bank.api.ApiService
import uz.sher.bank.model.ResponseAuth
import uz.sher.bank.model.SignInPost

class RemoteDataSource(private val api: ApiService) {
    fun getPostSignIn(signInPost: SignInPost): Call<ResponseAuth> {
        return api.loginUser(signInPost)
    }
}