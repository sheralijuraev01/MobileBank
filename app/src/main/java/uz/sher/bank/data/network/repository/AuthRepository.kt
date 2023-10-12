package uz.sher.bank.data.network.repository

import uz.sher.bank.data.local.sharedPref.SharedPrefRepository
import uz.sher.bank.data.network.api.ApiService
import uz.sher.bank.data.network.model.SignInPost
import uz.sher.bank.data.network.model.SignUpPost
import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val sharedPreference: SharedPrefRepository
) {

    suspend fun loginUser(signInPost: SignInPost) =
        apiService.loginUser(signInPost)

    suspend fun createUser(singUpPost: SignUpPost) =
        apiService.createUser(singUpPost)

    suspend fun verifyUser(token:String,code: String) =
        apiService.verifyUser(apiKey =token, query = code)

    suspend fun saveToken(token: String) = sharedPreference.saveToken(token)
    fun getToken(): String = sharedPreference.getToken()


}