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


TODO:
- Add a back button to be able to start a new game
- Create a testing strategy for what we have until this point
- Update E2E test to include a mock of the API, such that the chessboard shows the pieces