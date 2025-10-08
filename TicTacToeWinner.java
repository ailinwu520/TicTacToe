import java.util.Arrays;

/**
* Lab-2 Tictactoe
* @author: Jack Boccuzzi
*/
public class TicTacToeWinner {
    /**
     * Find out the winner of the tictactoe game
     * @param moves the moves of two players in the 2D array
     * @return result of the game: "A", "B", "Pending", "Draw"
     */

    public String ttcWinner(int[][] moves) { //returns "A", "B", "Draw", or "Pending"
        int playerA = 1;
        int playerB = 2;

        // create the board
        int[][] gameBoard = new int[3][3];
        // place "0" in every space to declare it as empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = 0;
            }
        }
        // place the moves from the array of moves into the board and check for winner
        for (int i = 0; i < moves.length; i++) {
            // check if the board position at the coordinates in the array of moves is empty
            if (gameBoard[moves[i][0]][moves[i][1]] == 0) {
                if (i % 2 == 0) { // A's turn (even indices)
                    gameBoard[moves[i][0]][moves[i][1]] = playerA;
                    // after each placement check if there is a winner
                    if (checkWin(gameBoard)) {
                        return "A";
                    }
                }
                else { // B's turn (odd indices)
                    gameBoard[moves[i][0]][moves[i][1]] = playerB;
                    // after each placement check if there is a winner
                    if (checkWin(gameBoard)) {
                        return "B";
                    }
                }
            }
            // If move is invalid (space already occupied), skip it but continue processing
        }
        // Determine if the board is full (and tie?)
        int spaceCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] != 0) { // if board space is not empty
                    spaceCounter++;
                }
            }
        }
        if (spaceCounter == 9) {
            return "Draw";
        }
        return "Pending";
    }

    public boolean checkWin (int[][] board){
        int matchCount = 0;

        // check if user matches horizontal pieces
        for (int row = 0; row < board.length; row++) { // index over row first then column
            for (int col = 0; col < board.length - 1; col++) {
                if (board[row][col] == 1 || board[row][col] == 2) { // is current piece valid (1=A, 2=B)
                    if (board[row][col] == board[row][col + 1]) {// checks if the current piece == piece next to it by increasing column index
                        matchCount++;
                    }
                    else {
                        matchCount = 0;
                    }
                }
                if (matchCount == board.length - 1) {
                    return true;
                }
            }
            matchCount = 0; // to reset the counter after checking an entire column
        }

        // check if the user matches vertical pieces
        for (int col = 0; col < board.length; col++) { // index over column first then row
            for (int row = 0; row < board.length - 1; row++) {
                if (board[row][col] == 1 || board[row][col] == 2) { // is current piece valid (1=A, 2=B)
                    // checks to see if the current piece, matches the piece below it by increasing row index
                    if (board[row][col] == board[row + 1][col]) {
                        matchCount++;
                    }
                    else {
                        matchCount = 0;
                    }
                }
                if (matchCount == board.length - 1) {
                    return true;
                }
            }
            matchCount = 0; // to reset counter after checking each row
        }

        // Check main diagonal (top-left to bottom-right)
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }

        // Check anti-diagonal (top-right to bottom-left)
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //You may modify the main to test examples
        TicTacToeWinner winner = new TicTacToeWinner();

//      -> Expected winner: "A"
        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(winner.ttcWinner(moves));

//      -> Expected winner: "B"
        int[][] moves2 = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(winner.ttcWinner(moves2));

//      -> Expected result: "Draw"
        int[][] moves3 = {{0,0},{1,1},{0,2},{0,1},{2,2},{1,2},{2,1},{2,0},{1,0}};
        System.out.println(winner.ttcWinner(moves3));

//      -> Expected result: "Pending"
//      {{1,1},{0,0}}, {{2,1},{0,1},{0,2}}, {{0,0},{0,1},{2,1}}
        int[][] moves4 = {{1,0},{2,0},{0,1}};
        System.out.println(winner.ttcWinner(moves4));
    }
}
