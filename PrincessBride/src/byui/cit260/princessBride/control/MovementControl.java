/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import princessbride.PrincessBride;

/**
 *
 * @author Gina Udy & Lisa Walker
 */
public class MovementControl {
    
    public boolean moveWest() {
        Player player = PrincessBride.getCurrentGame().getPlayer();
        Location currentLocation = player.getLocation();
        Map map = PrincessBride.getCurrentGame().getMap();

        if (currentLocation.getCol() == 0) {
            return false;
        }
        player.setLocation(map.getLocationAt(currentLocation.getRow(), currentLocation.getCol() - 1));
        return true;
    }
      public boolean moveSouth() {
        Player player = PrincessBride.getCurrentGame().getPlayer();
        Location currentLocation = player.getLocation();
        Map map = PrincessBride.getCurrentGame().getMap();

        if (currentLocation.getRow() == 5) {
            return false;
        }
        player.setLocation(map.getLocationAt(currentLocation.getRow(), currentLocation.getCol() - 1));
        return true;
    }
    
}
