package com.battleship;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

@SuppressWarnings("unused")
public class GamePropertiesController {

    @FXML
    private Label gameDescription;
    @FXML
    private RadioButton mode0;
    @FXML
    private RadioButton mode1;
    @FXML
    private RadioButton mode2;

    private final String[] gameDescriptions = new String[] {
            "The classic game of Battleship", // classic, mode 0
            "A strategic twist on the classic game: each ship can fire once per turn", // salvo, mode 1
            "Battleship, but with added abilities to enhance gameplay" // advanced, mode 2
    };

    @FXML
    private void startGame() throws IOException {
        App.setRoot("PlayerBoard");
    }

    @FXML
    private void changeDescription() {
        if (mode0.isSelected()) {
            gameDescription.setText(gameDescriptions[0]);
        } else if (mode1.isSelected()) {
            gameDescription.setText(gameDescriptions[1]);
        } else if (mode2.isSelected()) {
            gameDescription.setText(gameDescriptions[2]);
        }
    }

    @FXML
    private void cancel() throws IOException {
        App.setRoot("MainMenu");
    }
}
