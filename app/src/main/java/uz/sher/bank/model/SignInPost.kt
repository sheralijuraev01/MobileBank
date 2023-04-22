package uz.sher.bank.model

import com.google.gson.annotations.SerializedName

data class SignInPost(
    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val password: String?
)