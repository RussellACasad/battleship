package com.battleship.Models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GameManager {
    public static final String VERSION = "Beta 1.0.0"; // game version
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
}
