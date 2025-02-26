package com.battleship;

import com.battleship.Models.BoardLocation;
import com.battleship.Models.GameConstants;
import com.battleship.Models.GameState;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayerBoardController {
    @FXML
    private Rectangle A1;
    @FXML
    private Rectangle A2;
    @FXML
    private Rectangle A3;
    @FXML
    private Rectangle A4;
    @FXML
    private Rectangle A5;
    @FXML
    private Rectangle A6;
    @FXML
    private Rectangle A7;
    @FXML
    private Rectangle A8;
    @FXML
    private Rectangle A9;
    @FXML
    private Rectangle A10;
    @FXML
    private Rectangle B1;
    @FXML
    private Rectangle B2;
    @FXML
    private Rectangle B3;
    @FXML
    private Rectangle B4;
    @FXML
    private Rectangle B5;
    @FXML
    private Rectangle B6;
    @FXML
    private Rectangle B7;
    @FXML
    private Rectangle B8;
    @FXML
    private Rectangle B9;
    @FXML
    private Rectangle B10;
    @FXML
    private Rectangle C1;
    @FXML
    private Rectangle C2;
    @FXML
    private Rectangle C3;
    @FXML
    private Rectangle C4;
    @FXML
    private Rectangle C5;
    @FXML
    private Rectangle C6;
    @FXML
    private Rectangle C7;
    @FXML
    private Rectangle C8;
    @FXML
    private Rectangle C9;
    @FXML
    private Rectangle C10;
    @FXML
    private Rectangle D1;
    @FXML
    private Rectangle D2;
    @FXML
    private Rectangle D3;
    @FXML
    private Rectangle D4;
    @FXML
    private Rectangle D5;
    @FXML
    private Rectangle D6;
    @FXML
    private Rectangle D7;
    @FXML
    private Rectangle D8;
    @FXML
    private Rectangle D9;
    @FXML
    private Rectangle D10;
    @FXML
    private Rectangle E1;
    @FXML
    private Rectangle E2;
    @FXML
    private Rectangle E3;
    @FXML
    private Rectangle E4;
    @FXML
    private Rectangle E5;
    @FXML
    private Rectangle E6;
    @FXML
    private Rectangle E7;
    @FXML
    private Rectangle E8;
    @FXML
    private Rectangle E9;
    @FXML
    private Rectangle E10;
    @FXML
    private Rectangle F1;
    @FXML
    private Rectangle F2;
    @FXML
    private Rectangle F3;
    @FXML
    private Rectangle F4;
    @FXML
    private Rectangle F5;
    @FXML
    private Rectangle F6;
    @FXML
    private Rectangle F7;
    @FXML
    private Rectangle F8;
    @FXML
    private Rectangle F9;
    @FXML
    private Rectangle F10;
    @FXML
    private Rectangle G1;
    @FXML
    private Rectangle G2;
    @FXML
    private Rectangle G3;
    @FXML
    private Rectangle G4;
    @FXML
    private Rectangle G5;
    @FXML
    private Rectangle G6;
    @FXML
    private Rectangle G7;
    @FXML
    private Rectangle G8;
    @FXML
    private Rectangle G9;
    @FXML
    private Rectangle G10;
    @FXML
    private Rectangle H1;
    @FXML
    private Rectangle H2;
    @FXML
    private Rectangle H3;
    @FXML
    private Rectangle H4;
    @FXML
    private Rectangle H5;
    @FXML
    private Rectangle H6;
    @FXML
    private Rectangle H7;
    @FXML
    private Rectangle H8;
    @FXML
    private Rectangle H9;
    @FXML
    private Rectangle H10;
    @FXML
    private Rectangle I1;
    @FXML
    private Rectangle I2;
    @FXML
    private Rectangle I3;
    @FXML
    private Rectangle I4;
    @FXML
    private Rectangle I5;
    @FXML
    private Rectangle I6;
    @FXML
    private Rectangle I7;
    @FXML
    private Rectangle I8;
    @FXML
    private Rectangle I9;
    @FXML
    private Rectangle I10;
    @FXML
    private Rectangle J1;
    @FXML
    private Rectangle J2;
    @FXML
    private Rectangle J3;
    @FXML
    private Rectangle J4;
    @FXML
    private Rectangle J5;
    @FXML
    private Rectangle J6;
    @FXML
    private Rectangle J7;
    @FXML
    private Rectangle J8;
    @FXML
    private Rectangle J9;
    @FXML
    private Rectangle J10;
    @FXML
    private RadioButton horizontalShipRadio;
    @FXML
    private RadioButton verticalShipRadio;
    @FXML 
    private RadioButton carrierRadio;
    @FXML
    private RadioButton battleshipRadio;
    @FXML
    private RadioButton destroyerRadio;
    @FXML
    private RadioButton submarineRadio;
    @FXML
    private RadioButton patrolRadio;

    private Rectangle[] _board;
    private int _selectedShip = 0;

    @FXML
    public void initialize() {
        _board = new Rectangle[] {
                A1, A2, A3, A4, A5, A6, A7, A8, A9, A10,
                B1, B2, B3, B4, B5, B6, B7, B8, B9, B10,
                C1, C2, C3, C4, C5, C6, C7, C8, C9, C10,
                D1, D2, D3, D4, D5, D6, D7, D8, D9, D10,
                E1, E2, E3, E4, E5, E6, E7, E8, E9, E10,
                F1, F2, F3, F4, F5, F6, F7, F8, F9, F10,
                G1, G2, G3, G4, G5, G6, G7, G8, G9, G10,
                H1, H2, H3, H4, H5, H6, H7, H8, H9, H10,
                I1, I2, I3, I4, I5, I6, I7, I8, I9, I10,
                J1, J2, J3, J4, J5, J6, J7, J8, J9, J10
        };
        carrierRadio.setTextFill(Color.RED);
        battleshipRadio.setTextFill(Color.RED);
        destroyerRadio.setTextFill(Color.RED);
        submarineRadio.setTextFill(Color.RED);
        patrolRadio.setTextFill(Color.RED);
    }

    @FXML
    void squareClicked() {
        BoardLocation selectedLocation = null;
        for (var i = 0; i < _board.length; i++) {
            if (_board[i].isHover()) {
                selectedLocation = BoardLocation.parseInt(i);
                break;
            }
        }

        if (selectedLocation == null)
            return;

        switch (GameConstants.gameState) {
            case PlaceShips -> {
                if (_selectedShip == -1) return;

                var isHorizontal = horizontalShipRadio.isSelected();
                var didSet = GameConstants.player.boats[_selectedShip].SetLocation(selectedLocation, isHorizontal, GameConstants.player);
                if (didSet) {
                    GameConstants.player.boats[_selectedShip].isPlaced = true;

                    carrierRadio.setTextFill(GameConstants.player.boats[0].isPlaced ? Color.BLACK : Color.RED);
                    battleshipRadio.setTextFill(GameConstants.player.boats[1].isPlaced ? Color.BLACK : Color.RED);
                    destroyerRadio.setTextFill(GameConstants.player.boats[2].isPlaced ? Color.BLACK : Color.RED);
                    submarineRadio.setTextFill(GameConstants.player.boats[3].isPlaced ? Color.BLACK : Color.RED);
                    patrolRadio.setTextFill(GameConstants.player.boats[4].isPlaced ? Color.BLACK : Color.RED);

                    for (var square : _board) {
                        square.setFill(Color.CORNFLOWERBLUE); // Set all squares to blue initially
                    }
                    for (var boat : GameConstants.player.boats) {
                        for (var loc : boat.location) {
                            if (loc != null) {
                                _board[loc.getValue()].setFill(Color.BURLYWOOD); // Set boat locations to another color
                            }
                        }
                    }
                }
            }
            case PlayerTurn -> {
            }
            case OpponentTurn -> {
            }
            case GameOver -> {
            }
        }
    }

    @FXML
    void selectShip() {
        if (carrierRadio.isSelected()) {
            _selectedShip = 0;
        } else if (battleshipRadio.isSelected()) {
            _selectedShip = 1;
        } else if (destroyerRadio.isSelected()) {
            _selectedShip = 2;
        } else if (submarineRadio.isSelected()) {
            _selectedShip = 3;
        } else if (patrolRadio.isSelected()) {
            _selectedShip = 4;
        }
    }

    @FXML
    private void randomizeShips() {
        for (var boat : GameConstants.player.boats) {
            var isHorizontal = Math.random() < 0.5;
            var loc = BoardLocation.randomLocation();
            while (!boat.SetLocation(loc, isHorizontal, GameConstants.player)) {
                loc = BoardLocation.randomLocation();
            }
            boat.isPlaced = true;
        }

        carrierRadio.setTextFill(GameConstants.player.boats[0].isPlaced ? Color.BLACK : Color.RED);
        battleshipRadio.setTextFill(GameConstants.player.boats[1].isPlaced ? Color.BLACK : Color.RED);
        destroyerRadio.setTextFill(GameConstants.player.boats[2].isPlaced ? Color.BLACK : Color.RED);
        submarineRadio.setTextFill(GameConstants.player.boats[3].isPlaced ? Color.BLACK : Color.RED);
        patrolRadio.setTextFill(GameConstants.player.boats[4].isPlaced ? Color.BLACK : Color.RED);

        for (var square : _board) {
            square.setFill(Color.CORNFLOWERBLUE); // Set all squares to blue initially
        }
        for (var boat : GameConstants.player.boats) {
            for (var loc : boat.location) {
                if (loc != null) {
                    _board[loc.getValue()].setFill(Color.BURLYWOOD); // Set boat locations to another color
                }
            }
        }
    }

    @FXML
    private void confirmShips() {
        if (GameConstants.player.allBoatsPlaced()) {
            GameConstants.gameState = GameState.PlayerTurn; 
        }
        
        for (var boat : GameConstants.opponent.boats) {
            var isHorizontal = Math.random() < 0.5;
            var loc = BoardLocation.randomLocation();
            while (!boat.SetLocation(loc, isHorizontal, GameConstants.opponent)) {
                loc = BoardLocation.randomLocation();
            }
            boat.isPlaced = true;
        }

        for (var square : _board) {
            square.setFill(Color.CORNFLOWERBLUE); // Set all squares to blue initially
        }
        for (var boat : GameConstants.opponent.boats) {
            for (var loc : boat.location) {
                if (loc != null) {
                    _board[loc.getValue()].setFill(Color.GREEN); // Set boat locations to another color
                }
            }
        }
    }
}
