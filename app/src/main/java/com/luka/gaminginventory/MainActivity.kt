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

    var currentScreen by remember { mutableStateOf(2)}

    when (currentScreen){

        // Homescreen

        0 ->{
            HomeScreen(
                onNavigateToGames = { currentScreen = 1 },
                onNavigateToTVs = { currentScreen = 3 }
            )
        }
        //Game Screen
        1-> {
            GamesScreen(
                gamesList = games,
                onRemoveGame = { game -> games.remove(game) },
                onNavigateToAddGame = { currentScreen = 2 },
                onNavigateBack = { currentScreen = 0 }
            )

        }
        //Add game
        2 ->{
            AddGamesScreen(
                onAddGame = {game -> games.add(game)},
                onNavigateToBack = {currentScreen = 1}
            )
        }
        //Show Displays
        3 ->{
            DisplayScreen(
                displayList = displays,
                onRemoveDisplay = {display -> displays.remove(display)},
                onNavigateToAddDisplay = {currentScreen = 4},
                onNavigateToBack = {currentScreen = 0}
            )

        }
        // Add Display
        4 ->{
            AddDisplayScreen(
                onAddDisplay = {display -> displays.add(display)},
                onNavigateToBack = {currentScreen =3}

            )
        }

    }


}
