package com.example.usersapi.data.model


import com.google.gson.annotations.SerializedName

data class CompanyModel(
    @SerializedName("address")
    val address: AddressModel? = AddressModel(),
    @SerializedName("department")
    val department: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("title")
    val title: String? = ""
)