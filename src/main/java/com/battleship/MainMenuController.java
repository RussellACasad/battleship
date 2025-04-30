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
        App.setRoot("PlayerBoard"); // to playerboard
    }

    @FXML
    private void multiplayer() throws IOException {
        App.setRoot("Multiplayer"); // to multiplayer settings
    }

    @FXML
    private void credits() throws IOException {
        App.setRoot("Credits"); // to credits
    }

    @FXML
    private void exit() {
        System.exit(0);
    }
}