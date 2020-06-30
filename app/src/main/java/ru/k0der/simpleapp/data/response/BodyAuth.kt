package ru.k0der.simpleapp.data.response

import com.google.gson.annotations.SerializedName

class BodyAuth(
    @SerializedName("login")
    val login: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("device_info")
    val deviceInfo: DeviceInfo
)