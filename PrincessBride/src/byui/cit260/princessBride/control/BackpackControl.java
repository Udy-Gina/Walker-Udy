/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.exceptions.GameControlException;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import java.util.List;
import princessBride.PrincessBride;

/**
 *
 * @author Gina Udy
 */
public class BackpackControl {

    List<Item> currentBackpack = PrincessBride.getCurrentGame().getPlayer().getBackpack();

    public boolean displayBackpack() throws GameControlException {

        if (currentBackpack != null) {
            return true;
        } else {
            throw new GameControlException("\nYour backpack is empty.");
        }

        //return currentBackpack != null;
    }

    public boolean addItemToBackpack() throws GameControlException {
        Location currentLocation = PrincessBride.getPlayer().getLocation();

        if (currentLocation.getItem() != null) {
            PrincessBride.getPlayer().addItemToBackpack(currentLocation.getItem());
            return true;
        } else {
            throw new GameControlException("\nThere is nothing here.");
        }
    }
}

// TODO Remove items from the backpack list when used in a danger
//    public void removeItemFromBackpack() {
//
//        //TODO Build function to remove item from backpack list
//        this.console.println("\n *** removeItemFromBackpack() function called *** ");
//    }
//
//    // Create starting point on map at location 0,0 
//    private void startingLocation(Map map, Player player) {  //TODO: set starting point on map 
//
//        player.setLocation(map.getLocationAt(0, 0));
//
//    }
