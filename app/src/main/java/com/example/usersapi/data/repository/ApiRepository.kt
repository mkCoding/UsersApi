package com.example.usersapi.data.repository

import com.example.usersapi.data.model.UsersModel

interface ApiRepository {
    suspend fun getAllUsers():UsersModel
}