package com.battleship;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainMenuController {

    @FXML
    private void play() throws IOException {
        App.setRoot("GameProperties");
    }

    @FXML
    private void exit() {
        System.exit(0);
    }
}
