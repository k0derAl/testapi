package ru.k0der.simpleapp.domain

import ru.k0der.simpleapp.data.BaseAPI
import ru.k0der.simpleapp.data.response.BodyAuth
import ru.k0der.simpleapp.data.response.CreateResponse
import ru.k0der.simpleapp.data.response.PointResponse
import javax.inject.Inject

class MainIntercator @Inject constructor(private val apiModule: BaseAPI) {

    suspend fun auth(bodyAuth: BodyAuth) = try {
        apiModule.auth(bodyAuth = bodyAuth)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

    suspend fun locationsCreate(token: String, points: List<CreateResponse>) = try {
        apiModule.locationsCreate(token = token, points = points)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
