package ru.k0der.simpleapp.data.response

import com.google.gson.annotations.SerializedName

class BaseResult(
    @SerializedName("token")
    val token: String?,
    @SerializedName("refresh_token")
    val refToken: String?
)