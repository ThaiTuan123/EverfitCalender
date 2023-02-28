package com.example.everfittest.data.model

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("data")
    val data: List<Data>
)