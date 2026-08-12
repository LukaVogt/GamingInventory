package com.luka.gaminginventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
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
import com.luka.gaminginventory.ui.theme.GamingInventoryTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateListOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamingInventoryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, ) {

    //Objects

    //Games

    val games = remember { mutableStateListOf(
        Game("Spiderman", 80.00, "Playstation", "Used - good condition"),
        Game("Minecraft", 30.00, "PC", "New"),
        Game("The Legend of Zelda", 60.00, "Nintendo Switch", "Used - like new"),
        Game("GTA V", 20.00, "Xbox", "Used - acceptable"),
        Game("Elden Ring", 45.00, "Playstation", "Used - good condition"),
        Game("Cyberpunk 2077", 25.00, "PC", "Used - good condition"),
        Game("Mario Kart 8 Deluxe", 50.00, "Nintendo Switch", "New"),
        Game("Red Dead Redemption 2", 15.00, "Xbox", "Used - acceptable"),
        Game("Hades", 20.00, "PC", "New"),
        Game("Animal Crossing: New Horizons", 40.00, "Nintendo Switch", "Used - like new"),
        Game("God of War Ragnarök", 55.00, "Playstation", "Used - like new"),
        Game("Halo Infinite", 18.00, "Xbox", "Used - good condition"),
        Game("The Witcher 3: Wild Hunt", 12.00, "PC", "Used - acceptable"),
        Game("Super Mario Odyssey", 45.00, "Nintendo Switch", "Used - good condition"),
        Game("FIFA 23", 10.00, "Playstation", "Used - acceptable")
    ) }

    //Displays

    val displays = remember { mutableStateListOf(
        Display("LG", 340.00, "Television", "VA", 2160, 60, "Good"),
        Display("Samsung", 699.99, "Gaming Monitor", "OLED", 1440, 240, "Excellent"),
        Display("Dell", 249.50, "Office Monitor", "IPS", 1440, 75, "Great"),
        Display("Sony", 1199.00, "Television", "OLED", 2160, 120, "Excellent"),
        Display("ASUS", 450.00, "Gaming Monitor", "IPS", 1080, 360, "Very Good"),
        Display("BenQ", 189.00, "Office Monitor", "TN", 1080, 60, "Fair"),
        Display("Gigabyte", 319.99, "Gaming Monitor", "VA", 1440, 165, "Good"),
        Display("Philips", 899.00, "Television", "Mini-LED", 2160, 120, "Great")

    ) }

    var currentScreen by remember { mutableStateOf(0)}

    //Game Variables

    var gameName by remember { mutableStateOf("") }
    var gamePrice by remember { mutableStateOf("") }
    var gamePlatform by remember {mutableStateOf("")}

    //Display Variables

    var displayBrand by remember {mutableStateOf("")}
    var displayPrice by remember { mutableStateOf("") }
    var displayType by remember { mutableStateOf("") }
    var displayPanel by remember { mutableStateOf("") }
    var displayResolution by remember { mutableStateOf("") }
    var displayRefreshRate by remember { mutableStateOf("") }
    var displayCondition by remember { mutableStateOf("") }

    when (currentScreen){

        // Homescreen

        0 ->{
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
                        currentScreen = 1

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
                        currentScreen = 3

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


        //Game Screen

        1->{
            LazyColumn(
                modifier = modifier.fillMaxSize() ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(games) {game ->
                    
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
                            games.remove(game)
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
                            currentScreen = 2
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
                            currentScreen = 0
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



        //Add game

        2 ->{
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
                        games.add(Game(gameName, priceDouble, gamePlatform, "New"))

                        gameName = ""
                        gamePrice = ""
                        gamePlatform = ""
                        currentScreen = 1


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




        //Show Displays

        3 ->{
            LazyColumn(
                modifier = modifier.fillMaxSize() ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(displays) {display ->

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
                            displays.remove(display)
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
                            currentScreen = 4
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
                            currentScreen = 0
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





        // Add Display
        4 ->{
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
                        displays.add(Display(displayBrand,displayPriceDouble,displayType,displayPanel,displayResolutionDouble,displayRefreshRateDouble,displayCondition))

                        displayBrand = ""
                        displayPrice = ""
                        displayType = ""
                        displayPanel = ""
                        displayResolution = ""
                        displayRefreshRate = ""
                        displayCondition = ""
                        currentScreen = 3


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

    }


}
