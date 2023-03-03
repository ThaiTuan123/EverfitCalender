package com.example.everfittest.data.model

import com.google.gson.annotations.SerializedName

data class AssignmentResponse(
    @SerializedName("data")
    var data: List<AssignmentData>
)