package com.example.movieappmad24

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            CenterAlignedTopAppBar(
                                modifier = Modifier.background(Color.Cyan),
                                title = { Text(text = "MovieApp") },
                            )
                        },
                        bottomBar = {
                            BottomAppBar(modifier = Modifier.background(Color.Cyan)) {
                                NavigationBarItem(
                                    selected = true,
                                    onClick = { /*TODO*/ },
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_home_24),
                                            contentDescription = null
                                        )
                                    })
                                NavigationBarItem(
                                    selected = true,
                                    onClick = { /*TODO*/ },
                                    icon = { Icon(
                                        painter = painterResource(id = R.drawable.baseline_star_24),
                                        contentDescription = null
                                    ) })
                            }
                        },
                        content = {

                        }
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun MovieCard() {
        Column(
            modifier = Modifier
                .height(180.dp)
                .width(350.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Box(
                modifier = Modifier
                    .background(Color.LightGray)
                    .width(350.dp)
                    .height(150.dp)
            )
            {
                Image(
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                            top = 10.dp,
                            end = 10.dp,
                            bottom = 2.dp,
                        )
                        .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.movie_image),
                    contentDescription = "placeholder_image"
                )
                Box() {
                    Icon(
                        modifier = Modifier.padding(
                            top = 18.dp,
                            start = 310.dp,
                        ),
                        painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                        contentDescription = null
                    )
                }
            }
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .height(30.dp)
                    .width(350.dp)
                    .padding(
                        start = 10.dp,
                        end = 10.dp,
                    ),
            ) {


                Text(
                    text = "Avatar"
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.baseline_keyboard_arrow_up_24),
                    contentDescription = null
                )

            }
        }
    }
}