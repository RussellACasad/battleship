package com.battleship.Models;

import java.util.ArrayList;
import java.util.List;

public class OpponentAttack extends Thread {
    BoardLocation location;
    public String out = "";

    public OpponentAttack(BoardLocation location) {
        this.location = location;
    }

    @Override
    public void run() {
        if (!GameManager.isSinglePlayer) {
            // Network play: use provided protocol.
                while (GameManager.multiplayerInput.equals("")) {} // Wait for an input from client
                this.location = BoardLocation.parseString(GameManager.multiplayerInput);
                GameManager.multiplayerInput = "";
        } else {
            // Single-player: use the enhanced AI logic.
            this.location = getNextAttackLocation();
        }

        boolean didHit = false;
        Boat hitBoat = null;
        // Check if the chosen location hits any of the player's boats.
        for (Boat boat : GameManager.player.boats) {
            for (int i = 0; i < boat.location.length; i++) {
                if (this.location == boat.location[i]) {
                    didHit = true;
                    boat.isHit[i] = true;
                    hitBoat = boat;
                    break;
                }
            }
            if (didHit) break;
        }

        GameManager.opponent.hitAttempts.add(new HitAttempt(this.location, didHit));

        String output = (this.location != null ? this.location.name() : "ERR");
        if (hitBoat != null) {
            output += "," + hitBoat.name.getName() + ",";
            output += (hitBoat.isSunk() ? "t" : "f");
        }
        if (!GameManager.isSinglePlayer) {
            GameManager.multiplayerFeed.add(output); 
        }
        this.out = output;
    }

    /**
     * Determines the next attack location using the hunt/target methods.
     * @return The location to be attacked
     */
     
    private BoardLocation getNextAttackLocation() {
        // Target mode: if any previous hit exists, try its neighbors.
        for (HitAttempt attempt : GameManager.opponent.hitAttempts) {
            if (attempt.didHit) {
                for (BoardLocation neighbor : attempt.location.getNeighbors()) {
                    if (!hasAttempted(neighbor)) {
                        return neighbor;
                    }
                }
            }
        }
        // Hunt mode: choose from unattempted locations in a checkerboard pattern.
        List<BoardLocation> candidates = new ArrayList<>();
        for (BoardLocation loc : BoardLocation.values()) {
            int row = loc.getLetter() - 'A';
            int col = loc.getNumber() - 1;
            // Use a checkerboard pattern: only consider locations where (row+col) is even.
            if ((row + col) % 2 == 0 && !hasAttempted(loc)) {
                candidates.add(loc);
            }
        }
        // If nothing found, pick any unattempted location.
        if (candidates.isEmpty()) {
            for (BoardLocation loc : BoardLocation.values()) {
                if (!hasAttempted(loc)) {
                    candidates.add(loc);
                }
            }
        }
        if (!candidates.isEmpty()) {
            int index = (int) (Math.random() * candidates.size());
            return candidates.get(index);
        }
        // If every spot has been attempted, return null.
        return null;
    }

    //Checks if the chosen location has already been attacked.
     
    private boolean hasAttempted(BoardLocation loc) {
        for (HitAttempt attempt : GameManager.opponent.hitAttempts) {
            if (attempt.location == loc) {
                return true;
            }
        }
        return false;
    }
}
//******** 