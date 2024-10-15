package iscteiul.ista.tictactoefx;

public class Board {

    public static final int BOARD_WIDTH = 3;
    public static final char MARKER_1 = 'X';
    public static final char MARKER_2 = 'O';

    private char board[][];

    public Board() {
        board = new char[BOARD_WIDTH][BOARD_WIDTH];
    }

    public boolean isGameOver() {
        return checkWinner(MARKER_1) || checkWinner(MARKER_2) || isBoardFull();
    }

    public boolean isBoardFull() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (board[i][j] != MARKER_1 && board[i][j] != MARKER_2) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinner(char marker) {
        // check for horizontals
        for (int i = 0; i < BOARD_WIDTH; i++) {
            if (board[i][0] == marker && board[i][1] == marker && board[i][2] == marker) {
                return true;
            }
        }
        // check for verticals
        for (int j = 0; j < BOARD_WIDTH; j++) {
            if (board[0][j] == marker && board[1][j] == marker && board[2][j] == marker) {
                return true;
            }
        }
        // check for diagonals
        if (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) {
            return true;
        }
        if (board[2][0] == marker && board[1][1] == marker && board[0][2] == marker) {
            return true;
        }
        return false;
    }

    // TODO: validate position
    public void placeMarker(int position, char marker) {
        int i = position / BOARD_WIDTH;
        int j = position % BOARD_WIDTH;
        board[i][j] = marker;
    }
}
