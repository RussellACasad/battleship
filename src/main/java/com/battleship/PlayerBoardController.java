package com.battleship;

import java.io.IOException;

import com.battleship.Models.BoardLocation;
import com.battleship.Models.Boat;
import com.battleship.Models.GameManager;
import com.battleship.Models.GameState;
import com.battleship.Models.GridType;
import com.battleship.Models.OpponentAttack;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

@SuppressWarnings("unused")
public class PlayerBoardController {
    @FXML
    private ImageView A1;
    @FXML
    private ImageView A2;
    @FXML
    private ImageView A3;
    @FXML
    private ImageView A4;
    @FXML
    private ImageView A5;
    @FXML
    private ImageView A6;
    @FXML
    private ImageView A7;
    @FXML
    private ImageView A8;
    @FXML
    private ImageView A9;
    @FXML
    private ImageView A10;
    @FXML
    private ImageView B1;
    @FXML
    private ImageView B2;
    @FXML
    private ImageView B3;
    @FXML
    private ImageView B4;
    @FXML
    private ImageView B5;
    @FXML
    private ImageView B6;
    @FXML
    private ImageView B7;
    @FXML
    private ImageView B8;
    @FXML
    private ImageView B9;
    @FXML
    private ImageView B10;
    @FXML
    private ImageView C1;
    @FXML
    private ImageView C2;
    @FXML
    private ImageView C3;
    @FXML
    private ImageView C4;
    @FXML
    private ImageView C5;
    @FXML
    private ImageView C6;
    @FXML
    private ImageView C7;
    @FXML
    private ImageView C8;
    @FXML
    private ImageView C9;
    @FXML
    private ImageView C10;
    @FXML
    private ImageView D1;
    @FXML
    private ImageView D2;
    @FXML
    private ImageView D3;
    @FXML
    private ImageView D4;
    @FXML
    private ImageView D5;
    @FXML
    private ImageView D6;
    @FXML
    private ImageView D7;
    @FXML
    private ImageView D8;
    @FXML
    private ImageView D9;
    @FXML
    private ImageView D10;
    @FXML
    private ImageView E1;
    @FXML
    private ImageView E2;
    @FXML
    private ImageView E3;
    @FXML
    private ImageView E4;
    @FXML
    private ImageView E5;
    @FXML
    private ImageView E6;
    @FXML
    private ImageView E7;
    @FXML
    private ImageView E8;
    @FXML
    private ImageView E9;
    @FXML
    private ImageView E10;
    @FXML
    private ImageView F1;
    @FXML
    private ImageView F2;
    @FXML
    private ImageView F3;
    @FXML
    private ImageView F4;
    @FXML
    private ImageView F5;
    @FXML
    private ImageView F6;
    @FXML
    private ImageView F7;
    @FXML
    private ImageView F8;
    @FXML
    private ImageView F9;
    @FXML
    private ImageView F10;
    @FXML
    private ImageView G1;
    @FXML
    private ImageView G2;
    @FXML
    private ImageView G3;
    @FXML
    private ImageView G4;
    @FXML
    private ImageView G5;
    @FXML
    private ImageView G6;
    @FXML
    private ImageView G7;
    @FXML
    private ImageView G8;
    @FXML
    private ImageView G9;
    @FXML
    private ImageView G10;
    @FXML
    private ImageView H1;
    @FXML
    private ImageView H2;
    @FXML
    private ImageView H3;
    @FXML
    private ImageView H4;
    @FXML
    private ImageView H5;
    @FXML
    private ImageView H6;
    @FXML
    private ImageView H7;
    @FXML
    private ImageView H8;
    @FXML
    private ImageView H9;
    @FXML
    private ImageView H10;
    @FXML
    private ImageView I1;
    @FXML
    private ImageView I2;
    @FXML
    private ImageView I3;
    @FXML
    private ImageView I4;
    @FXML
    private ImageView I5;
    @FXML
    private ImageView I6;
    @FXML
    private ImageView I7;
    @FXML
    private ImageView I8;
    @FXML
    private ImageView I9;
    @FXML
    private ImageView I10;
    @FXML
    private ImageView J1;
    @FXML
    private ImageView J2;
    @FXML
    private ImageView J3;
    @FXML
    private ImageView J4;
    @FXML
    private ImageView J5;
    @FXML
    private ImageView J6;
    @FXML
    private ImageView J7;
    @FXML
    private ImageView J8;
    @FXML
    private ImageView J9;
    @FXML
    private ImageView J10;
    @FXML
    private ImageView A1O;
    @FXML
    private ImageView A2O;
    @FXML
    private ImageView A3O;
    @FXML
    private ImageView A4O;
    @FXML
    private ImageView A5O;
    @FXML
    private ImageView A6O;
    @FXML
    private ImageView A7O;
    @FXML
    private ImageView A8O;
    @FXML
    private ImageView A9O;
    @FXML
    private ImageView A10O;
    @FXML
    private ImageView B1O;
    @FXML
    private ImageView B2O;
    @FXML
    private ImageView B3O;
    @FXML
    private ImageView B4O;
    @FXML
    private ImageView B5O;
    @FXML
    private ImageView B6O;
    @FXML
    private ImageView B7O;
    @FXML
    private ImageView B8O;
    @FXML
    private ImageView B9O;
    @FXML
    private ImageView B10O;
    @FXML
    private ImageView C1O;
    @FXML
    private ImageView C2O;
    @FXML
    private ImageView C3O;
    @FXML
    private ImageView C4O;
    @FXML
    private ImageView C5O;
    @FXML
    private ImageView C6O;
    @FXML
    private ImageView C7O;
    @FXML
    private ImageView C8O;
    @FXML
    private ImageView C9O;
    @FXML
    private ImageView C10O;
    @FXML
    private ImageView D1O;
    @FXML
    private ImageView D2O;
    @FXML
    private ImageView D3O;
    @FXML
    private ImageView D4O;
    @FXML
    private ImageView D5O;
    @FXML
    private ImageView D6O;
    @FXML
    private ImageView D7O;
    @FXML
    private ImageView D8O;
    @FXML
    private ImageView D9O;
    @FXML
    private ImageView D10O;
    @FXML
    private ImageView E1O;
    @FXML
    private ImageView E2O;
    @FXML
    private ImageView E3O;
    @FXML
    private ImageView E4O;
    @FXML
    private ImageView E5O;
    @FXML
    private ImageView E6O;
    @FXML
    private ImageView E7O;
    @FXML
    private ImageView E8O;
    @FXML
    private ImageView E9O;
    @FXML
    private ImageView E10O;
    @FXML
    private ImageView F1O;
    @FXML
    private ImageView F2O;
    @FXML
    private ImageView F3O;
    @FXML
    private ImageView F4O;
    @FXML
    private ImageView F5O;
    @FXML
    private ImageView F6O;
    @FXML
    private ImageView F7O;
    @FXML
    private ImageView F8O;
    @FXML
    private ImageView F9O;
    @FXML
    private ImageView F10O;
    @FXML
    private ImageView G1O;
    @FXML
    private ImageView G2O;
    @FXML
    private ImageView G3O;
    @FXML
    private ImageView G4O;
    @FXML
    private ImageView G5O;
    @FXML
    private ImageView G6O;
    @FXML
    private ImageView G7O;
    @FXML
    private ImageView G8O;
    @FXML
    private ImageView G9O;
    @FXML
    private ImageView G10O;
    @FXML
    private ImageView H1O;
    @FXML
    private ImageView H2O;
    @FXML
    private ImageView H3O;
    @FXML
    private ImageView H4O;
    @FXML
    private ImageView H5O;
    @FXML
    private ImageView H6O;
    @FXML
    private ImageView H7O;
    @FXML
    private ImageView H8O;
    @FXML
    private ImageView H9O;
    @FXML
    private ImageView H10O;
    @FXML
    private ImageView I1O;
    @FXML
    private ImageView I2O;
    @FXML
    private ImageView I3O;
    @FXML
    private ImageView I4O;
    @FXML
    private ImageView I5O;
    @FXML
    private ImageView I6O;
    @FXML
    private ImageView I7O;
    @FXML
    private ImageView I8O;
    @FXML
    private ImageView I9O;
    @FXML
    private ImageView I10O;
    @FXML
    private ImageView J1O;
    @FXML
    private ImageView J2O;
    @FXML
    private ImageView J3O;
    @FXML
    private ImageView J4O;
    @FXML
    private ImageView J5O;
    @FXML
    private ImageView J6O;
    @FXML
    private ImageView J7O;
    @FXML
    private ImageView J8O;
    @FXML
    private ImageView J9O;
    @FXML
    private ImageView J10O;
    @FXML
    private StackPane A1G;
    @FXML
    private StackPane A2G;
    @FXML
    private StackPane A3G;
    @FXML
    private StackPane A4G;
    @FXML
    private StackPane A5G;
    @FXML
    private StackPane A6G;
    @FXML
    private StackPane A7G;
    @FXML
    private StackPane A8G;
    @FXML
    private StackPane A9G;
    @FXML
    private StackPane A10G;
    @FXML
    private StackPane B1G;
    @FXML
    private StackPane B2G;
    @FXML
    private StackPane B3G;
    @FXML
    private StackPane B4G;
    @FXML
    private StackPane B5G;
    @FXML
    private StackPane B6G;
    @FXML
    private StackPane B7G;
    @FXML
    private StackPane B8G;
    @FXML
    private StackPane B9G;
    @FXML
    private StackPane B10G;
    @FXML
    private StackPane C1G;
    @FXML
    private StackPane C2G;
    @FXML
    private StackPane C3G;
    @FXML
    private StackPane C4G;
    @FXML
    private StackPane C5G;
    @FXML
    private StackPane C6G;
    @FXML
    private StackPane C7G;
    @FXML
    private StackPane C8G;
    @FXML
    private StackPane C9G;
    @FXML
    private StackPane C10G;
    @FXML
    private StackPane D1G;
    @FXML
    private StackPane D2G;
    @FXML
    private StackPane D3G;
    @FXML
    private StackPane D4G;
    @FXML
    private StackPane D5G;
    @FXML
    private StackPane D6G;
    @FXML
    private StackPane D7G;
    @FXML
    private StackPane D8G;
    @FXML
    private StackPane D9G;
    @FXML
    private StackPane D10G;
    @FXML
    private StackPane E1G;
    @FXML
    private StackPane E2G;
    @FXML
    private StackPane E3G;
    @FXML
    private StackPane E4G;
    @FXML
    private StackPane E5G;
    @FXML
    private StackPane E6G;
    @FXML
    private StackPane E7G;
    @FXML
    private StackPane E8G;
    @FXML
    private StackPane E9G;
    @FXML
    private StackPane E10G;
    @FXML
    private StackPane F1G;
    @FXML
    private StackPane F2G;
    @FXML
    private StackPane F3G;
    @FXML
    private StackPane F4G;
    @FXML
    private StackPane F5G;
    @FXML
    private StackPane F6G;
    @FXML
    private StackPane F7G;
    @FXML
    private StackPane F8G;
    @FXML
    private StackPane F9G;
    @FXML
    private StackPane F10G;
    @FXML
    private StackPane G1G;
    @FXML
    private StackPane G2G;
    @FXML
    private StackPane G3G;
    @FXML
    private StackPane G4G;
    @FXML
    private StackPane G5G;
    @FXML
    private StackPane G6G;
    @FXML
    private StackPane G7G;
    @FXML
    private StackPane G8G;
    @FXML
    private StackPane G9G;
    @FXML
    private StackPane G10G;
    @FXML
    private StackPane H1G;
    @FXML
    private StackPane H2G;
    @FXML
    private StackPane H3G;
    @FXML
    private StackPane H4G;
    @FXML
    private StackPane H5G;
    @FXML
    private StackPane H6G;
    @FXML
    private StackPane H7G;
    @FXML
    private StackPane H8G;
    @FXML
    private StackPane H9G;
    @FXML
    private StackPane H10G;
    @FXML
    private StackPane I1G;
    @FXML
    private StackPane I2G;
    @FXML
    private StackPane I3G;
    @FXML
    private StackPane I4G;
    @FXML
    private StackPane I5G;
    @FXML
    private StackPane I6G;
    @FXML
    private StackPane I7G;
    @FXML
    private StackPane I8G;
    @FXML
    private StackPane I9G;
    @FXML
    private StackPane I10G;
    @FXML
    private StackPane J1G;
    @FXML
    private StackPane J2G;
    @FXML
    private StackPane J3G;
    @FXML
    private StackPane J4G;
    @FXML
    private StackPane J5G;
    @FXML
    private StackPane J6G;
    @FXML
    private StackPane J7G;
    @FXML
    private StackPane J8G;
    @FXML
    private StackPane J9G;
    @FXML
    private StackPane J10G;
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
    @FXML
    private RadioButton oceanGridRadio;
    @FXML
    private RadioButton targetGridRadio;
    @FXML
    private HBox SelectBox;
    @FXML
    private HBox PlayBox;
    @FXML
    private Text TitleText;
    @FXML
    private Text MessageText;
    @FXML
    private Button fireButton;

    private ImageView[] _overlayBoard;
    private ImageView[] _oceanBoard;
    private StackPane[] _gridBoard;
    private int _selectedShip = 0;
    private transient BoardLocation _toHit = null;
    private final Alert alert = new Alert(AlertType.INFORMATION);

    private final Thread FeedManager = new Thread(() -> {
        String input;
        while (true) {
            if (GameManager.multiplayerFeed.isEmpty()) {
                GameManager.out.println("ping");
                try {
                    input = GameManager.in.readLine();
                    if (input == null) {
                        Platform.runLater(() -> closeGame(true));
                        break;
                    }
                    if (!input.equals("ping")) {
                        GameManager.multiplayerInput = input;
                    }
                    if (input.equals("win")) {
                        Platform.runLater(() -> endMessage(true));
                        break;
                    }
                } catch (IOException ex) {
                    Platform.runLater(() -> closeGame(true));
                    break;
                }
            } else {
                var x = GameManager.multiplayerFeed.removeFirst();
                GameManager.out.println(x);

                if (x.equals("win")) {
                    endMessage(false);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {

                System.out.println("Error in FeedManager Wait");
            }
        }
    });

    @FXML
    public void initialize() {
        GameManager.LoadSprites();
        _oceanBoard = new ImageView[] { // Creates the grid for the Ocean
                A1O, A2O, A3O, A4O, A5O, A6O, A7O, A8O, A9O, A10O,
                B1O, B2O, B3O, B4O, B5O, B6O, B7O, B8O, B9O, B10O,
                C1O, C2O, C3O, C4O, C5O, C6O, C7O, C8O, C9O, C10O,
                D1O, D2O, D3O, D4O, D5O, D6O, D7O, D8O, D9O, D10O,
                E1O, E2O, E3O, E4O, E5O, E6O, E7O, E8O, E9O, E10O,
                F1O, F2O, F3O, F4O, F5O, F6O, F7O, F8O, F9O, F10O,
                G1O, G2O, G3O, G4O, G5O, G6O, G7O, G8O, G9O, G10O,
                H1O, H2O, H3O, H4O, H5O, H6O, H7O, H8O, H9O, H10O,
                I1O, I2O, I3O, I4O, I5O, I6O, I7O, I8O, I9O, I10O,
                J1O, J2O, J3O, J4O, J5O, J6O, J7O, J8O, J9O, J10O
        };
        _overlayBoard = new ImageView[] { // Creates the grid for the Overlay
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
        _gridBoard = new StackPane[] { // Creates the grid of StackPanes
                A1G, A2G, A3G, A4G, A5G, A6G, A7G, A8G, A9G, A10G,
                B1G, B2G, B3G, B4G, B5G, B6G, B7G, B8G, B9G, B10G,
                C1G, C2G, C3G, C4G, C5G, C6G, C7G, C8G, C9G, C10G,
                D1G, D2G, D3G, D4G, D5G, D6G, D7G, D8G, D9G, D10G,
                E1G, E2G, E3G, E4G, E5G, E6G, E7G, E8G, E9G, E10G,
                F1G, F2G, F3G, F4G, F5G, F6G, F7G, F8G, F9G, F10G,
                G1G, G2G, G3G, G4G, G5G, G6G, G7G, G8G, G9G, G10G,
                H1G, H2G, H3G, H4G, H5G, H6G, H7G, H8G, H9G, H10G,
                I1G, I2G, I3G, I4G, I5G, I6G, I7G, I8G, I9G, I10G,
                J1G, J2G, J3G, J4G, J5G, J6G, J7G, J8G, J9G, J10G
        };
        carrierRadio.setTextFill(Color.RED); // sets the radio colors to red
        battleshipRadio.setTextFill(Color.RED);
        destroyerRadio.setTextFill(Color.RED);
        submarineRadio.setTextFill(Color.RED);
        patrolRadio.setTextFill(Color.RED);
        Draw(GridType.Ocean);
        SetUI();

        if (!GameManager.isSinglePlayer) { // If multiplayer, listens for when the opponent peer has placed their ships
            new Thread(() -> {
                var areShipsSet = "";
                try {
                    areShipsSet = GameManager.in.readLine();
                } catch (IOException ex) {
                    ex.getStackTrace();
                }
                if (areShipsSet.equals("t")) {
                    GameManager.opponent.shipsSet = true;
                }
            }).start();
        }
    }

    @FXML
    void squareClicked() { // when a square is clicked
        BoardLocation selectedLocation = null;
        for (var i = 0; i < _gridBoard.length; i++) { // scans through the board
            if (_gridBoard[i].isHover()) { // returns the square the user is hovering over
                selectedLocation = BoardLocation.parseInt(i);
                break;
            }
        }

        if (selectedLocation == null) // handles null exceptions
            return;

        for (var att : GameManager.player.hitAttempts) { // stops the player from selecting a spot they hit already
            if (att.location == selectedLocation) {
                return;
            }
        }

        switch (GameManager.gameState) { // manages the 2 states of when the player can select -- selecting hits and
                                         // ships
            case PlaceShips -> {

                var isHorizontal = horizontalShipRadio.isSelected(); // checks if the player wants to place a ship
                                                                     // horizontally
                var didSet = GameManager.player.boats[_selectedShip].SetLocation(selectedLocation, isHorizontal,
                        GameManager.player); // attempts to set the boat
                if (didSet) { // if the boat is set, upsates the UI and marks the boat as placed
                    GameManager.player.boats[_selectedShip].isPlaced = true;

                    carrierRadio.setTextFill(GameManager.player.boats[0].isPlaced ? Color.BLACK : Color.RED);
                    battleshipRadio.setTextFill(GameManager.player.boats[1].isPlaced ? Color.BLACK : Color.RED);
                    destroyerRadio.setTextFill(GameManager.player.boats[2].isPlaced ? Color.BLACK : Color.RED);
                    submarineRadio.setTextFill(GameManager.player.boats[3].isPlaced ? Color.BLACK : Color.RED);
                    patrolRadio.setTextFill(GameManager.player.boats[4].isPlaced ? Color.BLACK : Color.RED);

                    setGrid(GridType.Ocean); // redraws the ocean to show the new boat
                }
            }
            case PlayerTurn -> { // if the player turn
                _toHit = selectedLocation; // sets the local variable
                setGrid(GridType.Target); // redraws the grid
            }
            default -> { // does nothing normally
            }
        }
    }

    @FXML
    void selectShip() { // selects the new ship during ship selection
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
    private void randomizeShips() {// when the random button is pressed
        for (var boat : GameManager.player.boats) { // for each boat
            var isHorizontal = Math.random() < 0.5; // 50% chance of being horizontal
            var loc = BoardLocation.randomLocation(); // picks a random location
            while (!boat.SetLocation(loc, isHorizontal, GameManager.player)) { // reassigns the location until the boat
                                                                               // sets
                loc = BoardLocation.randomLocation();
            }
            boat.isPlaced = true;
        }

        carrierRadio.setTextFill(GameManager.player.boats[0].isPlaced ? Color.BLACK : Color.RED); // sets the color of
                                                                                                  // the radios
        battleshipRadio.setTextFill(GameManager.player.boats[1].isPlaced ? Color.BLACK : Color.RED);
        destroyerRadio.setTextFill(GameManager.player.boats[2].isPlaced ? Color.BLACK : Color.RED);
        submarineRadio.setTextFill(GameManager.player.boats[3].isPlaced ? Color.BLACK : Color.RED);
        patrolRadio.setTextFill(GameManager.player.boats[4].isPlaced ? Color.BLACK : Color.RED);

        setGrid(GridType.Ocean); // redraws the grid to show boats
    }

    @FXML
    private void confirmShips() {
        if (GameManager.player.allBoatsPlaced()) { // checks if all the boats are placed
            if (GameManager.isSinglePlayer) // places the opponent boats if singleplayer
            {
                alert.initOwner(A1.getScene().getWindow());
                for (var boat : GameManager.opponent.boats) {
                    var isHorizontal = Math.random() < 0.5;
                    var loc = BoardLocation.randomLocation();
                    while (!boat.SetLocation(loc, isHorizontal, GameManager.opponent)) {
                        loc = BoardLocation.randomLocation();
                    }
                    boat.isPlaced = true;
                }
                GameManager.opponent.shipsSet = true;
            } else { // if multiplayer, announces all the boats are placed
                GameManager.out.println("t");
            }
            GameManager.gameState = GameState.Wait; // waits for the opponents to place their boats
            SetUI();
            new Thread(() -> { // waits for all the opponent boats to be placed, if 2nd to place all or in
                               // singleplayer, will not wait
                while (!GameManager.opponent.shipsSet) {
                    TitleText.setText("Waiting for opponent to set their ships...");
                }
                Platform.runLater(() -> { // assigns the roles to the players according to their status as host or
                                          // singleplayer, and starts the actual game
                    if (!GameManager.isSinglePlayer && !GameManager.isHost) {
                        GameManager.gameState = GameState.OpponentTurn;
                        setGrid(GridType.Ocean);
                    } else {
                        GameManager.gameState = GameState.PlayerTurn;
                        setGrid(GridType.Target);
                    }
                    SetUI(); // sets the UI for gamestate palyer/opponent turn
                    if (GameManager.gameState == GameState.OpponentTurn) {
                        TitleText.setText("Opponent's Turn...");
                        OpponentTurn();
                    } else {
                        MessageText.setText("Select a spot to attack.");
                        TitleText.setText("Your Turn...");
                    }
                    FeedManager.start();

                });
            }).start();
        }
    }

    @FXML
    private void fire() throws InterruptedException {
        if (_toHit == null)
            return;
        MessageText.setText("Firing...");
        // when fire is hit (player's turn)
        PlayerTurn(); // send the player's turn to the oppoent
        PauseTransition opponentTurnPause = new PauseTransition(Duration.seconds(GameManager.FIREPAUSE)); // wait
        opponentTurnPause.setOnFinished(x -> OpponentTurn()); // when wait done, wait for opponent to fire back
        opponentTurnPause.play();
    }

    private void checkWin() {
        // Check all boats to see if sunk
        if (GameManager.isSinglePlayer) { // Singleplayer
            var allPlayerBoatsSunk = true;
            for (Boat boat : GameManager.player.boats) {
                if (!boat.isSunk()) {
                    allPlayerBoatsSunk = false;
                    break;
                }
            }
            if (allPlayerBoatsSunk) {
                endMessage(false);
            }

            var allOpponentBoatsSunk = true;
            for (Boat boat : GameManager.player.boats) {
                if (!boat.isSunk()) {
                    allOpponentBoatsSunk = false;
                    break;
                }
            }
            if (allOpponentBoatsSunk) {
                endMessage(true);
            }

        } else { // Multiplayer
            var allBoatsSunk = true;
            for (Boat boat : GameManager.player.boats) {
                if (!boat.isSunk()) {
                    allBoatsSunk = false;
                    break;
                }
            }
            if (allBoatsSunk) {
                GameManager.multiplayerFeed.add("win");
            }
        }
    }

    /**
     * The player's turn bundle, handles attacking and switching the gamestate
     */
    private void PlayerTurn() {
        Thread playerTurnThread = new Thread(() -> {
            var playerAttack = GameManager.player.attack(_toHit);
            Platform.runLater(() -> {
                setGrid(GridType.Target);
                TitleText.setText(GetMessage(playerAttack, true));
                TitleText.getScene().getWindow().getScene().getRoot().requestLayout(); // Force layout update
                checkWin();
                _toHit = null;
            });
        });
        playerTurnThread.start();
    }

    /**
     * The opponent's turn, handles recieving attacks on multiplayer, or generating
     * attacks with singleplayer.
     */
    private void OpponentTurn() {
        var opponentAttack = new OpponentAttack(_toHit);
        new Thread(() -> {
            opponentAttack.start(); // starts the opponent turn wait, waits for the oppoent to send their attack
            while (opponentAttack.isAlive()) // waits fot the opponent to send their turn
            {
                MessageText.setText("Awaiting opponent's turn...");
                fireButton.setDisable(true);
            }
            javafx.application.Platform.runLater(() -> { // when opponent attacks...
                setGrid(GridType.Ocean); // set grid to show where opponent attacked
                GameManager.gameState = GameState.PlayerTurn; // sets the state back to the player turn
                TitleText.setText(GetMessage(opponentAttack.out, false)); // sets the message text for the attack
                MessageText.setText(opponentAttack.out.length() > 3 ? "Hit!" : "Miss!");
                TitleText.getScene().getWindow().getScene().getRoot().requestLayout(); // Force layout update
                PauseTransition attackPause = new PauseTransition(Duration.seconds(GameManager.FIREPAUSE));
                attackPause.setOnFinished(x -> { // when pause finished
                    setGrid(GridType.Target); // show the target grid...
                    MessageText.setText("Select a spot to attack.");// ... and prompts to attack
                });
                attackPause.play();
                checkWin();
            });
        }).start();
    }

    @FXML
    private void setGrid() { // draws the grid selected by the radio buttons
        if (oceanGridRadio.selectedProperty().get()) {
            fireButton.setDisable(true);
            Draw(GridType.Ocean);
        } else if (targetGridRadio.selectedProperty().get()) {
            fireButton.setDisable(false);
            Draw(GridType.Target);
        }
    }

    /**
     * Sets the grid internally, ensures the correct grid is drawn and the
     * radiobutton is selected on the UI
     * 
     * @param type The GridType to draw. Ocean = player, Target = Opponent
     */
    private void setGrid(GridType type) {
        if (type == GridType.Ocean) {
            fireButton.setDisable(true);
            Draw(GridType.Ocean);
            oceanGridRadio.setSelected(true);
        } else if (type == GridType.Target) {
            fireButton.setDisable(false);
            Draw(GridType.Target);
            targetGridRadio.setSelected(true);
        }
    }

    /**
     * Ends the game and resets the game manager
     * 
     * @param showCommunicationError Shows a dialogue that states a communication
     *                               error happened, for multiplayer
     */
    private void closeGame(boolean showCommunicationError) {
        try { // if opponent disconnects
            App.setRoot("MainMenu");
            GameManager.Reset();
            if (showCommunicationError) {
                alert.setAlertType(AlertType.ERROR);
                alert.setTitle("Communication Error");
                alert.setContentText("Connection closed by opponent.");
                alert.show();
            }
        } catch (IOException ex) {
            System.out.println(">> ERR 0x0001: " + ex.getMessage());
        }
    }

    /**
     * Shows a win/lose message and resets the game manager.
     * 
     * @param win Whether or not the user recieving the message won.
     */
    private void endMessage(boolean win) {
        try {
            App.setRoot("MainMenu");
            GameManager.Reset();
            alert.setAlertType(AlertType.NONE);
            if (win) {
                alert.setTitle("You win!");
                alert.setContentText("You sunk all of their ships!");
            } else {
                alert.setTitle("You lose.");
                alert.setContentText("They sunk all of your ships.");
            }
            alert.show();
        } catch (IOException ex) {
            System.out.println(">> ERR 0x0001: " + ex.getMessage());
        }
    }

    /**
     * Sets the buttons for the UI for the gamestate.
     */
    private void SetUI() {
        switch (GameManager.gameState) {
            case GameState.PlaceShips -> {
                SelectBox.visibleProperty().set(true);
                PlayBox.visibleProperty().set(false);
            }
            case GameState.PlayerTurn, GameState.OpponentTurn -> {
                SelectBox.visibleProperty().set(false);
                PlayBox.visibleProperty().set(true);
            }
            case GameState.Wait -> {
                SelectBox.visibleProperty().set(false);
                PlayBox.visibleProperty().set(false);
            }
            default -> {
            }
        }
    }

    /**
     * Gets a readable message from the string returned from the player or
     * opponent's <b>Attack</b> method
     * 
     * @param string   The string to convert
     * @param isPlayer if the message is from the player or not
     * @return the human-readable string
     */
    private String GetMessage(String string, boolean isPlayer) {
        var stringSection = string.split(",");
        var message = (isPlayer ? "You" : "Opponent") + " attacked " + stringSection[0] + " and ";
        if (stringSection.length == 1) {
            message += "missed.";
        } else if (stringSection[2].equals("t")) {
            message += "sunk " + (isPlayer ? "their " : "your ") + stringSection[1];
        } else {
            message += "hit " + (isPlayer ? "their " : "your ") + stringSection[1];
        }

        return message;
    }

    /**
     * Draws the grid on the UI.
     *
     * @param grid the grid to draw. Ocean represents the player's grid, Target
     *             represents the opponent's grid.
     */
    private void Draw(GridType grid) {
        for (var i = 0; i < _overlayBoard.length; i++) {
            _oceanBoard[i].setImage(GameManager.Sprites.get("ocean").BottomImage); // Set all squares to ocean initially
            _overlayBoard[i].setImage(null);
            _overlayBoard[i].setRotate(0);
            _oceanBoard[i].setRotate(0);
        }
        if (grid == GridType.Ocean) {
            for (var boat : GameManager.player.boats) {
                boolean isHorizontal;
                if (boat.location[0] == null) {
                    continue;
                }
                if (boat.location.length == 1) {
                    isHorizontal = true;
                } else {
                    isHorizontal = boat.location[0].getLetter() != boat.location[1].getLetter();
                }
                for (var i = 0; i < boat.location.length; i++) {
                    if (boat.location != null) {
                        var imgName = "boat";
                        imgName += (i == 0 || i == boat.location.length - 1) ? "End" : "Middle";
                        if (grid == GridType.Ocean) {
                            for (var hit : GameManager.opponent.hitAttempts) {
                                if (hit.location.equals(boat.location[i])) {
                                    imgName += "Hit";
                                    break;
                                }
                            }
                        }
                        var img = GameManager.Sprites.get(imgName);
                        var rotation = 0;
                        _overlayBoard[boat.location[i].getIndex()].setRotate(isHorizontal ? 90 : 0); // set Overlay Rotate
                        _oceanBoard[boat.location[i].getIndex()].setRotate((isHorizontal && img.RotateBottomWithTop) ? 90 : 0); // Rotate bottom with top if needed
                        if (i == boat.location.length - 1) {
                            _overlayBoard[boat.location[i].getIndex()].setRotate(isHorizontal ? 270 : 180);
                            if(img.RotateBottomWithTop)
                            {
                                _oceanBoard[boat.location[i].getIndex()].setRotate(isHorizontal ? 270 : 180);
                            }
                        }
                        _overlayBoard[boat.location[i].getIndex()].setImage(img.TopImage);
                        _oceanBoard[boat.location[i].getIndex()].setImage(img.BottomImage);
                    }
                }
                for (var hit : GameManager.opponent.hitAttempts) {
                    if (!hit.didHit) {
                        _overlayBoard[hit.location.getIndex()].setImage(GameManager.Sprites.get("oceanMiss").TopImage);
                        _oceanBoard[hit.location.getIndex()].setImage(GameManager.Sprites.get("oceanMiss").BottomImage);
                    }
                }
            }
        } else if (grid == GridType.Target) {
            if (GameManager.gameState == GameState.PlayerTurn && _toHit != null) {
                _overlayBoard[_toHit.getIndex()].setImage(GameManager.Sprites.get("oceanTarget").TopImage);
            }
            for (var boat : GameManager.opponent.boats) {
                for (var hit : GameManager.player.hitAttempts) {
                    if (!hit.didHit) {
                        _overlayBoard[hit.location.getIndex()].setImage(GameManager.Sprites.get("oceanMiss").TopImage);
                        _oceanBoard[hit.location.getIndex()].setImage(GameManager.Sprites.get("oceanMiss").BottomImage);
                    } else {
                        _overlayBoard[hit.location.getIndex()].setImage(GameManager.Sprites.get("oceanHit").TopImage);
                        _oceanBoard[hit.location.getIndex()].setImage(GameManager.Sprites.get("oceanMiss").BottomImage);
                    }
                }
            }
        }
    }
}