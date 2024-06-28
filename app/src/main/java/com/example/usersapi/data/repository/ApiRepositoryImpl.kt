package com.example.usersapi.data.repository

import com.example.usersapi.data.api.ApiEndpoints
import com.example.usersapi.data.model.UsersModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(val apiEndpoints: ApiEndpoints) :ApiRepository {

    //this method will be able to be called throughout the app as long as its injected
    override suspend fun getAllUsers(): UsersModel = apiEndpoints.getAllUsers()

}