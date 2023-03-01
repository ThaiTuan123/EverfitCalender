package com.example.everfittest.data.repository

import com.example.everfittest.data.model.Assignment
import com.example.everfittest.data.model.AssignmentData
import com.example.everfittest.data.model.AssignmentResponse
import com.example.everfittest.data.service.ApiServices

class AssignmentRepositoryImp(private val apiService: ApiServices) : AssignmentRepository {
    override suspend fun getAssignments(): AssignmentResponse {
        return apiService.getAssignments()
    }
}