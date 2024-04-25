package com.ns.beautifulscreens

import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class HomePageSnapshotTest {
    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun testGameStartScreenWithButton() {
        paparazzi.snapshot {
            GameStartScreenPreview()
        }
    }

//    @Test
//    fun testGameStartScreenWithChessboard() {
//        paparazzi.snapshot {
//            GameStartScreen("I already started, keep up!")
//                .also { /* Here the magic happens and the chessboard is visible */ }
//        }
//    }
}
