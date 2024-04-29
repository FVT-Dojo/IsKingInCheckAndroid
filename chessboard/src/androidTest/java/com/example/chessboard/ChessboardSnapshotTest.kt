import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import com.ns.iskingincheckandroid.Chessboard

class ChessboardSnapshotTest {
    @get: Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_5
    )

    @Test
    fun loginScreenSnapshot() {
        paparazzi.snapshot {
            LoginScreen(…) //<- The composable to make a screenshot from.
        }
    }

}
