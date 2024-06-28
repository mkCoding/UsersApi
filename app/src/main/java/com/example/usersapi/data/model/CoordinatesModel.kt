package com.example.usersapi.data.model


import com.google.gson.annotations.SerializedName

data class CoordinatesModel(
    @SerializedName("lat")
    val lat: Double? = 0.0,
    @SerializedName("lng")
    val lng: Double? = 0.0
)