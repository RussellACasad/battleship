package com.battleship.Models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.scene.image.Image;

public class GameManager {
    public static final String VERSION = "Beta 1.1.1"; // game version
    public static final int FIREPAUSE = 3; // the pause when the fire button is pressed

    public static GameMode gameMode = GameMode.classic; 
    public static transient GameState gameState = GameState.PlaceShips; 
    public static Player player = new Player();
    public static Player opponent = new Player();
    public static ServerSocket hostSocket = null;
    public static transient Socket clientSocket = null;
    public static boolean isHost = false;
    public static BufferedReader in = null;
    public static PrintWriter out = null;
    public static boolean isSinglePlayer = true;
    public static transient volatile String multiplayerInput = ""; 
    public static transient List<String> multiplayerFeed = new ArrayList<>();
    public static HashMap<String, Sprite> Sprites = new HashMap<>(); 

    /**
     * Resets the GameManager to default settings, as well as closes all multiplayer streams and sets them back to NULL. 
     */
    public static void Reset() {
        gameMode = GameMode.classic;
        gameState = GameState.PlaceShips;
        player = new Player();
        opponent = new Player();
        isHost = false;
        isSinglePlayer = true;
        if (in != null) {
            try {
                in.close();
                in = null;
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
        if (out != null) {
            out.close();
            out = null;
        }
        if (hostSocket != null) {
            try {
                hostSocket.close();
                hostSocket = null;
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
        if (clientSocket != null) {
            try {
                clientSocket.close();
                clientSocket = null;
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
    }

    public static void LoadSprites()
    {
        var ocean = new Image("/com/battleship/Assets/ocean.gif"); 

        Sprites.put("boatEnd", new Sprite(new Image("/com/battleship/Assets/boat-end.jpg"), ocean));
        Sprites.put("boatEndHit", new Sprite(new Image("/com/battleship/Assets/boat-end-hit.jpg"), ocean));
        Sprites.put("boatMiddle", new Sprite(new Image("/com/battleship/Assets/boat-middle.jpg"), ocean));
        Sprites.put("boatMiddleHit", new Sprite(new Image("/com/battleship/Assets/boat-middle-hit.jpg"), ocean));
        Sprites.put("boatTile", new Sprite(new Image("/com/battleship/Assets/boat-tile.jpg"), ocean));
        Sprites.put("ocean", new Sprite(null, ocean));
        Sprites.put("oceanHit", new Sprite(new Image("/com/battleship/Assets/ocean-hit.jpg"), ocean));
        Sprites.put("oceanMiss", new Sprite(new Image("/com/battleship/Assets/ocean-miss.jpg"), ocean));
        Sprites.put("oceanTarget", new Sprite(new Image("/com/battleship/Assets/ocean-target.jpg"), ocean));
    }
}
