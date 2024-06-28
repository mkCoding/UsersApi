package com.example.usersapi.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersapi.data.model.UserModel
import com.example.usersapi.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {

    //create variables to hold data that will be observed in View
    private val _allUsers = MutableStateFlow <List<UserModel>?> (emptyList())
    val allUsers : MutableStateFlow  <List<UserModel>?> = _allUsers

    //Using Mutable state flow as it is best for handling BE functionality for async data processes


    init {
        getAllUsers()
    }

    private fun getAllUsers() {
       viewModelScope.launch {
           val allUsers = repository.getAllUsers().users //grab all users from API

           if(allUsers!=null){
               _allUsers.value = allUsers //add users to allUsers variable so it can be observed in view

               Log.d("UsersViewModel", allUsers.toString())
           }


       }


    }


}