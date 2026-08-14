package com.luka.gaminginventory

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DisplayScreen(
    modifier: Modifier = Modifier,
    onNavigateToBack: () -> Unit,
    displayList: List<Display>,
    onRemoveDisplay: (Display) -> Unit,
    onNavigateToAddDisplay: () -> Unit
){

    LazyColumn(
        modifier = modifier.fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(displayList) {display ->

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "${display.brand} ",
                fontSize = 40.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${display.price}€",
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${display.type}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${display.panel} ",
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${display.refreshRate} hz ",
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${display.resolution}p ",
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Condition: ${display.condition} ",
                fontSize = 25.sp
            )
            Button(
                onClick = {
                    onRemoveDisplay(display)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),

                ) {
                Text(
                    text = "Remove"
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(60.dp))
            Button(
                onClick = {
                    onNavigateToAddDisplay()
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
                    onNavigateToBack()
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