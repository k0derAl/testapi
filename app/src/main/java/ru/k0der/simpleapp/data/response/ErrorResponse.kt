package ru.k0der.simpleapp.data.response

import com.google.gson.annotations.SerializedName

class ErrorResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("status")
    val status: Int
)