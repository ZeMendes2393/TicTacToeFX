module iscteiul.ista.tictactoefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens iscteiul.ista.tictactoefx to javafx.fxml;
    exports iscteiul.ista.tictactoefx;
}