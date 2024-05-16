package com.ns.iskingincheckandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ns.beautifulscreens.GameStartScreen
import com.ns.beautifulscreens.ui.theme.IsKingInCheckAndroidTheme
import com.ns.beautifulscreens.viewmodel.GameStartViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IsKingInCheckAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val gameStartViewModel: GameStartViewModel = viewModel()
                    GameStartScreen(viewModel = gameStartViewModel)
                }
            }
        }
    }
}
