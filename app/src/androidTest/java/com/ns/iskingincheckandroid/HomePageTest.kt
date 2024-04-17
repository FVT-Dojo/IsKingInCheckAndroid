import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
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
    fun checkButtonIsDisplayed() {
        // Test the actual button from MainActivity without setting new content
        composeTestRule
            .onNodeWithText("Start the game, hombre!")
            .assertIsDisplayed()
    }
}
