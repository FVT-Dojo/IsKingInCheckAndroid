
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ns.iskingincheckandroid.ui.MainActivity
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

        // Assert that an element with the test tag 'chessboard' is visible
        composeTestRule
            .onNode(hasTestTag("chessboard"))
            .assertIsDisplayed()
    }
}
