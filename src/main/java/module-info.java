module treen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens treen.battleship to javafx.fxml;
    exports treen.battleship;
}