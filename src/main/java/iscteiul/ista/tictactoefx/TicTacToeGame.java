package iscteiul.ista.tictactoefx;

public class TicTacToeGame {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToeGame() {
        board = new Board();
        player1 = new Player(Board.MARKER_1);
        player2 = new Player(Board.MARKER_2);
        currentPlayer = player1;
    }

    public void placeMarker(int position) {
        char marker = currentPlayer.getMarker();
        board.placeMarker(position, marker);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return board.isGameOver();
    }

    public boolean checkWinner(Player player) {
        char marker = player.getMarker();
        return board.checkWinner(marker);
    }

    public void changeTurn() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public int getBoardWidth() {
        return board.BOARD_WIDTH;
    }
}
