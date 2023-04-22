package uz.sher.bank.model

import com.google.gson.annotations.SerializedName

data class SignUpPost(
    @SerializedName("email")
    val email: String?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("password")
    val password: String?
)
