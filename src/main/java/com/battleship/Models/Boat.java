/**
 * The class for a boat. Stores the location, which segments are hit, and whether the boat is placed or not. 
 */

package com.battleship.Models;

public class Boat 
{
    public BoatType name; // type of boat
    public BoardLocation[] location; // grid coordinates of boat
    public boolean[] isHit; // which segments are hit?
    public boolean isPlaced; // has the ship been placed?

    /**
     * Constructor for Boat
     * @param name The type of boat
     */
    public Boat(BoatType name) {
        this.name = name;
        this.location = new BoardLocation[name.getSize()];
        this.isHit = new boolean[name.getSize()];
        this.isPlaced = false;
    }

    /**
     * Sets the boat location
     * @param location The location of the boat, starting from the top left
     * @param isHorizontal True if the boat is horizontal, false if vertical
     * @return True if the location is valid, false otherwise
     */
    public boolean SetLocation(BoardLocation location, boolean isHorizontal, Player player) { 
        if(isHorizontal) 
        {
            var locLetter = location.getLetter(); // gets the location letter
            var locNumber = location.getNumber(); // gets the location  number
            // ensure boat does not extend past the board horizontally
            if (locNumber + (name.getSize() - 1) > 10) // if the boat will fall out from the board...
            {
                return false; // ... say location set failed
            }

            for (var t : player.boats) { // check the boat is already placed
                if (t == this) break;
                for(var e : t.location)
                {
                    // check for ship overlap
                    if (e == null) continue;
                    if(e.equals(location))
                    {
                        return false; 
                    }
                    if(e.getLetter() == locLetter && e.getNumber() >= locNumber && e.getNumber() <= locNumber + (name.getSize() - 1))
                    {
                        return false; 
                    }
                }
            }
            // fill location with adjacent columns
            for (int i = 0; i < name.getSize(); i++)
            {
                this.location[i] = BoardLocation.parseString(String.valueOf(locLetter) + String.valueOf(i + locNumber));
            }
            return true; 
        }
        else
        {
            var locLetterAsNum = BoardLocation.getRowNum(location.getLetter());
            var locNumber = location.getNumber();
            // ensure boat does not extend past the board vertically
            if (locLetterAsNum + (name.getSize() - 1) > 10)
            {
                return false; 
            }

            for (var t : player.boats) {
                if (t == this) break;
                for(var e : t.location)
                {
                    // check for ship overlap
                    if (e == null) continue;
                    if(e.equals(location))
                    {
                        return false; 
                    }
                    if(e.getNumber() == locNumber && BoardLocation.getRowNum(e.getLetter()) >= locLetterAsNum && BoardLocation.getRowNum(e.getLetter()) <= locLetterAsNum + (name.getSize() - 1))
                    {
                        return false; 
                    }
                }
            }
            // fill location with adjacent rows
            for (int i = 0; i < name.getSize(); i++)
            {
                this.location[i] = BoardLocation.parseString(String.valueOf(BoardLocation.getRowChar(locLetterAsNum + i)) + String.valueOf(locNumber));
            }
            return true;
        }
    }

    // is the ship sunk?
    public boolean isSunk()
    {
        for (var didHit : isHit) { // for each didHit in isHit...
            if (!didHit) // if it's not a didHit...
            {
                return false; // return false
            }
        }
        return true; // return true
    }
}
