package com.ns.beautifulscreens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.ns.beautifulscreens.model.ChessboardState
import RetrofitClient

class GameStartViewModel : ViewModel() {
    private val _showChessboard = MutableStateFlow(false)
    val showChessboard: StateFlow<Boolean> get() = _showChessboard

    private val _chessboardState = MutableStateFlow<ChessboardState?>(null)
    val chessboardState: StateFlow<ChessboardState?> get() = _chessboardState

    fun startGame() {
        viewModelScope.launch {
            val state = withContext(Dispatchers.IO) {
                RetrofitClient.service.getChessboardState()
            }
            _chessboardState.value = state
            _showChessboard.value = true
        }
    }
}
