/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.exceptions.MovementControlException;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import princessBride.PrincessBride;

/**
 *
 * @author Gina Udy & Lisa Walker
 */
public class MovementControl  {
    
    public boolean moveWest() throws MovementControlException{
        Player player = PrincessBride.getCurrentGame().getPlayer();
        Location currentLocation = player.getLocation();
        Map map = PrincessBride.getCurrentGame().getMap();

        if (currentLocation.getCol() == 0) {
        throw new MovementControlException();
        }
        player.setLocation(map.getLocationAt(currentLocation.getRow(), currentLocation.getCol() - 1));
        return true;
    }
      public boolean moveSouth() throws MovementControlException{
        Player player = PrincessBride.getCurrentGame().getPlayer();
        Location currentLocation = player.getLocation();
        Map map = PrincessBride.getCurrentGame().getMap();

        if (currentLocation.getRow() == 4) {
           throw new MovementControlException();
        }
        player.setLocation(map.getLocationAt(currentLocation.getRow() +1, currentLocation.getCol()));
        return true;
    }
    public boolean moveNorth() throws MovementControlException {
        Player player = PrincessBride.getCurrentGame().getPlayer();
        Location currentLocation = player.getLocation();
        Map map = PrincessBride.getCurrentGame().getMap();

        if (currentLocation.getRow() == 0) {
           throw new MovementControlException();
        }
        player.setLocation(map.getLocationAt(currentLocation.getRow() -1, currentLocation.getCol()));
        return true;
    }
    public boolean moveEast() throws MovementControlException {
        Player player = PrincessBride.getCurrentGame().getPlayer();
        Location currentLocation = player.getLocation();
        Map map = PrincessBride.getCurrentGame().getMap();

        if (currentLocation.getCol() == 4) {
     throw new MovementControlException();
        }
        player.setLocation(map.getLocationAt(currentLocation.getRow(), currentLocation.getCol() + 1));
        return true;
    }
    
    
}
