package iscteiul.ista.tictactoefx;

public class Player {

    private char marker;

    public Player(char marker) {
        this.marker = marker;
    }

    public void setMarker(char marker) {
        this.marker = marker;
    }

    public char getMarker() {
        return this.marker;
    }
}
