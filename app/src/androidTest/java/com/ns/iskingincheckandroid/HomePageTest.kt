
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ns.iskingincheckandroid.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomePageTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun checkButtonIsDisplayedAndClickable() {
        // Click the button
        composeTestRule
            .onNodeWithText("Start the game, hombre!")
            .assertIsDisplayed()
            .performClick()

        // Fetch all nodes tagged as "ChessCell" and verify there are exactly 64 such nodes
        val chessCells = composeTestRule.onAllNodes(hasTestTag("ChessCell"))
        assert(chessCells.fetchSemanticsNodes().size == 64) // Make sure there are exactly 64 cells

        // If required, check the visibility of the first cell (assuming all are similarly managed)
        composeTestRule
            .onNode(hasTestTag("ChessCell"), useUnmergedTree = true) // Adjust tag if each cell has a unique tag
            .assertIsDisplayed()
    }
}
