/**
 * The player class. This stores all the player's data, including their boats and hit attempts. 
 * 
 * Can be used as the PLAYER or OPPONENT.
 */

package com.battleship.Models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public final Boat[] boats;
    public volatile List<HitAttempt> hitAttempts = new ArrayList<>();
    public volatile boolean shipsSet;

    public Player() {
        boats = new Boat[6];
        boats[0] = new Boat(BoatType.carrier);
        boats[1] = new Boat(BoatType.battleship);
        boats[2] = new Boat(BoatType.destroyer);
        boats[3] = new Boat(BoatType.submarine);
        boats[4] = new Boat(BoatType.patrolBoat);
        boats[5] = new Boat(BoatType.yacht);
        shipsSet = false;
        hitAttempts = new ArrayList<>();
    }

    /**
     * Checks if a boat the player has is hit, returning true if the boat is hit,
     * 
     * @param location The location to check
     * @return True if the location is a hit, false otherwise
     */
    public boolean checkHit(BoardLocation location) {

        for (Boat boat : boats) {
            for (int j = 0; j < boat.location.length; j++) {
                if (boat.location[j].equals(location)) {
                    boat.isHit[j] = true;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if all boats are placed
     * 
     * @return True if all boats are placed, false otherwise
     */
    public boolean allBoatsPlaced() {
        for (Boat boat : boats) {
            if (!boat.isPlaced) {
                return false;
            }
        }
        return true;
    }

    /**
     * Attempts an attack on the <b>opponent</b>
     * 
     * @param location The location to attack.
     * @return The boat that was attacked. If no boat is attacked, returns null.
     */
    public String attack(BoardLocation location) {
        if (GameManager.isSinglePlayer) // if is a single player game
        {
            var didHit = false;
            Boat hit = null;

            boatCheck: for (var boat : GameManager.opponent.boats) { // checks each boat for a hit
                for (var i = 0; i < boat.location.length; i++) {
                    if (location == boat.location[i]) {
                        didHit = true;
                        boat.isHit[i] = true;
                        hit = boat;
                        break boatCheck;
                    }
                }
            }

            hitAttempts.add(new HitAttempt(location, didHit)); // adds to the hit attempts

            var output = ""; // returns the output string

            output += location.name() + ",";
            if (hit != null) {
                output += hit.name.getName() + ",";
                output += hit.isSunk() ? "t" : "f";
            }
            return output; // returns the result
        } else // if is multiplayer game
        {
            GameManager.multiplayerFeed.add(location.toString()); // sends the attack to the opponent
            while (GameManager.multiplayerInput.equals("")) {}
            var result = GameManager.multiplayerInput; // gets the result of the atack
            GameManager.multiplayerInput = "";
            hitAttempts.add(new HitAttempt(location, result.length() > 3)); // adds to the hit attempts
            GameManager.gameState = GameState.OpponentTurn;
            return result; // returns the result
        }
    }
}
