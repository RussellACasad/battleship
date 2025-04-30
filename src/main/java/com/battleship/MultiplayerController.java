package com.battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.battleship.Models.GameManager;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Text;

@SuppressWarnings("unused")
public class MultiplayerController { // multiplayer setup screen
    @FXML
    private TextField hostPortText, joinPortText, joinIPText; // joining inputs
    @FXML
    private Text statusMessage, localIPText; // connection status and user's IP
    @FXML
    private TitledPane joinPane, hostPane; // panels for joining and hosting options

    private String ip; 

    @FXML
    public void initialize() throws UnknownHostException // called when FXML loads to fetch and display local IP
    {
        ip = InetAddress.getLocalHost().getHostAddress(); 
        localIPText.setText("Your local IP: " + ip.trim()); // shows local IP on multiplayer menu
    }

    @FXML
    public void copyIP() // when Copy IP is clicked, this method copies it to clipboard for easy sharing
    {
        Clipboard clipboard = Clipboard.getSystemClipboard(); 
        ClipboardContent content = new ClipboardContent(); 
        content.putString(ip); 
        clipboard.setContent(content); 
    }

    @FXML
    public void copyPort() // when Copy Port is clicked, this method copies it to cipboard for easy sharing
    {
        Clipboard clipboard = Clipboard.getSystemClipboard(); 
        ClipboardContent content = new ClipboardContent(); 
        content.putString(hostPortText.getText().trim()); 
        clipboard.setContent(content); 
    }

    @FXML
    private void host() { // peer as host
        if (hostPortText.getText().isEmpty()) // if no port is applied, set to 0 to randomly assign a port
            hostPortText.setText("0");
        int port;
        try { // converts the port to an int
            port = Integer.parseInt(hostPortText.getText().trim());
        } catch (NumberFormatException ex) {
            System.err.println("Invalid port number: " + hostPortText.getText());
            return;
        }

        joinPane.setDisable(true);
        hostPortText.setDisable(true);

        statusMessage.setText("Awaiting client..."); // sets the message to be awaiting a client
        GameManager.isHost = true;
        new Thread(() -> { // starts a new thread to not hang the UI and allow to cancel
            try (ServerSocket serverSocket = new ServerSocket(port)) {// creates the new socket
                if(port == 0) hostPortText.setText(String.valueOf(serverSocket.getLocalPort())); // ensures the port textfield has the correct port, or sets if randomly assigned
                GameManager.hostSocket = serverSocket;
                GameManager.clientSocket = serverSocket.accept(); // waits for the client peer to connect
                GameManager.in = new BufferedReader(new InputStreamReader(GameManager.clientSocket.getInputStream())); // establish I/O
                GameManager.out = new PrintWriter(GameManager.clientSocket.getOutputStream(), true);
                GameManager.isSinglePlayer = false; // sets the gamemanager to be multiplayer
                var version = GameManager.in.readLine();  // detects the client peer's version
                if (!version.equals(GameManager.VERSION)) // cancels connection if there is a version mismatch
                {
                    GameManager.out.println(GameManager.VERSION);
                    statusMessage.setText("Version mismatch - you have: " + GameManager.VERSION + ", they have " + version);
                    GameManager.Reset();
                    return;
                }
                GameManager.out.println("t"); // outputs "t" to client to say the version check passed 
                Platform.runLater(() -> { // when the thread completes, load the playerboard
                    try {
                        App.setRoot("PlayerBoard");
                    } catch (IOException e) {
                        e.getStackTrace();
                        statusMessage.setText("Error loading PlayerBoard"); // if, for whatever reason, loading fails...
                    }
                });
            } catch (IOException ex) {
                ex.getStackTrace(); 
                statusMessage.setText("Error while hosting");
            }
        }).start();
    }

    @FXML
    private void join() { // peer as client
        if (joinPortText.getText().equals(""))
            return;
        int port;
        try { // converts port to an INT
            port = Integer.parseInt(joinPortText.getText().trim());
        } catch (NumberFormatException ex) {
            System.err.println("Invalid port number: " + joinPortText.getText());
            return;
        }
         
        String ip = joinIPText.getText().trim(); 

        ip = ip.isEmpty() ? "localhost" : ip; // if IP empty, set to local host

        try {
            GameManager.isHost = false; // sets the gamemanager to know this is not a host
            GameManager.clientSocket = new Socket(ip , port); // connects to the server peer
            GameManager.in = new BufferedReader(new InputStreamReader(GameManager.clientSocket.getInputStream())); // establishes I/O
            GameManager.out = new PrintWriter(GameManager.clientSocket.getOutputStream(), true);
            GameManager.isSinglePlayer = false; // sets to multiplayer game

            GameManager.out.println(GameManager.VERSION); // sends the version
            var canConnect = GameManager.in.readLine(); // if can connect, recieves "t", otherwise recieves the host version
            
            
            if (!canConnect.equals("t")) // cancels connect if version mismatch
            {
                statusMessage.setText("Version mismatch - you have: " + GameManager.VERSION + ", they have " + canConnect);
                GameManager.Reset();
                return;
            }

            App.setRoot("PlayerBoard"); // sets root to playerboard
        } catch (IOException e) {
            statusMessage.setText("Connection Failed");
        }
    }

    @FXML
    private void back() throws IOException // back button pressed
    {
        if (GameManager.clientSocket != null) GameManager.clientSocket.close(); // close any open sockets
        if (GameManager.hostSocket != null) GameManager.hostSocket.close();
        
        App.setRoot("MainMenu"); // set root back to main menu
    }
}