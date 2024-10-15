package iscteiul.ista.tictactoefx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TicTacToeFXController {
    
    @FXML
    private Label labelMessage;
    @FXML
    private GridPane tiles;

    @FXML
    protected void initialize() {
        tiles.setDisable(false); // make sure tiles are enabled as game can be restarted
        TicTacToeGame game = new TicTacToeGame();
        int width = game.getBoardWidth();
        TicTacToeTile[][] buttons = new TicTacToeTile[width][width];

        int box_number = 0;
        for (int i=0; i<width; i++) {
            for (int j=0; j<width; j++) {
                buttons[i][j] = new TicTacToeTile(box_number++);
                buttons[i][j].setPrefHeight(100);
                buttons[i][j].setPrefWidth(100);
                final int ii = i;
                final int jj = j;
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int box_number_selected = buttons[ii][jj].getBoxNumber();
                        game.placeMarker(box_number_selected);
                        buttons[ii][jj].setMarker(game.getCurrentPlayer().getMarker());
                        if (game.isGameOver()) {
                            // current player has just played so if there is a winner
                            // right now he should be the one
                            boolean winner = game.checkWinner(game.getCurrentPlayer());
                            String msg = "No winner. Game is a draw";
                            if (winner) {
                                msg = "Player " + game.getCurrentPlayer().getMarker() + " is the winner.";
                            }
                            labelMessage.setText(msg);
                            tiles.setDisable(true);
                        } else {
                            game.changeTurn();
                            String msg = "Player " + game.getCurrentPlayer().getMarker() + " turn";
                            labelMessage.setText(msg);
                        }

                    }
                });
                tiles.add(buttons[i][j], i, j);
            }
        }
    }

    @FXML
    protected void onStartButtonClick() {
        initialize();
        labelMessage.setText("First player with X");
    }

    @FXML
    protected void onQuitButtonClick() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitting Tic-Tac-Toe");
        alert.setContentText("Tic-Tac-Toe will terminate. Is that OK?");
        alert.showAndWait();
        if (alert.getResult().getText().equalsIgnoreCase("OK")) {
            System.exit(0);
        }
    }
}