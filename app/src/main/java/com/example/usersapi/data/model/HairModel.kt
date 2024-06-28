package com.example.usersapi.data.model


import com.google.gson.annotations.SerializedName

data class HairModel(
    @SerializedName("color")
    val color: String? = "",
    @SerializedName("type")
    val type: String? = ""
)