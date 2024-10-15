package iscteiul.ista.tictactoefx;

import javafx.scene.control.Button;

public class TicTacToeTile extends Button {

    private int boxNumber;

    public TicTacToeTile(int box_number) {
        this.boxNumber = box_number;
    }

    public void setMarker(char marker) {
        setText(String.valueOf(marker));
        setDisable(true);
    }

    public int getBoxNumber() {
        return this.boxNumber;
    }
}
