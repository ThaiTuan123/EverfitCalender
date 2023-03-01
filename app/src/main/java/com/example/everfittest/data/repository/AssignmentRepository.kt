package com.example.everfittest.data.repository

import com.example.everfittest.data.model.AssignmentResponse

interface AssignmentRepository {
    suspend fun getAssignments(): AssignmentResponse
}