package uz.sher.bank.data.network.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("object")
    val objectX: Any?

)