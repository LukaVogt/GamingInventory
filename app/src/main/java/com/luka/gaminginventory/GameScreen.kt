package com.luka.gaminginventory

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun GamesScreen(
    modifier: Modifier = Modifier,
    gamesList: List<Game>,               // 1. Hier reiche ich die Spiele-Liste rein
    onRemoveGame: (Game) -> Unit,        // 2. Fernsteuerung zum Löschen eines Spiels
    onNavigateToAddGame: () -> Unit,     // 3. Fernsteuerung für den "Add"-Button
    onNavigateBack: () -> Unit           // 4. Fernsteuerung für den "Back"-Button
) {
    LazyColumn(
        modifier = modifier.fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(gamesList) {game ->

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "${game.title} ",
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${game.platform}",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${game.price}€",
                fontSize = 20.sp
            )
            Button(
                onClick = {
                   onRemoveGame(game)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),

                ) {
                Text(
                    text = "Remove"
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    onNavigateToAddGame()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                modifier = Modifier
                    .height(75.dp)
                    .width(150.dp)
            ) {
                Text(
                    text = "Add",
                    fontSize = 25.sp
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(60.dp))
            Button(
                onClick = {
                    onNavigateBack()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                modifier = Modifier
                    .height(75.dp)
                    .width(150.dp)
            ) {
                Text(
                    text = "Back",
                    fontSize = 25.sp
                )
            }
        }

    }
}
