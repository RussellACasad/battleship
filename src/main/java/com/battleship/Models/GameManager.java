/**
 * The gamemanager class. 
 * This holds all needed global variables, all statically.
 * 
 * It also handles the loading of sprites. 
 */

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
    public static final String VERSION = "1.0.0"; // game version
    public static final int FIREPAUSE = 3; // the pause when the fire button is pressed

    public static GameMode gameMode = GameMode.classic; // set game mode
    public static volatile GameState gameState = GameState.PlaceShips; // track game state
    public static Player player = new Player(); // set player
    public static Player opponent = new Player(); // set opponent
    public static ServerSocket hostSocket = null; // host socket for hosting multiplayer game
    public static volatile Socket clientSocket = null; // client socket for connecting to multiplayer game
    public static boolean isHost = false; // who is the host?
    public static BufferedReader in = null; // data streams for multiplaer
    public static PrintWriter out = null; // data streams for multiplayer
    public static boolean isSinglePlayer = true; // is the game single player?
    public static volatile String multiplayerInput = ""; // initialize multiplayerInput string variable
    public static volatile List<String> multiplayerFeed = new ArrayList<>(); // store multiplayer history
    public static HashMap<String, Sprite> Sprites = new HashMap<>(); // store loaded sprites
    public static String textureFolder = "default"; // default texture pack
    public static String SeekColor = "White"; // white crosshairs while selecting tile
    public static String LockColor = "Red"; // red crosshairs when ready to fire

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

    // load sprites into HashMap
    public static void LoadSprites()
    {
        // set variable for ocean (it's the background sprite that others will be on top of)
        var ocean = new Image("/com/battleship/Assets/textures/" + textureFolder +"/other/ocean.gif"); 
        // load tile sprites
        Sprites.put("ocean", new Sprite(ocean));
        Sprites.put("oceanHit", new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder +"/other/Red_Flag.gif")));
        Sprites.put("flagSunk", new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder +"/other/Green_Flag.gif")));
        Sprites.put("oceanMiss", new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder +"/other/White_Flag.gif")));
        Sprites.put("oceanTarget", new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder + "/other/Target.png")));
        Sprites.put("select", new Sprite(new Image("/com/battleship/Assets/textures/" + textureFolder + "/other/overlay/select.png"), true));
        Sprites.put("hit", new Sprite(new Image("/com/battleship/Assets/textures/" + textureFolder + "/boats/hit.gif"), true));
        Sprites.put("error", new Sprite(new Image("/com/battleship/Assets/textures/error.png"), new Image("/com/battleship/Assets/textures/error.png"), new Image("/com/battleship/Assets/textures/error.png")));
        // load boat sprites depending on boat size
        for(var i = 0; i < 5; i++)
        {
            if(i < 1)
            {
                Sprites.put(BoatType.yacht.toString() + String.valueOf(i), new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder + "/boats/yacht/" + i + ".png")));
            }
            if (i < 2)
            {
                Sprites.put(BoatType.patrolBoat.toString() + String.valueOf(i), new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder + "/boats/patrol/" + i + ".png")));
            }
            if (i < 3)
            {
                Sprites.put(BoatType.submarine.toString() + String.valueOf(i), new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder + "/boats/submarine/" + i + ".png")));
                Sprites.put(BoatType.destroyer.toString() + String.valueOf(i), new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder + "/boats/destroyer/" + i + ".png")));
            }
            if (i < 4)
            {
                Sprites.put(BoatType.battleship.toString() + String.valueOf(i), new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder + "/boats/battleship/" + i + ".png")));
            }
            if (i < 5)
            {
                Sprites.put(BoatType.carrier.toString() + String.valueOf(i), new Sprite(ocean, new Image("/com/battleship/Assets/textures/" + textureFolder + "/boats/carrier/" + i + ".png")));
            }

        }
        // load different colors
        String[] colors = {"Red", "White", "Orange", "Green", "Black"}; 
        for (var color : colors) {
            Sprites.put("ind" + color, new Sprite(new Image("/com/battleship/Assets/textures/" + textureFolder + "/indicators/ind_" + color + "_line.png"), true));
            Sprites.put("ind" + color +"Mid", new Sprite(new Image("/com/battleship/Assets/textures/" + textureFolder + "/indicators/ind_" + color + "_mid.png"), true));
        }
    }
}
