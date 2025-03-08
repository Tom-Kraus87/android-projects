package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.R.drawable.lemon_drink
import com.example.lemonade.R.drawable.lemon_restart
import com.example.lemonade.R.drawable.lemon_squeeze
import com.example.lemonade.R.drawable.lemon_tree
import com.example.lemonade.R.string.drink_lemonade
import com.example.lemonade.R.string.empty_glass
import com.example.lemonade.R.string.full_glass
import com.example.lemonade.R.string.glass
import com.example.lemonade.R.string.lemon
import com.example.lemonade.R.string.lemon_select
import com.example.lemonade.R.string.squeeze_lemon
import com.example.lemonade.R.string.tree
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCounter by remember { mutableStateOf(0) }
    var showWelcomeScreen by remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (showWelcomeScreen) {
            WelcomeScreen(name = "Tom") {
                showWelcomeScreen = false
            }
        } else {
            Column {
                // Fixed yellow bar at the top
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Yellow) // Yellow background
                        .padding(vertical = 16.dp)
                        .height(64.dp)// Padding for the bar
                ) {
                    Text(
                        text = "Lemonade",
                        color = Color.White, // White text color
                        fontSize = 38.sp, // Text size
                        fontWeight = FontWeight.Bold, // Bold text
                        modifier = Modifier.align(Alignment.Center) // Center text horizontally and vertically
                    )
                }

                // Main content
                when (currentStep) {
                    1 -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(250.dp) // Fixed size for the Box
                                    .background(
                                        Color(159, 224, 200),
                                        shape = RoundedCornerShape(20)
                                    )
                                    .border(
                                        width = 2.dp, // Border width
                                        color = Color(159, 224, 200),
                                        shape = RoundedCornerShape(20)
                                    )
                                    .clip(RoundedCornerShape(20))
                                    .clickable {
                                        currentStep = 2
                                        squeezeCounter = (2..4).random()
                                    }
                                    .align(Alignment.CenterHorizontally) // Center Box horizontally
                            ) {
                                Image(
                                    painter = painterResource(lemon_tree),
                                    contentDescription = stringResource(tree),
                                    contentScale = ContentScale.Fit, // Fit the image inside the Box
                                    modifier = Modifier
                                        .size(230.dp) // Smaller size for the Image
                                        .align(Alignment.Center) // Center Image in the Box
                                )
                            }
                            Spacer(modifier = Modifier.height(32.dp))
                            Text(
                                text = stringResource(lemon_select),
                                fontSize = 18.sp
                            )
                        }
                    }

                    2 -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(250.dp) // Fixed size for the Box
                                    .background(
                                        Color(159, 224, 200),
                                        shape = RoundedCornerShape(20)
                                    )
                                    .border(
                                        width = 2.dp, // Border width
                                        color = Color(159, 224, 200),
                                        shape = RoundedCornerShape(20)
                                    )
                                    .clip(RoundedCornerShape(20))
                                    .clickable {
                                        squeezeCounter--
                                        if (squeezeCounter == 0) {
                                            currentStep = 3
                                        }
                                    }
                                    .align(Alignment.CenterHorizontally) // Center Box horizontally
                            ) {
                                Image(
                                    painter = painterResource(lemon_squeeze),
                                    contentDescription = stringResource(lemon),
                                    contentScale = ContentScale.Fit, // Fit the image inside the Box
                                    modifier = Modifier
                                        .size(230.dp) // Smaller size for the Image
                                        .align(Alignment.Center) // Center Image in the Box
                                )
                            }
                            Spacer(modifier = Modifier.height(32.dp))
                            Text(
                                text = stringResource(squeeze_lemon),
                                fontSize = 18.sp
                            )
                        }
                    }

                    3 -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(250.dp) // Fixed size for the Box
                                    .background(
                                        Color(159, 224, 200),
                                        shape = RoundedCornerShape(20)
                                    )
                                    .border(
                                        width = 2.dp, // Border width
                                        color = Color(159, 224, 200),
                                        shape = RoundedCornerShape(20)
                                    )
                                    .clip(RoundedCornerShape(20))
                                    .clickable {
                                        currentStep = 4
                                    }
                                    .align(Alignment.CenterHorizontally) // Center Box horizontally
                            ) {
                                Image(
                                    painter = painterResource(lemon_drink),
                                    contentDescription = stringResource(full_glass),
                                    contentScale = ContentScale.Fit, // Fit the image inside the Box
                                    modifier = Modifier
                                        .size(230.dp) // Smaller size for the Image
                                        .align(Alignment.Center) // Center Image in the Box
                                )
                            }
                            Spacer(modifier = Modifier.height(32.dp))
                            Text(
                                text = stringResource(drink_lemonade),
                                fontSize = 18.sp
                            )
                        }
                    }

                    4 -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(250.dp) // Fixed size for the Box
                                    .background(
                                        Color(159, 224, 200),
                                        shape = RoundedCornerShape(20)
                                    )
                                    .border(
                                        width = 2.dp, // Border width
                                        color = Color(159, 224, 200),
                                        shape = RoundedCornerShape(20)
                                    )
                                    .clip(RoundedCornerShape(20))
                                    .clickable {
                                        currentStep = 1
                                    }
                                    .align(Alignment.CenterHorizontally) // Center Box horizontally
                            ) {
                                Image(
                                    painter = painterResource(lemon_restart),
                                    contentDescription = stringResource(glass),
                                    contentScale = ContentScale.Fit, // Fit the image inside the Box
                                    modifier = Modifier
                                        .size(230.dp) // Smaller size for the Image
                                        .align(Alignment.Center) // Center Image in the Box
                                )
                            }
                            Spacer(modifier = Modifier.height(32.dp))
                            Text(
                                text = stringResource(empty_glass),
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(name: String, onStartClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome $name!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onStartClicked,
            modifier = Modifier
                .padding(16.dp) // Add padding around the button
                .size(250.dp,100.dp) // Set a larger size for the start button
        ) {
            Text(
                "Make Lemonade!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}