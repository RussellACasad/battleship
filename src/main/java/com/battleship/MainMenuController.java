package com.battleship;

import java.io.IOException;

import com.battleship.Models.GameManager;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

@SuppressWarnings("unused")
public class MainMenuController {
    @FXML 
    private Text versionText; 

    @FXML
    private void initialize()
    {
        versionText.setText("Version " + GameManager.VERSION); // shows the current version on the main menu
    }

    @FXML
    private void play() throws IOException {
        App.setRoot("PlayerBoard");
    }

    @FXML
    private void multiplayer() throws IOException {
        App.setRoot("Multiplayer");
    }

    @FXML
    private void exit() {
        System.exit(0);
    }
}
