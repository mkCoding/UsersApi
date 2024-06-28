package com.example.usersapi.ui

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UsersListScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Users",
            style = TextStyle(fontSize = 30.sp)
        )

        UsersList()


    }




}

@Composable
fun UsersList(){

    val viewModel: UsersViewModel = viewModel()
    val usersList by viewModel.allUsers.collectAsState()

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.height(900.dp)

    ) {
        items(usersList?: emptyList()){ userItem->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)

            ) {

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Text(text = "First Name: ${userItem.firstName}")
                    Text(text = "Last Name: ${userItem.lastName}")
                    Text(text = "Age: ${userItem.age}")
                    Text(text = "Birthdate: ${userItem.birthDate}")
                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewUsersListScreen(){
    UsersListScreen()
}