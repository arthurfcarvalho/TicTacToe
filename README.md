
# TicTacToe

A simple and interactive Tic-Tac-Toe game built for Android using Kotlin for the logic and XML for the layout. This project allows two players to alternate turns, automatically detecting when a player wins or when the game results in a draw.

## Features
- **Interactive Gameplay**: Players alternate turns by clicking on a 3x3 grid to place "X" or "O".
- **Game Status**: Displays the current player’s turn and announces the winner or a draw at the end of the game.
- **Invalid Move Prevention**: Ensures players cannot place a mark on an already occupied cell.
- **Reset Button**: A button to restart the game at any time.

## Project Structure
The game interface is structured with a `GridLayout` in XML, representing the Tic-Tac-Toe board as a 3x3 grid of buttons. Above the board, a `TextView` shows the current game status. The game logic, including turn alternation and win/draw detection, is implemented in Kotlin.

## Interface

![image](https://github.com/user-attachments/assets/819a7514-1a1b-4990-a336-896abe9cfd5a)

## How to Play
1. Player X goes first, followed by Player O. Alternate turns by tapping on any empty cell in the grid.
2. The first player to align three of their symbols horizontally, vertically, or diagonally wins.
3. If all cells are filled without a winner, the game declares a draw.
4. Use the "Restart Game" button to reset the board and start a new game.

## Getting Started
To try the game:
1. Clone this repository.
2. Open the project in Android Studio.
3. Run the application on an Android emulator or physical device.

## Installation
Clone the repository using the command:

     git clone https://github.com/arthurfcarvalho/TicTacToe.git

Open the project in Android Studio, build, and run it on an Android device or emulator.
