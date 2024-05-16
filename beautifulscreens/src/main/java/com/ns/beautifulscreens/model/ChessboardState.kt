package com.ns.beautifulscreens.model

data class ChessboardState(
    val chessboard: List<List<String>>,
    val isKingInCheck: Boolean
)
