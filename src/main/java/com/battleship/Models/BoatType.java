package com.battleship.Models;

public enum BoatType {
    carrier(5),
    battleship(4),
    destroyer(3),
    submarine(3),
    patrolBoat(2);

    private final int size;

    BoatType(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

