package com.example.everfittest.data.model

import com.google.gson.annotations.SerializedName

data class AssignmentData(
    @SerializedName("_id")
    val id: String,
    @SerializedName("assignments")
    val assignments: List<Assignment>
)