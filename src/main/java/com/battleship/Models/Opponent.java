package com.battleship.Models;

public class Opponent extends Player {
    public Opponent() {
        super();
    }
    
    public Boat attack()
    {
        var didHit = false;
        Boat hit = null; 
        BoardLocation location = null; 

        while(location == null)
        {
            location = BoardLocation.randomLocation(); 
            for (var attempt : hitAttempts) {
                if (attempt.location == location){
                    location = null; 
                }
            }
        }

        boatCheck: for (var boat : GameConstants.player.boats) {
            for (var i = 0; i < boat.location.length; i++) {
                if (location == boat.location[i]) {
                    didHit = true;
                    boat.isHit[i] = true;
                    hit = boat; 
                    break boatCheck;
                }
            }
        }
        hitAttempts.add(new HitAttempt(location, didHit));
        return hit; 
    }

}
