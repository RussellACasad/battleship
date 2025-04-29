/*
 * A location, and whether the attempt was a hit or miss. 
 */

package com.battleship.Models;

public class HitAttempt {
    public BoardLocation location;
    public boolean didHit; 

    public HitAttempt(BoardLocation location, boolean didHit)
    {
        this.location = location; 
        this.didHit = didHit; 
    }
}
