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
fun AddDisplayScreen(
    modifier: Modifier = Modifier,
    onNavigateToBack   : () -> Unit,
    onAddDisplay: (Display) -> Unit

){

    //Display Variables

    var displayBrand by remember {mutableStateOf("")}
    var displayPrice by remember { mutableStateOf("") }
    var displayType by remember { mutableStateOf("") }
    var displayPanel by remember { mutableStateOf("") }
    var displayResolution by remember { mutableStateOf("") }
    var displayRefreshRate by remember { mutableStateOf("") }
    var displayCondition by remember { mutableStateOf("") }


    Column(
        modifier = modifier.fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(20.dp) )
        Text(
            text = "Customize the Display",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(15.dp) )
        OutlinedTextField(
            value = displayBrand,
            onValueChange = {displayBrand = it},
            label = { Text("Brand") }
        )
        Spacer(modifier = Modifier.height(15.dp) )
        OutlinedTextField(
            value = displayPrice,
            onValueChange = {displayPrice = it},
            label = { Text("Price") }
        )
        Spacer(modifier = Modifier.height(15.dp) )
        OutlinedTextField(
            value = displayType,
            onValueChange = {displayType = it},
            label = { Text("Type(Monitor or TV)") }
        )
        Spacer(modifier = Modifier.height(15.dp) )
        OutlinedTextField(
            value = displayPanel,
            onValueChange = {displayPanel = it},
            label = { Text("Panel") }
        )
        Spacer(modifier = Modifier.height(15.dp) )
        OutlinedTextField(
            value = displayResolution,
            onValueChange = {displayResolution = it},
            label = { Text("Resolution") }
        )
        Spacer(modifier = Modifier.height(15.dp) )
        OutlinedTextField(
            value = displayRefreshRate,
            onValueChange = {displayRefreshRate = it},
            label = { Text("Refreshrate in hz") }
        )
        Spacer(modifier = Modifier.height(15.dp) )
        OutlinedTextField(
            value = displayCondition,
            onValueChange = {displayCondition = it},
            label = { Text("Condition") }
        )

        Spacer(modifier = Modifier.height(15.dp) )

        Button(
            onClick = {
                val displayPriceDouble = displayPrice.toDoubleOrNull() ?: 0.0
                val displayResolutionDouble = displayResolution.toIntOrNull() ?: 0
                val displayRefreshRateDouble = displayRefreshRate.toIntOrNull() ?: 0
                onAddDisplay(Display(displayBrand,displayPriceDouble,displayType,displayPanel,displayResolutionDouble,displayRefreshRateDouble,displayCondition))

                displayBrand = ""
                displayPrice = ""
                displayType = ""
                displayPanel = ""
                displayResolution = ""
                displayRefreshRate = ""
                displayCondition = ""
                onNavigateToBack()


            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
            modifier = Modifier
                .height(75.dp)
                .width(170.dp)
        ) {
            Text(
                text = "Add Display",
                fontSize = 20.sp
            )
        }

    }
}

