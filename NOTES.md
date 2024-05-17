Pomodoro 1:
✅ Create code that displays a chessboard after the button has been clicked.
    ✅Refactor: chessboard to its own file
    ✅Refactor: test chessboard composable

Pomodoro iDunno:
    - ✅ Create snapshot test with paparazzi
    - ✅ Add first API call

Pomodoro 1 16-05-2024:
- Identify what needs to be done to refactor to MVVM
  - ✅MainActivity.kt looks fine for now
  - ✅Create a ViewModel for GameStart
  - ✅Use the ViewModel in the GameStartScreen
  - ✅Removed duplicate preview
  - 🍅Somehow, the pieces are no longer visible on the chessboard. Fix!

Pomodoro 2 16-05-2024
- ✅Somehow, the pieces are no longer visible on the chessboard. Fix!
  - Fixed this by:
    - creating a model for the chessboard state
    - updating the Retrofit service to return a Chessboard state
    - updating the viewmodel to handle the chessboard state and fill it after the api call
    - updating the composables to work with this state
    - updating the chessboard composable to use this state to display the pieces on the board
- ✅Added a label to display if the king is in check or not
- ✅Refactor: MainActivity: define ViewModel outside the composable scope
- ✅Refactor: moved ui elements to a ui folder to adhere to mvvm conventions
- ✅Refactor: Chessboard composable: extracted cell and label logic to improve readability

Pomodoro 3 16-05-2024
- ✅Add a back button to be able to start a new game

Pomodoro 17-05-2024
- ✅Decide on what to test

# Testing backlog:
- Unit test:
  - ViewModel Tests: Ensure that your GameStartViewModel behaves as expected.
    - Test the startGame function to verify it fetches the chessboard state and updates _showChessboard and _chessboardState. 
    - Test the resetGame function to ensure it resets the state correctly.
    
  - Composable Functions: Although UI tests are usually not unit tests, you can use Compose testing to verify that composable functions behave correctly in isolation.
    - Use createComposeRule to test the GameStartScreen, 
    - Chessboard, 
    - and ChessCell composable functions.

- Integration test:
  - ViewModel with Live Data: Test GameStartViewModel with mocked network responses to ensure it integrates correctly with the backend.
  - Composable with ViewModel: Test composable functions like GameStartScreen with GameStartViewModel to ensure they display data correctly.

- End to end test:
  - Simulate User Actions: Test the full flow from starting the app, clicking buttons, and navigating through the UI.
  - Verify UI Changes: Ensure the UI updates correctly based on user interactions and state changes.

