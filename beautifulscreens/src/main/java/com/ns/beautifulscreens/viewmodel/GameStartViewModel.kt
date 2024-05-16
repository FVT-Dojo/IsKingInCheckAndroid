package com.ns.beautifulscreens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import RetrofitClient

class GameStartViewModel : ViewModel() {
    private val _showChessboard = MutableStateFlow(false)
    val showChessboard: StateFlow<Boolean> get() = _showChessboard

    fun startGame() {
        viewModelScope.launch {
            val chessboardState = withContext(Dispatchers.IO) {
                RetrofitClient.service.getChessboardState()
            }
            _showChessboard.value = true
        }
    }
}
