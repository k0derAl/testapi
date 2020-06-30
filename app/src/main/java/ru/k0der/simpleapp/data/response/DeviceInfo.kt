package ru.k0der.simpleapp.data.response

import com.google.gson.annotations.SerializedName

class DeviceInfo(
    @SerializedName("os")
    val os: String,
    @SerializedName("app_version")
    val appVersion: Int,
    @SerializedName("hardware_id")
    val hardwareId: Int
)