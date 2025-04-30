// module declaration
module com.battleship {
    // dependencies
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // opens and exports
    opens com.battleship to javafx.fxml; // allows javafx to access com.battleship classes
    exports com.battleship; // makes all public classes in com.battleship available to other modules
}