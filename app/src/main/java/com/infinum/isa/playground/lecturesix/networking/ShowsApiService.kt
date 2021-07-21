package com.infinum.isa.playground.lecturesix.networking

import com.infinum.isa.playground.lecturesix.models.RegisterRequest
import com.infinum.isa.playground.lecturesix.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ShowsApiService {

    @POST("/users")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
}
