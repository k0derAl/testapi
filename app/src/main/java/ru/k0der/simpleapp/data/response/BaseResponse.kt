package ru.k0der.simpleapp.data.response

import com.google.gson.annotations.SerializedName

class BaseResponse(
    @SerializedName("result")
    val result: BaseResult?,
    @SerializedName("error")
    val error: ErrorResponse?
)