package com.battleship.Models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public Boat[] boats;
    public List<HitAttempt> hitAttempts = new ArrayList<>();

    public Player() {
        boats = new Boat[5];
        boats[0] = new Boat(BoatType.carrier);
        boats[1] = new Boat(BoatType.battleship);
        boats[2] = new Boat(BoatType.destroyer);
        boats[3] = new Boat(BoatType.submarine);
        boats[4] = new Boat(BoatType.patrolBoat);
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
     * @param location The location to attack. 
     * @return The boat that was attacked. If no boat is attacked, returns null. 
     */
    public Boat attack(BoardLocation location) {
        var didHit = false;
        Boat hit = null; 

        boatCheck: for (var boat : GameConstants.opponent.boats) {
            for (var i = 0; i < boat.location.length; i++) {
                if (location == boat.location[i]) {
                    didHit = true;
                    boat.isHit[i] = true;
                    hit = boat;
                    break boatCheck;
                }
            }
        }

        hitAttempts.add(new HitAttempt(location, didHit));
        return hit; 
    }
}
