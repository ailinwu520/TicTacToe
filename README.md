# TicTacToe Winner Detection

A Java implementation of a TicTacToe game winner detection algorithm for CS245 Lab 2.

## 📋 Project Overview

This project implements a complete TicTacToe game state analyzer that determines the winner of a TicTacToe game given a sequence of moves. The program can identify when Player A wins, Player B wins, the game ends in a draw, or the game is still pending.

## 🎯 Features

- **Winner Detection**: Accurately identifies the winning player
- **Game State Analysis**: Determines if the game is complete or still in progress
- **Draw Detection**: Recognizes when the game ends in a tie
- **Move Validation**: Handles invalid moves gracefully
- **Comprehensive Testing**: Includes multiple test scenarios

## 🚀 How It Works

### Input Format
The program takes a 2D array of moves where each move is represented as `[row, column]` coordinates:
```java
int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
```

### Game Rules
- Player A goes first (even indices: 0, 2, 4, ...)
- Player B goes second (odd indices: 1, 3, 5, ...)
- Players alternate turns
- First player to get 3 in a row (horizontal, vertical, or diagonal) wins

### Return Values
- `"A"` - Player A wins
- `"B"` - Player B wins
- `"Draw"` - Game ends in a tie (board full, no winner)
- `"Pending"` - Game is still in progress

## 🧪 Test Cases

The program includes four comprehensive test scenarios:

1. **Player A Wins**: `{{0,0},{2,0},{1,1},{2,1},{2,2}}`
   - Expected: `"A"`

2. **Player B Wins**: `{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}}`
   - Expected: `"B"`

3. **Draw Game**: `{{0,0},{1,1},{0,2},{0,1},{2,2},{1,2},{2,1},{2,0},{1,0}}`
   - Expected: `"Draw"`

4. **Pending Game**: `{{1,0},{2,0},{0,1}}`
   - Expected: `"Pending"`

## 🔧 Technical Implementation

### Core Components

1. **Board Management**
   - 3x3 integer array representation
   - 0 = empty space, 1 = Player A, 2 = Player B

2. **Win Detection Algorithm**
   - **Horizontal Check**: Scans all rows for 3 consecutive pieces
   - **Vertical Check**: Scans all columns for 3 consecutive pieces
   - **Diagonal Check**: Checks both main diagonal and anti-diagonal

3. **Game State Logic**
   - Processes moves sequentially
   - Checks for winner after each move
   - Determines final game state

### Key Methods

- `ttcWinner(int[][] moves)`: Main method that returns game result
- `checkWin(int[][] board)`: Analyzes board for winning conditions

## 🏃‍♂️ Running the Program

### Compilation and Execution
```bash
javac TicTacToeWinner.java
java TicTacToeWinner
```

### Expected Output
```
A
B
Draw
Pending
```

## 👨‍💻 Author

**Jack Boccuzzi**
CS245 - Data Structures and Algorithms
Lab 2 - TicTacToe Winner Detection

## 📚 Course Information

- **Course**: CS245
- **Assignment**: Lab 2
- **Topic**: Game Logic Implementation and Algorithm Design
- **Focus**: 2D Array Manipulation, Conditional Logic, Method Design

## 🔄 Recent Updates

- Fixed diagonal win detection algorithm for improved accuracy
- Simplified move processing logic for better readability
- Enhanced error handling for invalid moves
- Added comprehensive code documentation
- All test cases verified and passing

---

*This project demonstrates fundamental programming concepts including algorithm design, 2D array manipulation, and game state management in Java.*