module treen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.base;
    opens treen.battleship to javafx.fxml;
    exports treen.battleship;
}