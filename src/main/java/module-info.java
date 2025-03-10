module com.battleship {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.battleship to javafx.fxml;
    exports com.battleship;
}
