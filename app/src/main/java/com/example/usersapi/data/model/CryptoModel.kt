package com.example.usersapi.data.model


import com.google.gson.annotations.SerializedName

data class CryptoModel(
    @SerializedName("coin")
    val coin: String? = "",
    @SerializedName("network")
    val network: String? = "",
    @SerializedName("wallet")
    val wallet: String? = ""
)