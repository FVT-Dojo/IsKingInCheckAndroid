package com.ns.beautifulscreens

import RetrofitClient
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ns.beautifulscreens.ui.theme.IsKingInCheckAndroidTheme

@Composable
fun GameStartScreen(chessboardVisible: Boolean) {
    var showChessboard by remember { mutableStateOf(chessboardVisible) }
    var triggerNetworkCall by remember { mutableStateOf(false) }

    // LaunchedEffect listens to changes on triggerNetworkCall
    LaunchedEffect(triggerNetworkCall) {
        if (triggerNetworkCall) {
            Log.d("Button", "The mexican is furious!")
            // Make the network call on a background thread
            kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
                val chessboardState = RetrofitClient.service.getChessboardState()
                // Update your state based on the result here
                showChessboard = true
                // Reset the trigger so it can be triggered again
                triggerNetworkCall = false
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!showChessboard) {
            Button(onClick = {
                Log.d("Button", "Someone poked the mexican!")
                triggerNetworkCall = true
            }) {
                Text("Start the game, hombre!")
            }
        } else {
            Chessboard()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GameStartScreenButtonPreview() {
    IsKingInCheckAndroidTheme {
        GameStartScreen(false)
    }
}

@Preview(showBackground = true)
@Composable
fun GameStartScreenChessboardPreview() {
    IsKingInCheckAndroidTheme {
        GameStartScreen(true)
    }
}