package com.ns.beautifulscreens.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ns.beautifulscreens.R
import com.ns.beautifulscreens.model.ChessboardState

@Composable
fun Chessboard(chessboardState: ChessboardState?) {
    if (chessboardState != null) {
        Column(modifier = Modifier.testTag("chessboard")) {
            chessboardState.chessboard.forEachIndexed { i, row ->
                Row {
                    row.forEachIndexed { j, piece ->
                        ChessCell(i, j, piece)
                    }
                }
            }
            ChessboardStatus(isKingInCheck = chessboardState.isKingInCheck)
        }
    } else {
        Text("Loading chessboard...", modifier = Modifier.testTag("LoadingText"))
    }
}

@Composable
fun ChessCell(i: Int, j: Int, piece: String) {
    Surface(
        modifier = Modifier
            .size(48.dp)
            .testTag("ChessCell-$i-$j-${if ((i + j) % 2 == 0) "Light" else "Dark"}"),
        color = if ((i + j) % 2 == 0) Color.LightGray else Color.DarkGray
    ) {
        if (piece.isNotEmpty()) {
            val icon = when (piece) {
                "K" -> "\u265A" // Unicode for the King icon (replace with actual Unicode or image resource)
                "Q" -> "\u265B" // Unicode for the Queen icon
                "R" -> "\u265C" // Unicode for the Rook icon
                // ... add mappings for other pieces ...
                else -> piece  // Keep the default text if no icon is found
            }
            Text(
                text = icon,
                color = if ((i + j) % 2 == 0) Color.Black else Color.White,
                modifier = Modifier.padding(8.dp),
                fontFamily = FontFamily(Font(R.font.chess_merida_unicode)
                )
            )
        }
    }
}

@Composable
fun ChessboardStatus(isKingInCheck: Boolean) {
    Text(
        text = if (isKingInCheck) "King is in check!" else "King is not in check!",
        color = Color.Red,
        modifier = Modifier.padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ChessboardPreview() {
    val previewState = ChessboardState(
        chessboard = listOf(
            listOf("R", "", "", "", "", "", "", ""),
            listOf("", "", "", "", "", "", "", ""),
            listOf("", "", "", "", "", "", "", ""),
            listOf("", "", "", "", "", "", "", ""),
            listOf("", "", "", "", "", "", "", ""),
            listOf("", "", "", "", "", "", "", ""),
            listOf("", "", "", "", "", "", "", ""),
            listOf("", "", "", "", "K", "", "", "")
        ),
        isKingInCheck = false
    )
    Chessboard(chessboardState = previewState)
}
