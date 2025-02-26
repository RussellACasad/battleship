package com.battleship.Models;

public class Player {
    public Boat[] boats;

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
}
