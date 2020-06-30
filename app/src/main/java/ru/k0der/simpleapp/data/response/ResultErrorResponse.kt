package ru.k0der.simpleapp.data.response

import com.google.gson.annotations.SerializedName

data class ResultErrorResponse(
    @SerializedName("result")
    val result: Boolean,
    @SerializedName("error")
    val error: ErrorResponse?
)