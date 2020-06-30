package ru.k0der.simpleapp.data.response

import com.google.gson.annotations.SerializedName

class PointResponse(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double
)