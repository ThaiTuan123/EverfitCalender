package com.example.everfittest.data.model

import com.google.gson.annotations.SerializedName

data class AssignmentResponse(
    @SerializedName("data")
    val data: List<AssignmentData>
)