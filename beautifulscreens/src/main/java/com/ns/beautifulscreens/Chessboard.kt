package com.ns.beautifulscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun Chessboard() {
    Column(modifier = Modifier.testTag("chessboard")) {
        for (i in 0 until 8) {
            Row {
                for (j in 0 until 8) {
                    Surface(
                        modifier = Modifier
                            .size(48.dp) // Assuming each cell is a 48.dp square
                            .testTag("ChessCell-$i-$j-${if ((i + j) % 2 == 0) "Light" else "Dark"}" ), // Adding a specific test tag for each cell
                        color = if ((i + j) % 2 == 0) Color.LightGray else Color.DarkGray

                    ) {
                        // This part can be customized as per your app's requirements
                    }
                }
            }
        }
    }
}
