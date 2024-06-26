package com.ns.beautifulscreens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.ns.beautifulscreens.ui.Chessboard
import org.junit.Rule
import org.junit.Test

class ChessboardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testChessboardColors() {
        composeTestRule.setContent {
            Chessboard()
        }

        // Check that the chessboard is displayed
        composeTestRule
            .onNodeWithTag("chessboard")
            .assertIsDisplayed()

        for (i in 0 until 8) {
            for (j in 0 until 8) {
                val expectedTag = "ChessCell-$i-$j-${if ((i + j) % 2 == 0) "Light" else "Dark"}"
                composeTestRule.onNode(hasTestTag(expectedTag), useUnmergedTree = true)
                    .assertExists("Cell with tag $expectedTag does not exist.")
            }
        }
    }

}
