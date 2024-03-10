package com.example.movieappmad24

import androidx.compose.foundation.background
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

//This Class functions as AppBars (MainScreen)
class AppBars {

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun TopAppBar(){
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = { Text("MovieApp", fontWeight = FontWeight.Bold) }
        )
    }

    @Composable
    fun BottomAppBar(){
        androidx.compose.material3.BottomAppBar(modifier = Modifier.background(Color.Blue)) {
            NavigationBarItem(
                label = { Text(text = "Home") },
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = null
                    )
                })
            NavigationBarItem(
                label = { Text(text = "Watchlist") },
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_24),
                        contentDescription = null
                    )
                })
        }
    }
}