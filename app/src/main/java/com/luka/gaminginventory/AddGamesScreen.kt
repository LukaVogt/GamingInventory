package com.luka.gaminginventory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AddGamesScreen(
    modifier: Modifier = Modifier,
    onAddGame: (Game) -> Unit,
    onNavigateToBack: () -> Unit
){

    var gameName by remember { mutableStateOf("") }
    var gamePrice by remember { mutableStateOf("") }
    var gamePlatform by remember {mutableStateOf("")}

    Column(
        modifier = modifier.fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(30.dp) )
        Text(
            text = "Customize Game",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(30.dp) )
        OutlinedTextField(
            value = gameName,
            onValueChange = {gameName = it},
            label = { Text("Name") }
        )
        Spacer(modifier = Modifier.height(30.dp) )
        OutlinedTextField(
            value = gamePrice,
            onValueChange = {gamePrice = it},
            label = { Text("Price") }
        )
        Spacer(modifier = Modifier.height(30.dp) )
        OutlinedTextField(
            value = gamePlatform,
            onValueChange = {gamePlatform = it},
            label = { Text("Platform") }
        )
        Spacer(modifier = Modifier.height(30.dp) )

        Button(
            onClick = {
                val priceDouble = gamePrice.toDoubleOrNull() ?: 0.0
                onAddGame(Game(gameName, priceDouble, gamePlatform, "New"))

                gameName = ""
                gamePrice = ""
                gamePlatform = ""
                onNavigateToBack()


            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
            modifier = Modifier
                .height(75.dp)
                .width(150.dp)
        ) {
            Text(
                text = "Add Game",
                fontSize = 20.sp
            )
        }

    }

}