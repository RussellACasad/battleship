/**
 * Each type of boat, alongside a size for them, and a human readable name. 
 */
package com.battleship.Models;

// define types of ships
public enum BoatType {
    // as what was stated above: type of boat(size, display name)
    carrier(5, "Carrier"),
    battleship(4, "Battleship"),
    destroyer(3, "Destroyer"),
    submarine(3, "Submarine"),
    patrolBoat(2, "Patrol Boat"),
    yacht(1, "Transfer Boat");

    private final int size; // how many grids does this ship take up?
    private final String name; // what is the name of the ship?

    // constructor
    BoatType(int size, String name) {
        this.size = size;
        this.name = name; 
    }

    // accessors
    /**
     * Gets the size of the boat type
     * @return the boat size as an INT
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets a human-readable name for the boat type
     * @return the boat name as a STRING
     */
    public String getName()
    {
        return name; 
    }
}