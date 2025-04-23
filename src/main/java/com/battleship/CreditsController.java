package com.battleship;

import java.io.IOException;

import com.battleship.Models.GameManager;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

@SuppressWarnings("unused")
public class CreditsController {

    @FXML
    private RadioButton SeekWhite;
    @FXML
    private RadioButton SeekBlack;
    @FXML
    private RadioButton SeekRed;
    @FXML
    private RadioButton SeekOrange;
    @FXML
    private RadioButton SeekGreen;
    @FXML
    private RadioButton LockWhite;
    @FXML
    private RadioButton LockBlack;
    @FXML
    private RadioButton LockRed;
    @FXML
    private RadioButton LockOrange;
    @FXML
    private RadioButton LockGreen;
    @FXML
    private HBox SecretBox; 

    @FXML
    private void initialize() {
        switch (GameManager.SeekColor) {
            case "White" -> {
                SeekWhite.setSelected(true);
            }
            case "Black" -> {
                SeekBlack.setSelected(true);
            }
            case "Red" -> {
                SeekRed.setSelected(true);
            }
            case "Orange" -> {
                SeekOrange.setSelected(true);
            }
            case "Green" -> {
                SeekGreen.setSelected(true);
            }
            default -> {
            }
        }

        switch (GameManager.LockColor) {
            case "White" -> {
                LockWhite.setSelected(true);
            }
            case "Black" -> {
                LockBlack.setSelected(true);
            }
            case "Red" -> {
                LockRed.setSelected(true);
            }
            case "Orange" -> {
                LockOrange.setSelected(true);
            }
            case "Green" -> {
                LockGreen.setSelected(true);
            }
            default -> {
            }
        }
    }

    @FXML
    private void lock() {
        if (LockWhite.isSelected()) {
            GameManager.LockColor = "White";
        } else if (LockBlack.isSelected()) {
            GameManager.LockColor = "Black";

        } else if (LockRed.isSelected()) {
            GameManager.LockColor = "Red";

        } else if (LockGreen.isSelected()) {
            GameManager.LockColor = "Green";

        } else if (LockOrange.isSelected()) {
            GameManager.LockColor = "Orange";

        }
    }

    @FXML
    private void seek() {
        if (SeekWhite.isSelected()) {
            GameManager.SeekColor = "White";
        } else if (SeekBlack.isSelected()) {
            GameManager.SeekColor = "Black";

        } else if (SeekRed.isSelected()) {
            GameManager.SeekColor = "Red";

        } else if (SeekGreen.isSelected()) {
            GameManager.SeekColor = "Green";

        } else if (SeekOrange.isSelected()) {
            GameManager.SeekColor = "Orange";

        }
    }

    @FXML
    private void secret()
    {
        SecretBox.setVisible(!SecretBox.isVisible());
    }

    @FXML
    private void back() throws IOException {
        App.setRoot("MainMenu");
    }

}
