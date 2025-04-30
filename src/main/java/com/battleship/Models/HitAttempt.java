/*
 * A location, and whether the attempt was a hit or miss. 
 */

package com.battleship.Models;

public class HitAttempt {
    public BoardLocation location; // where did the attack land?
    public boolean didHit; // did the attack hit?

    // initialize new attack
    public HitAttempt(BoardLocation location, boolean didHit)
    {
        this.location = location; // set object's location to location
        this.didHit = didHit; // set object's didHit to didHit
    }
}