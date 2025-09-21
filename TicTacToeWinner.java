/**
* Lab-2 Tictactoe
* @author: Ailin Wu
*/
import java.util.*;
public class TicTacToeWinner {
    /**
     * Find out the winner of the tictactoe game
     *
     * @param moves the moves of two players in the 2D array
     * @return result of the game: "A", "B", "Pending", "Draw"
     */
    // initializing instance variables
    private int[][] board;
    private static int counter;
    private static int firstPlayer = 1;
    private static int secondPlayer = 2;

    // default constructor
    public TicTacToeWinner() {
        // initialize instance variables
        board = new int[3][3];
        initializeBoard();
    }

    // print the board
    public void printBoard() {
        System.out.println("-------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("-------");
        }
    }

    // initialize board
    public void initializeBoard() {
        counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }
    }

    // checking if the board is full
    public boolean boardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public String ttcWinner(int[][] moves) {
        // local variables
        int firstPlayer = 1;
        int secondPlayer = -1;

        // moves
        for (int[] move : moves) {
            int i = move[0];
            int j = move[1];

            // current player
            if (board[i][j] == 0) {
                if (counter % 2 == 0) {
                    board[i][j] = firstPlayer;
                } else
                    board[i][j] = secondPlayer;
            }

            //check for winner
            if (checkRows() || checkColumns() || checkDiagonals()) {
                if (firstPlayer == 1)
                    System.out.println("A");
                else
                    System.out.println("B");
            }
            //change to second player
            firstPlayer *= -1;
        }

        // draw or pending
        if (moves.length == 9 && boardFull()) {
            return "Draw";
        } else {
            return"Pending";
        }
    }

    // check rows
    private  boolean checkRows() {
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == (board[i][2]) && board[i][0] != 0) {
                if(board[i][0] == firstPlayer)
                   return true;
            }
        }
        return false;
    }

    // check columns
    private boolean checkColumns() {
        for(int i = 0; i < board.length; i++) {
            if(board[0][i] == (board[1][i]) && board[2][i] == (board[1][i]) && board[0][i] != 0) {
                if(board[0][i] == firstPlayer)
                   return true;
            }
        }
        return false;
    }

    // check diagonals
    private boolean checkDiagonals() {
        if(board[0][0] == (board[1][1]) && board[1][1] == (board[2][2]) && board[0][0] != 0
        || board[2][0] == (board[1][1]) && board[0][2] == (board[1][1]) && board[2][0] != 0)
        {
            if(board[0][0] == firstPlayer)
                return true;
        }
        return false;
    }

    // main
    public static void main(String[] args) {
        //You may modify the main to test examples
        TicTacToeWinner winner = new TicTacToeWinner();
        winner.printBoard();
        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(winner.ttcWinner(moves));

        /*
        -> Expected winner: "A"
        {{0,0},{2,0},{1,1},{2,1},{2,2}} 

        -> Expected winner: "B"
        {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}} 

        -> Expected result: "Draw"
        {{0,0},{1,1},{0,2},{0,1},{2,2},{1,2},{2,1},{2,0},{1,0}}

        -> Expected result: "Pending"
        {{1,0},{2,0},{0,1}}, {{1,1},{0,0}}, {{2,1},{0,1},{0,2}}, {{0,0},{0,1},{2,1}}
        */
    }
}
