package com.example.diceroller2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.diceroller2.R.drawable.dice_1
import com.example.diceroller2.R.drawable.dice_2
import com.example.diceroller2.R.drawable.dice_3
import com.example.diceroller2.R.drawable.dice_4
import com.example.diceroller2.R.drawable.dice_5
import com.example.diceroller2.R.drawable.dice_6
import com.example.diceroller2.R.string.roll
import com.example.diceroller2.ui.theme.DiceRoller2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRoller2Theme {
                DiceRollerApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf( 1) }
    val imageResource = when(result) {
        1 -> dice_1
        2 -> dice_2
        3 -> dice_3
        4 -> dice_4
        5 -> dice_5
        else -> dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString())

        Button(
            onClick = { result = (1..6).random() },
        ) {
            Text(
                text = stringResource(roll),
                fontSize = 24.sp
            )
        }
    }
}

