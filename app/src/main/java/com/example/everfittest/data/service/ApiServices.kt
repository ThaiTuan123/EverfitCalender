package com.example.everfittest.data.service

import com.example.everfittest.data.model.Assignment
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("workouts")
    suspend fun getWorkout(): Response<Assignment>

}