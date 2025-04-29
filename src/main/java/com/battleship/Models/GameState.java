/**
 * The different states the game can be. 
 */

package com.battleship.Models;

public enum GameState {
    PlaceShips,
    Wait,
    PlayerTurn,
    OpponentTurn,
    GameOver
}
