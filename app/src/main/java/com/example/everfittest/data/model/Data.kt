package com.example.everfittest.data.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("_id")
    val id: String,
    @SerializedName("assignments")
    val assignments: List<Assignment>
)