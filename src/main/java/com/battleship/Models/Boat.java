package com.battleship.Models;

public class Boat 
{
    public BoatType name; 
    public int count; 
    public BoardLocation[] location; 
    public boolean[] isHit; 
    public boolean isSunk; 
    public boolean isPlaced; 

    /**
     * Constructor for Boat
     * @param count The number of squares the boat occupies
     * @param name The name of the boat
     */
    public Boat(BoatType name) {
        this.name = name;
        this.count = name.getSize();
        this.location = new BoardLocation[count];
        this.isHit = new boolean[count];
        this.isPlaced = false;
        this.isSunk = false; 
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
            var locLetter = location.getLetter();
            var locNumber = location.getNumber();
            if (locNumber + (count - 1) > 10)
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
                    if(e.getLetter() == locLetter && e.getNumber() >= locNumber && e.getNumber() <= locNumber + (count - 1))
                    {
                        return false; 
                    }
                }
            }

            for (int i = 0; i < count; i++)
            {
                this.location[i] = BoardLocation.parseString(String.valueOf(locLetter) + String.valueOf(i + locNumber));
            }
            return true; 
        }
        else
        {
            var locLetterAsNum = BoardLocation.getRowNum(location.getLetter());
            var locNumber = location.getNumber();
            if (locLetterAsNum + (count - 1) > 10)
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
                    if(e.getNumber() == locNumber && BoardLocation.getRowNum(e.getLetter()) >= locLetterAsNum && BoardLocation.getRowNum(e.getLetter()) <= locLetterAsNum + (count - 1))
                    {
                        return false; 
                    }
                }
            }

            for (int i = 0; i < count; i++)
            {
                this.location[i] = BoardLocation.parseString(String.valueOf(BoardLocation.getRowChar(locLetterAsNum + i)) + String.valueOf(locNumber));
            }
            return true;
        }
    }
}
