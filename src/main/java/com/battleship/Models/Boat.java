package com.battleship.Models;

public class Boat 
{
    public BoatType name; 
    public BoardLocation[] location; 
    public boolean[] isHit; 
    public boolean isPlaced; 

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
        if(isHorizontal) // TODO: Comment this
        {
            var locLetter = location.getLetter();
            var locNumber = location.getNumber();
            if (locNumber + (name.getSize() - 1) > 10)
            {
                return false; 
            }

            for (var t : player.boats) {
                if (t == this) break;
                for(var e : t.location)
                {
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
            if (locLetterAsNum + (name.getSize() - 1) > 10)
            {
                return false; 
            }

            for (var t : player.boats) {
                if (t == this) break;
                for(var e : t.location)
                {
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

            for (int i = 0; i < name.getSize(); i++)
            {
                this.location[i] = BoardLocation.parseString(String.valueOf(BoardLocation.getRowChar(locLetterAsNum + i)) + String.valueOf(locNumber));
            }
            return true;
        }
    }

    public boolean isSunk()
    {
        for (var hitCheck : isHit) {
            if (hitCheck == false)
            {
                return false; 
            }
        }
        return true; 
    }
}
