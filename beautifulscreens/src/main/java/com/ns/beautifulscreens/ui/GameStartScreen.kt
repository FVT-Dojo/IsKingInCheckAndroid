package com.ns.beautifulscreens.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ns.beautifulscreens.ui.theme.IsKingInCheckAndroidTheme
import com.ns.beautifulscreens.viewmodel.GameStartViewModel

@Composable
fun GameStartScreen(viewModel: GameStartViewModel) {
    val showChessboard = viewModel.showChessboard.collectAsState().value
    val chessboardState = viewModel.chessboardState.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!showChessboard) {
            Button(onClick = {
                viewModel.startGame()
            }) {
                Text("Start the game, hombre!")
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Chessboard(chessboardState)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    viewModel.resetGame()
                }) {
                    Text("Back")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameStartScreenButtonPreview() {
    val viewModel: GameStartViewModel = GameStartViewModel()
    IsKingInCheckAndroidTheme {
        GameStartScreen(viewModel)
    }
}
