package com.battleship.Models;

public enum BoatType {
    carrier(5, "Carrier"),
    battleship(4, "Battleship"),
    destroyer(3, "Destroyer"),
    submarine(3, "Submarine"),
    patrolBoat(2, "Patrol Boat");

    private final int size;
    private final String name; 

    BoatType(int size, String name) {
        this.size = size;
        this.name = name; 
    }

    public int getSize() {
        return size;
    }

    public String getName()
    {
        return name; 
    }
}

