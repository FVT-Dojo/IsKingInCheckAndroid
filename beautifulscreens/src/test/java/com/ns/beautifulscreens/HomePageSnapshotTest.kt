package com.ns.beautifulscreens

import app.cash.paparazzi.Paparazzi
import com.ns.beautifulscreens.ui.GameStartScreenButtonPreview
import org.junit.Rule
import org.junit.Test

class HomePageSnapshotTest {
    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun testGameStartScreenWithButton() {
        paparazzi.snapshot {
            GameStartScreenButtonPreview()
        }
    }

    @Test
    fun testGameStartScreenWithChessboard() {
        paparazzi.snapshot {
            GameStartScreenChessboardPreview()
        }
    }
}
