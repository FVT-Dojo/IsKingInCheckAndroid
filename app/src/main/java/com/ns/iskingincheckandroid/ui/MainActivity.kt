package com.ns.iskingincheckandroid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ns.beautifulscreens.ui.GameStartScreen
import com.ns.beautifulscreens.ui.theme.IsKingInCheckAndroidTheme
import com.ns.beautifulscreens.viewmodel.GameStartViewModel

class MainActivity : ComponentActivity() {

    private val gameStartViewModel: GameStartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IsKingInCheckAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameStartScreen(viewModel = gameStartViewModel)
                }
            }
        }
    }
}
