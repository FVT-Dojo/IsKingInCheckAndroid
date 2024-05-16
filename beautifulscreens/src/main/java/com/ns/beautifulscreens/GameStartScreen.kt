package com.ns.beautifulscreens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ns.beautifulscreens.ui.theme.IsKingInCheckAndroidTheme
import com.ns.beautifulscreens.viewmodel.GameStartViewModel

@Composable
fun GameStartScreen(viewModel: GameStartViewModel = viewModel()) {
    val showChessboard = viewModel.showChessboard.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!showChessboard) {
            Button(onClick = {
                Log.d("Button", "Someone poked the mexican!")
                viewModel.startGame()
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
fun GameStartScreenChessboardPreview() {
    IsKingInCheckAndroidTheme {
        GameStartScreen()
    }
}
