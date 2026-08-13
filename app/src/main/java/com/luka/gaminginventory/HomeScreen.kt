package com.luka.gaminginventory

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToGames: () -> Unit,
    onNavigateToTVs: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Inventory",
            fontSize = 45.sp
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Please Select",
            fontSize = 35.sp
        )

        Spacer(modifier = Modifier.height(70.dp))

        Button(
            onClick = {
                onNavigateToGames()

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            modifier = Modifier
                .height(100.dp)
                .width(250.dp)
        ) {
            Text(
                text = "Games",
                fontSize = 35.sp
            )
        }

        Spacer(modifier = Modifier.height(70.dp))

        Button(
            onClick = {
                onNavigateToTVs()

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            modifier = Modifier
                .height(100.dp)
                .width(250.dp)
        ) {
            Text(
                text = "TVs/Monitors",
                fontSize = 30.sp
            )
        }
    }
}
