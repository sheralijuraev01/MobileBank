package uz.sher.bank.model

import com.google.gson.annotations.SerializedName

data class ResponseAuth(
    @SerializedName("message")
    val message: String?,
    @SerializedName("object")
    val objectX: Any?,
    @SerializedName("success")
    val success: Boolean?
)