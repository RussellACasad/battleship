package com.battleship.Models;

import java.io.IOException;

public class OpponentAttack extends Thread { // TODO: Move back into opponent class, for better OOP support
    BoardLocation location;
    public String out = "";

    public OpponentAttack(BoardLocation location) {
        this.location = location;
    }

    @Override
    public void run() {
        var didHit = false;
        Boat hit = null;

        if (GameManager.isSinglePlayer) // if a singleplayer game
        {
            while (location == null) // TODO: Make the opponent actually try to win instead of always hitting random
                                     // spots
            {
                location = BoardLocation.randomLocation();
                for (var attempt : GameManager.opponent.hitAttempts) {
                    if (attempt.location == location) {
                        location = null;
                    }
                }
            }
        } else // if multiplayer game
        {
            try {
                while(!GameManager.in.ready()) {} // waits for the input stream to be ready
                var locIn = "ping"; // sets locin to ping, to initiate while loop
                while (locIn.equals("ping"))
                {
                    locIn = GameManager.in.readLine(); // waits for the opponent attack
                    if (locIn.equals("ping")) GameManager.out.println("pong"); // if ping, respond pong
                }
                // locIn set now...
                location = BoardLocation.parseString(locIn); // assigns the attack to the location

            } catch (IOException ex) {
                System.out.println(">> ERR 0x0002: " + ex.getMessage()); // if this fires, it means socket closed. PONG will not return, game will end.
                out = null;
                return;
            }
        }

        boatCheck: for (var boat : GameManager.player.boats) { // checks boats in PLAYER board, true if hit, false if not
            for (var i = 0; i < boat.location.length; i++) {
                if (location == boat.location[i]) {
                    didHit = true;
                    boat.isHit[i] = true;
                    hit = boat;
                    break boatCheck;
                }
            }
        }
        GameManager.opponent.hitAttempts.add(new HitAttempt(location, didHit)); // adds the hit attempt to the opponent
        
        var output = ""; // generates the output string
        output += (location != null ? location.name() : "ERR");

        if (hit != null) {
            output += "," + hit.name.getName() + ",";
            output += hit.isSunk() ? "t" : "f";
        }

        if (!GameManager.isSinglePlayer)
        {
            GameManager.out.println(output); // sends the output if multiplayer
        }
        out = output; // returns the output string locally
    }
}
