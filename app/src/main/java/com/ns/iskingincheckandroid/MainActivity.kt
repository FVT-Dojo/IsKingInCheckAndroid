package com.ns.iskingincheckandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ns.iskingincheckandroid.ui.theme.IsKingInCheckAndroidTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IsKingInCheckAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameStartScreen("Start the game, hombre!")
                }
            }
        }
    }
}

@Composable
fun GameStartScreen(buttonText: String) {
    var showChessboard by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!showChessboard) {
            Button(onClick = { showChessboard = true }) {
                Text(buttonText)
            }
        } else {
            Chessboard()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IsKingInCheckAndroidTheme {
        GameStartScreen("Start the game, hombre!")
    }
}
