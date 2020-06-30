package ru.k0der.simpleapp.data.response

import com.google.gson.annotations.SerializedName

class CreateResponse(
    @SerializedName("point")
    val point: PointResponse,
    @SerializedName("sent")
    val sent: String,
    @SerializedName("trip_id")
    val trip_id: Long,
    @SerializedName("type")
    val type: Int,
    @SerializedName("speed")
    val speed: Int
)