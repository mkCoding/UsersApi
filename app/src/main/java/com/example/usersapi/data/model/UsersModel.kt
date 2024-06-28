package com.example.usersapi.data.model


import com.google.gson.annotations.SerializedName

data class UsersModel(
    @SerializedName("limit")
    val limit: Int? = 0,
    @SerializedName("skip")
    val skip: Int? = 0,
    @SerializedName("total")
    val total: Int? = 0,
    @SerializedName("users")
    val users: List<UserModel>? = listOf()
)