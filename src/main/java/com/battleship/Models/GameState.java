/**
 * The different states the game can be. 
 */

package com.battleship.Models;

public enum GameState {
    PlaceShips, // PlaceShips should be the default game mode
    Wait,
    PlayerTurn,
    OpponentTurn,
    GameOver
}
