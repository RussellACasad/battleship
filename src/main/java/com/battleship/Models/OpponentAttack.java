package com.battleship.Models;

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
            while (GameManager.multiplayerInput.equals("")) {} // waits for input
            location = BoardLocation.parseString(GameManager.multiplayerInput); // assigns the attack to the location
            GameManager.multiplayerInput = "";
        }

        boatCheck: for (var boat : GameManager.player.boats) { // checks boats in PLAYER board, true if hit, false if
                                                               // not
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

        if (!GameManager.isSinglePlayer) {
            GameManager.multiplayerFeed.add(output); // sends the output if multiplayer
        }
        out = output; // returns the output string locally
    }
}
