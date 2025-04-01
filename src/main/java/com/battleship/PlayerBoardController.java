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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

@SuppressWarnings("unused")
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

    private Rectangle[] _board;
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
        _board = new Rectangle[] { // Creates the board grid
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
        carrierRadio.setTextFill(Color.RED); // sets the radio colors to red
        battleshipRadio.setTextFill(Color.RED);
        destroyerRadio.setTextFill(Color.RED);
        submarineRadio.setTextFill(Color.RED);
        patrolRadio.setTextFill(Color.RED);
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
        for (var i = 0; i < _board.length; i++) { // scans through the board
            if (_board[i].isHover()) { // returns the square the user is hovering over
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
                TitleText.setText(GetMessage(opponentAttack.out, false)); // sets the message text for the
                                                                          // attack
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
        for (var square : _board) {
            square.setFill(Color.CORNFLOWERBLUE); // Set all squares to blue initially
        }
        if (grid == GridType.Ocean) {
            for (var boat : GameManager.player.boats) {
                for (BoardLocation location : boat.location) {
                    if (location != null) {
                        _board[location.getIndex()].setFill(Color.BURLYWOOD); // Set boat locations to another
                        // color
                    }
                }

                for (var hit : GameManager.opponent.hitAttempts) {
                    _board[hit.location.getIndex()].setFill(hit.didHit ? Color.RED : Color.WHITE);
                }
            }
        } else if (grid == GridType.Target) {

            if (GameManager.gameState == GameState.PlayerTurn && _toHit != null) {
                _board[_toHit.getIndex()].setFill(Color.MEDIUMAQUAMARINE);
            }

            for (var hit : GameManager.player.hitAttempts) {
                _board[hit.location.getIndex()].setFill(hit.didHit ? Color.RED : Color.WHITE);
            }
        }
    }
}
