package ru.k0der.simpleapp.data

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import ru.k0der.simpleapp.data.response.BaseResponse
import ru.k0der.simpleapp.data.response.BodyAuth
import ru.k0der.simpleapp.data.response.CreateResponse
import ru.k0der.simpleapp.data.response.ResultErrorResponse

interface BaseAPI {

    @Headers("Content-Type:application/json; charset=UTF-8")
    @POST("v3/driver/auth/auth")
    suspend fun auth(@Body bodyAuth: BodyAuth): BaseResponse

    @Headers("Content-Type:application/json; charset=UTF-8")
    @POST("v3/locations/create")
    suspend fun locationsCreate(
        @Header("Authorization") token: String,
        @Body points: List<CreateResponse>
    ): ResultErrorResponse

}