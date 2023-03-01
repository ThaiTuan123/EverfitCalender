package com.example.everfittest.data.service

import com.example.everfittest.data.model.AssignmentResponse
import retrofit2.http.GET

interface ApiServices {
    @GET("workouts")
    suspend fun getAssignments(): AssignmentResponse
}