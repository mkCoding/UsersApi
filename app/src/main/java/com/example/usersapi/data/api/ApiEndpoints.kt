package com.example.usersapi.data.api

import com.example.usersapi.data.model.UsersModel
import retrofit2.http.GET

interface ApiEndpoints {

    @GET(ApiDetails.ENDPOINT_USERS)
    suspend fun getAllUsers():UsersModel //method to grab all users form API
}