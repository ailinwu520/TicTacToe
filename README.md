# TicTacToe

## Project Description

This Java project implements a Tic-Tac-Toe winner checker.
Given a sequence of moves played by two players, the program determines whether **Player A**, **Player B** wins, or if the game ends in a **Draw** or is still **Pending**.


## Problem Statement

Given a list of moves for a standard 3x3 Tic-Tac-Toe game, determine the final state of the game:

* `"A"` → Player A wins
* `"B"` → Player B wins
* `"Draw"` → All cells filled, no winner
* `"Pending"` → Game is not yet complete

**Example Input:**

```java
int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
```

**Expected Output:**

```
A
```
