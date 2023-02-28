package com.example.everfittest.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Assignment(
    @SerializedName("_id")
    val id: String,
    @SerializedName("client")
    val client: String,
    @SerializedName("exercises_count")
    val exercisesCount: Int,
    @SerializedName("status")
    val status: Int,
    @SerializedName("title")
    val title: String
) : Parcelable