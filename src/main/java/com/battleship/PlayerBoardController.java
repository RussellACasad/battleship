package com.battleship;

import java.io.IOException;

import com.battleship.Models.BoardLocation;
import com.battleship.Models.Boat;
import com.battleship.Models.BoatType;
import com.battleship.Models.GameManager;
import com.battleship.Models.GameState;
import com.battleship.Models.GridType;
import com.battleship.Models.OpponentAttack;
import com.battleship.Models.Sprite;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;

@SuppressWarnings("unused")
public class PlayerBoardController {

    // Middle Grid
    @FXML
    private ImageView A1, A2, A3, A4, A5, A6, A7, A8, A9, A10;
    @FXML
    private ImageView B1, B2, B3, B4, B5, B6, B7, B8, B9, B10;
    @FXML
    private ImageView C1, C2, C3, C4, C5, C6, C7, C8, C9, C10;
    @FXML
    private ImageView D1, D2, D3, D4, D5, D6, D7, D8, D9, D10;
    @FXML
    private ImageView E1, E2, E3, E4, E5, E6, E7, E8, E9, E10;
    @FXML
    private ImageView F1, F2, F3, F4, F5, F6, F7, F8, F9, F10;
    @FXML
    private ImageView G1, G2, G3, G4, G5, G6, G7, G8, G9, G10;
    @FXML
    private ImageView H1, H2, H3, H4, H5, H6, H7, H8, H9, H10;
    @FXML
    private ImageView I1, I2, I3, I4, I5, I6, I7, I8, I9, I10;
    @FXML
    private ImageView J1, J2, J3, J4, J5, J6, J7, J8, J9, J10;

    // Bottom grid ("O"cean grid)
    @FXML
    private ImageView A1O, A2O, A3O, A4O, A5O, A6O, A7O, A8O, A9O, A10O;
    @FXML
    private ImageView B1O, B2O, B3O, B4O, B5O, B6O, B7O, B8O, B9O, B10O;
    @FXML
    private ImageView C1O, C2O, C3O, C4O, C5O, C6O, C7O, C8O, C9O, C10O;
    @FXML
    private ImageView D1O, D2O, D3O, D4O, D5O, D6O, D7O, D8O, D9O, D10O;
    @FXML
    private ImageView E1O, E2O, E3O, E4O, E5O, E6O, E7O, E8O, E9O, E10O;
    @FXML
    private ImageView F1O, F2O, F3O, F4O, F5O, F6O, F7O, F8O, F9O, F10O;
    @FXML
    private ImageView G1O, G2O, G3O, G4O, G5O, G6O, G7O, G8O, G9O, G10O;
    @FXML
    private ImageView H1O, H2O, H3O, H4O, H5O, H6O, H7O, H8O, H9O, H10O;
    @FXML
    private ImageView I1O, I2O, I3O, I4O, I5O, I6O, I7O, I8O, I9O, I10O;
    @FXML
    private ImageView J1O, J2O, J3O, J4O, J5O, J6O, J7O, J8O, J9O, J10O;

    // Top grid
    @FXML
    private ImageView A1T, A2T, A3T, A4T, A5T, A6T, A7T, A8T, A9T, A10T;
    @FXML
    private ImageView B1T, B2T, B3T, B4T, B5T, B6T, B7T, B8T, B9T, B10T;
    @FXML
    private ImageView C1T, C2T, C3T, C4T, C5T, C6T, C7T, C8T, C9T, C10T;
    @FXML
    private ImageView D1T, D2T, D3T, D4T, D5T, D6T, D7T, D8T, D9T, D10T;
    @FXML
    private ImageView E1T, E2T, E3T, E4T, E5T, E6T, E7T, E8T, E9T, E10T;
    @FXML
    private ImageView F1T, F2T, F3T, F4T, F5T, F6T, F7T, F8T, F9T, F10T;
    @FXML
    private ImageView G1T, G2T, G3T, G4T, G5T, G6T, G7T, G8T, G9T, G10T;
    @FXML
    private ImageView H1T, H2T, H3T, H4T, H5T, H6T, H7T, H8T, H9T, H10T;
    @FXML
    private ImageView I1T, I2T, I3T, I4T, I5T, I6T, I7T, I8T, I9T, I10T;
    @FXML
    private ImageView J1T, J2T, J3T, J4T, J5T, J6T, J7T, J8T, J9T, J10T;

    // Stackpane Grid
    @FXML
    private StackPane A1G, A2G, A3G, A4G, A5G, A6G, A7G, A8G, A9G, A10G;
    @FXML
    private StackPane B1G, B2G, B3G, B4G, B5G, B6G, B7G, B8G, B9G, B10G;
    @FXML
    private StackPane C1G, C2G, C3G, C4G, C5G, C6G, C7G, C8G, C9G, C10G;
    @FXML
    private StackPane D1G, D2G, D3G, D4G, D5G, D6G, D7G, D8G, D9G, D10G;
    @FXML
    private StackPane E1G, E2G, E3G, E4G, E5G, E6G, E7G, E8G, E9G, E10G;
    @FXML
    private StackPane F1G, F2G, F3G, F4G, F5G, F6G, F7G, F8G, F9G, F10G;
    @FXML
    private StackPane G1G, G2G, G3G, G4G, G5G, G6G, G7G, G8G, G9G, G10G;
    @FXML
    private StackPane H1G, H2G, H3G, H4G, H5G, H6G, H7G, H8G, H9G, H10G;
    @FXML
    private StackPane I1G, I2G, I3G, I4G, I5G, I6G, I7G, I8G, I9G, I10G;
    @FXML
    private StackPane J1G, J2G, J3G, J4G, J5G, J6G, J7G, J8G, J9G, J10G;
    @FXML
    private RadioButton horizontalShipRadio, verticalShipRadio,
            carrierRadio, battleshipRadio, destroyerRadio, submarineRadio, patrolRadio, yachtRadio,
            oceanGridRadio, targetGridRadio;
    @FXML
    private VBox SelectBox;
    @FXML
    private HBox PlayBox;
    @FXML
    private Text TitleText;
    @FXML
    private Text MessageText;
    @FXML
    private Button fireButton;
    @FXML
    private Label attackingLabel;
    @FXML
    private Label hoverLabel;
    @FXML
    private StackPane root;

    private ImageView[] _topBoard, _middleBoard, _bottomBoard;
    private StackPane[] _gridBoard;
    private int _selectedShip = 0;
    private transient BoardLocation _toHit = null;
    private final Alert alert = new Alert(AlertType.INFORMATION);
    private Boat ghost = null;
    private BoardLocation attackHoverLocation = null;
    RadioButton[] shipRadios = new RadioButton[6];
    private boolean BlockInput = false;

    /**
     * A thread that manages multiplayer communication.
     * 
     * This starts after each player selects their boats, and constantly messages
     * the opponent.
     * 
     * If a message needs to be sent to the opponent, it is done here.
     */
    private final Thread FeedManager = new Thread(() -> {
        String input;
        while (true) { // Starts a loop that does not end.
            if (GameManager.multiplayerFeed.isEmpty()) { // If there is no message to send to the opponent
                GameManager.out.println("ping"); // Sends the word "ping", this is ignored by the opponent
                try {
                    input = GameManager.in.readLine(); // Awaits a response from the opponent
                    if (input == null) { // If response is null, opponent has disconnected
                        Platform.runLater(() -> closeGame(true));
                        break;
                    }
                    if (input.equals("win")) { // if response is "win", that means all their ships are sunk
                        Platform.runLater(() -> endMessage(true));
                        break;
                    } else if (!input.equals("ping")) { // if respomnse is anything other than "ping"
                        GameManager.multiplayerInput = input; // The response is stored in a variable for usage
                                                              // elsewhere.
                    }
                } catch (IOException ex) {
                    Platform.runLater(() -> closeGame(true)); // If an IO exception is thrown, the opponent has
                                                              // disconnected.
                    break;
                }
            } else { // if the feed is NOT empty
                var x = GameManager.multiplayerFeed.removeFirst(); // Removes the first entry in the feed
                GameManager.out.println(x); // Sends the feed message to the opponent instead of "ping"

                if (x.equals("win")) { // If we are sending win, it measns we lost. End the game with a lose message
                    endMessage(false);
                }
            }
            try { // Wait 100 miliseconds
                Thread.sleep(100);
            } catch (InterruptedException ex) {

                System.out.println("Error in FeedManager Wait");
            }
        }
    });

    @FXML
    public void initialize() { // on view initialize
        GameManager.LoadSprites(); // Loads all of our sprites into RAM

        // Grid for showing the ocean sprites, modifiable in case a sprite needs another
        // bottom sprite than the ocean
        _bottomBoard = new ImageView[] {
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

        // Grid for showing the boat and flag sprites.
        _middleBoard = new ImageView[] {
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

        // Grid for showing the overlay sprites, such as the targeting lines, ship ghost
        // for placing ships, and the exposion sprite when hit.
        _topBoard = new ImageView[] {
                A1T, A2T, A3T, A4T, A5T, A6T, A7T, A8T, A9T, A10T,
                B1T, B2T, B3T, B4T, B5T, B6T, B7T, B8T, B9T, B10T,
                C1T, C2T, C3T, C4T, C5T, C6T, C7T, C8T, C9T, C10T,
                D1T, D2T, D3T, D4T, D5T, D6T, D7T, D8T, D9T, D10T,
                E1T, E2T, E3T, E4T, E5T, E6T, E7T, E8T, E9T, E10T,
                F1T, F2T, F3T, F4T, F5T, F6T, F7T, F8T, F9T, F10T,
                G1T, G2T, G3T, G4T, G5T, G6T, G7T, G8T, G9T, G10T,
                H1T, H2T, H3T, H4T, H5T, H6T, H7T, H8T, H9T, H10T,
                I1T, I2T, I3T, I4T, I5T, I6T, I7T, I8T, I9T, I10T,
                J1T, J2T, J3T, J4T, J5T, J6T, J7T, J8T, J9T, J10T
        };

        // Grid for detecting clicks and user input. The player does not click the
        // image, they click the stackpane.
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

        // For each sprite layer, the bottom right corner needs to be clipped so it's
        // curved.
        // Each layer must have a path created, and the image clipped.
        // Paths cannot be reused per image.
        var radius = 10;

        Path bottomClipPath = new Path(
                new MoveTo(0, 0),
                new LineTo(50, 0),
                new LineTo(50, 50 - radius),
                new ArcTo(10, 10, 0, 50 - radius, 50, false, true),
                new LineTo(0, 50),
                new LineTo(0, 0),
                new ClosePath());

        bottomClipPath.setFill(Color.BLACK);
        bottomClipPath.setStroke(null);

        Path middleClipPath = new Path(
                new MoveTo(0, 0),
                new LineTo(50, 0),
                new LineTo(50, 50 - radius),
                new ArcTo(10, 10, 0, 50 - radius, 50, false, true),
                new LineTo(0, 50),
                new LineTo(0, 0),
                new ClosePath());

        middleClipPath.setFill(Color.BLACK);
        middleClipPath.setStroke(null);

        Path topClipPath = new Path(
                new MoveTo(0, 0),
                new LineTo(50, 0),
                new LineTo(50, 50 - radius),
                new ArcTo(10, 10, 0, 50 - radius, 50, false, true),
                new LineTo(0, 50),
                new LineTo(0, 0),
                new ClosePath());

        topClipPath.setFill(Color.BLACK);
        topClipPath.setStroke(null);

        _bottomBoard[BoardLocation.J10.getIndex()].setClip(bottomClipPath);
        _middleBoard[BoardLocation.J10.getIndex()].setClip(middleClipPath);
        _topBoard[BoardLocation.J10.getIndex()].setClip(topClipPath);

        // Mark all boat place radios as not placed
        carrierRadio.getStyleClass().add("bad");
        battleshipRadio.getStyleClass().add("bad");
        destroyerRadio.getStyleClass().add("bad");
        submarineRadio.getStyleClass().add("bad");
        patrolRadio.getStyleClass().add("bad");
        yachtRadio.getStyleClass().add("bad");

        // Makes an array of ship radios
        shipRadios[0] = carrierRadio;
        shipRadios[1] = battleshipRadio;
        shipRadios[2] = destroyerRadio;
        shipRadios[3] = submarineRadio;
        shipRadios[4] = patrolRadio;
        shipRadios[5] = yachtRadio;

        // Draws the user's grid for the first time
        Draw(GridType.Ocean);

        // Ensure the ship select UI is showing
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

        root.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.R) {
                if (GameManager.gameState == GameState.PlaceShips) {
                    if (verticalShipRadio.isSelected()) {
                        horizontalShipRadio.setSelected(true);
                    } else {
                        verticalShipRadio.setSelected(true);
                    }
                    squareHover();
                    Draw(GridType.Ocean);
                }
            }
        });
    }

    /**
     * When a square has the mouse hovered over it, this function is called.
     */
    @FXML
    void squareHover() {

        if (BlockInput) { // Blocks input if transitioning between views
            ghost = null;
            attackHoverLocation = null;
            hoverLabel.setText("None");
            return;
        }

        BoardLocation hoveredLocation = null;
        for (var i = 0; i < _gridBoard.length; i++) { // scans through the board
            if (_gridBoard[i].isHover()) { // returns the square the user is hovering over
                hoveredLocation = BoardLocation.parseInt(i);
                break;
            }
        }

        if (hoveredLocation != null) // Sets the "hovered location" text
        {
            hoverLabel.setText(hoveredLocation.toString());
        } else {
            hoverLabel.setText("None");
            return;
        }

        switch (GameManager.gameState) {
            case GameState.PlaceShips -> { // Displays the ghost of the boat being placed

                if (ghost == null || GameManager.player.boats[_selectedShip].name != ghost.name) {
                    ghost = new Boat(GameManager.player.boats[_selectedShip].name);
                }

                var isHorizontal = horizontalShipRadio.isSelected();

                var didSetGhost = ghost.SetLocation(hoveredLocation, isHorizontal, GameManager.player);

                if (!didSetGhost) {
                    ghost = null;
                }

                Draw(GridType.Ocean);
            }
            case GameState.PlayerTurn -> { // Sets the attack hover location if on the opponent's grid
                if (targetGridRadio.isSelected()) {
                    attackHoverLocation = hoveredLocation;
                    Draw(GridType.Target);
                }
            }
            default -> {
            } // do nothing normally
        }
    }

    /**
     * Runs when the mouse exits the entire grid, not run checked per-square
     */
    @FXML
    void gridMouseExit() {

        if (BlockInput) {
            return;
        }

        switch (GameManager.gameState) {
            case PlaceShips -> { // Removes the ghost and sets it to null.
                ghost = null;
                Draw(GridType.Ocean);
            }
            case PlayerTurn -> { // Resets the hover label, and sets the hover location to null
                if (targetGridRadio.isSelected()) {
                    attackHoverLocation = null;
                    hoverLabel.setText("None");
                    Draw(GridType.Target);
                }
            }
            default -> {
            } // do nothing normally
        }
    }

    /**
     * Runs every time any square is clicked.
     */
    @FXML
    void squareClicked() {

        if (BlockInput) {
            return;
        }

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
                var wasSet = GameManager.player.boats[_selectedShip].isPlaced;
                var didSet = GameManager.player.boats[_selectedShip].SetLocation(selectedLocation, isHorizontal,
                        GameManager.player); // attempts to set the boat
                if (didSet) { // if the boat is set, upsates the UI and marks the boat as placed
                    GameManager.player.boats[_selectedShip].isPlaced = true;

                    shipRadios[_selectedShip].getStyleClass().removeIf(style -> style.equals("bad"));

                    if (!wasSet && _selectedShip != 5) {
                        selectShip(GameManager.player.boats[_selectedShip + 1].name);
                    }

                    ghost = null;

                    Draw(GridType.Ocean); // redraws the ocean to show the new boat
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

    /**
     * Takes the user back to the main menu. Runs when the back button is pressed.
     * 
     * @throws IOException
     */
    @FXML
    private void back() throws IOException {
        GameManager.Reset();
        App.setRoot("MainMenu");
    }

    /**
     * Runs every time the player changes the ship they are placing.
     */
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
        } else if (yachtRadio.isSelected()) {
            _selectedShip = 5;
        }
    }

    /**
     * Override of the FXML function.
     * Programatically changes the ship's type, and adjusts the radio buttons
     * accordingly.
     * 
     * @param type The ship to change to
     */
    void selectShip(BoatType type) {
        switch (type) {
            case battleship -> {
                battleshipRadio.setSelected(true);
                _selectedShip = 1;
            }
            case carrier -> {
                carrierRadio.setSelected(true);
                _selectedShip = 0;
            }
            case destroyer -> {
                destroyerRadio.setSelected(true);
                _selectedShip = 2;
            }
            case patrolBoat -> {
                patrolRadio.setSelected(true);
                _selectedShip = 4;
            }
            case submarine -> {
                submarineRadio.setSelected(true);
                _selectedShip = 3;
            }
            case yacht -> {
                yachtRadio.setSelected(true);
                _selectedShip = 5;
            }
        }
    }

    /**
     * Randomly places all the ships for the player. Run when the random button is
     * placed.
     */
    @FXML
    private void randomizeShips() {
        for (var boat : GameManager.player.boats) { // for each boat
            var isHorizontal = Math.random() < 0.5; // 50% chance of being horizontal
            var loc = BoardLocation.randomLocation(); // picks a random location
            while (!boat.SetLocation(loc, isHorizontal, GameManager.player)) { // reassigns the location until the boat
                                                                               // sets
                loc = BoardLocation.randomLocation();
            }
            boat.isPlaced = true;
        }

        for (int i = 0; i < shipRadios.length; i++) { // sets the radio buttons
            shipRadios[i].getStyleClass().removeIf(style -> style.equals("bad"));
            if (!GameManager.player.boats[i].isPlaced) {
                shipRadios[i].getStyleClass().add("bad");
            }
        }

        setGrid(GridType.Ocean); // redraws the grid to show boats
    }

    /**
     * This is run when the player confirms all ships are placed.
     */
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

                    if (!GameManager.isSinglePlayer) {
                        FeedManager.start();
                    }

                });
            }).start();
        }
    }

    /**
     * When the fire button is pressed, this handles all the turns as well.
     * 
     * @throws InterruptedException
     */
    @FXML
    private void fire() throws InterruptedException {
        if (_toHit == null) { // returns if no spot is selected to hit.
            return;
        }
        BlockInput = true; // Blocks input
        attackingLabel.setText("None"); // Sets label text
        MessageText.setText("Firing...");
        PlayerTurn(); // send the player's turn to the oppoent
        PauseTransition opponentTurnPause = new PauseTransition(Duration.seconds(GameManager.FIREPAUSE)); // Pause for a
                                                                                                          // moment
        opponentTurnPause.setOnFinished(x -> OpponentTurn()); // when wait done, wait for opponent to fire back
        opponentTurnPause.play(); // Runs the pause transition, pausing for a moment, then running the opponent
                                  // turn.
        checkWin(); // Checks to see if either party has won after their turn.
    }

    /**
     * Checks to see if either person playing has won.
     */
    private void checkWin() {
        if (GameManager.isSinglePlayer) { // Singleplayer
            var allPlayerBoatsSunk = true; // Says all player boats are sunk to start
            for (var boat : GameManager.player.boats) { // checks all boats, if a boat is not sunk, sets
                                                        // allPlayerBoatsSunk to false, then breaks the loop.
                for (var att : boat.isHit) {
                    if (!att) {
                        allPlayerBoatsSunk = false;
                        System.out.println("OPPONENT WIN FAIL: " + boat.name);
                        break;
                    }
                }
                if (!allPlayerBoatsSunk) {
                    break;
                }
            }
            if (allPlayerBoatsSunk) { // If all player's boats are sunk, is a LOSS.
                endMessage(false);
            }

            var allOpponentBoatsSunk = true; // Does the same thing as the player for the opponent.
            for (var boat : GameManager.opponent.boats) {
                for (var att : boat.isHit) {
                    if (!att) {
                        allOpponentBoatsSunk = false;
                        System.out.println("PLAYER WIN FAIL: " + boat.name);
                        return;
                    }
                }
                if (!allOpponentBoatsSunk) {
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
                // TitleText.getScene().getWindow().getScene().getRoot().requestLayout(); //
                // Force layout update
                PauseTransition attackPause = new PauseTransition(Duration.seconds(GameManager.FIREPAUSE));
                attackPause.setOnFinished(x -> { // when pause finished
                    setGrid(GridType.Target); // show the target grid...
                    MessageText.setText("Select a spot to attack.");// ... and prompts to attack
                    BlockInput = false;
                });
                attackPause.play();
            });
        }).start();
    }

    /**
     * draws the grid selected by the radio buttons
     */
    @FXML
    private void setGrid() {
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
            alert.setAlertType(AlertType.INFORMATION);
            if (win) {
                alert.setTitle("You win!");
                alert.setContentText("You sunk all of their ships!");
            } else {
                alert.setTitle("You lose.");
                alert.setContentText("They sunk all of your ships.");
            }
            alert.show();
            App.setRoot("MainMenu");
            GameManager.Reset();
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
        attackingLabel.setText((_toHit == null || BlockInput) ? "None" : _toHit.toString());
        for (var i = 0; i < _middleBoard.length; i++) {
            _bottomBoard[i].setImage(GameManager.Sprites.get("ocean").BottomImage); // Set all squares to ocean
                                                                                    // initially
            _middleBoard[i].setImage(null);
            _topBoard[i].setImage(null);

            _topBoard[i].setRotate(0);
            _middleBoard[i].setRotate(0);
            _bottomBoard[i].setRotate(0);

            if ((grid == GridType.Target) && (GameManager.gameState == GameState.PlayerTurn)
                    && (attackHoverLocation != null || _toHit != null) && !BlockInput) {
                var imgName = "ind";
                var loc = BoardLocation.parseInt(i);
                if (_toHit != null) {
                    imgName += GameManager.LockColor;
                    if (_toHit == loc) {
                        imgName += "Mid";
                    }

                    var img = GameManager.Sprites.get(imgName);
                    if (loc.getLetter() == _toHit.getLetter() || loc.getNumber() == _toHit.getNumber()) {
                        if (loc.getLetter() == _toHit.getLetter()) {
                            _topBoard[i].setRotate(90);
                        }
                        _topBoard[i].setImage(img.TopImage);
                    }
                } else {
                    imgName += GameManager.SeekColor;
                    if (attackHoverLocation == loc) {
                        imgName += "Mid";
                    }
                    var img = GameManager.Sprites.get(imgName);
                    if (loc.getLetter() == attackHoverLocation.getLetter()
                            || loc.getNumber() == attackHoverLocation.getNumber()) {
                        if (loc.getLetter() == attackHoverLocation.getLetter() && (attackHoverLocation != loc)) {
                            _topBoard[i].setRotate(90);
                        }
                        _topBoard[i].setImage(img.TopImage);
                    }
                }

            }

        }

        if (grid == GridType.Ocean) {

            if (ghost != null) {
                for (var loc : ghost.location) {
                    var img = GameManager.Sprites.get("select");
                    _topBoard[loc.getIndex()].setImage(img.TopImage);
                }
            }

            for (var boat : GameManager.player.boats) {
                if (boat.location[0] == null) {
                    continue;
                }

                boolean isHorizontal;
                if (boat.location.length == 1) {
                    isHorizontal = true;
                } else {
                    isHorizontal = boat.location[0].getLetter() != boat.location[1].getLetter();
                }

                for (var i = 0; i < boat.location.length; i++) {
                    if (boat.location != null) {
                        Sprite img;
                        var imgName = boat.name.toString();
                        imgName += String.valueOf(i);
                        if (grid == GridType.Ocean) {
                            for (var hit : GameManager.opponent.hitAttempts) {
                                if (hit.location.equals(boat.location[i])) {
                                    _topBoard[boat.location[i].getIndex()]
                                            .setImage(GameManager.Sprites.get("hit").TopImage);
                                    break;
                                }
                            }
                        }

                        img = GameManager.Sprites.get(imgName);
                        if (img == null) {
                            img = GameManager.Sprites.get("error");
                        }

                        var rotation = 0;
                        _middleBoard[boat.location[i].getIndex()].setRotate(isHorizontal ? 0 : 270); // set Overlay

                        _middleBoard[boat.location[i].getIndex()].setImage(img.MiddleImage);
                        _bottomBoard[boat.location[i].getIndex()].setImage(img.BottomImage);
                    }
                }

                for (var hit : GameManager.opponent.hitAttempts) {
                    if (!hit.didHit) {
                        _middleBoard[hit.location.getIndex()]
                                .setImage(GameManager.Sprites.get("oceanMiss").MiddleImage);
                        _bottomBoard[hit.location.getIndex()]
                                .setImage(GameManager.Sprites.get("oceanMiss").BottomImage);
                    }
                }
            }
        } else if (grid == GridType.Target) {
            for (var hit : GameManager.player.hitAttempts) {
                if (!hit.didHit) {
                    _middleBoard[hit.location.getIndex()].setImage(GameManager.Sprites.get("oceanMiss").MiddleImage);
                    _bottomBoard[hit.location.getIndex()].setImage(GameManager.Sprites.get("oceanMiss").BottomImage);
                } else {
                    _middleBoard[hit.location.getIndex()]
                            .setImage(GameManager.Sprites.get("oceanHit").MiddleImage);
                    _bottomBoard[hit.location.getIndex()]
                            .setImage(GameManager.Sprites.get("oceanHit").BottomImage);
                }
            }
            for (var boat : GameManager.opponent.boats) {
                if (boat.isSunk()) {
                    for (var hitLoc : boat.location) {
                        _middleBoard[hitLoc.getIndex()]
                                .setImage(GameManager.Sprites.get("flagSunk").MiddleImage);
                        _bottomBoard[hitLoc.getIndex()]
                                .setImage(GameManager.Sprites.get("flagSunk").BottomImage);
                    }
                }
            }
        }
    }
}