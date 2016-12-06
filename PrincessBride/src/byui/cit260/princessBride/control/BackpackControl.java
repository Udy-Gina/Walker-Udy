/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.exceptions.BackpackControlException;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.LocationType;
import java.util.ArrayList;
import java.util.List;
import princessBride.PrincessBride;

/**
 *
 * @author Gina Udy
 */
public class BackpackControl {

    List<Item> currentBackpack = PrincessBride.getCurrentGame().getPlayer().getBackpack();

    public void displayBackpack() throws BackpackControlException {

        /*for (currentBackpack = 0; currentBackpack < 10; currentBackpack++) {
            String Backpack = currentBackpack.toString();
            if (currentBackpack != null) {
                return true;
            } else {
                throw new BackpackControlException("\nYour backpack is empty.");
            }

        } return false; */
        System.out.println("\n *** currentBackpack() function called *** ");

    }
    
    
    public Item addItemToBackpack() throws BackpackControlException {
        
        Location location = PrincessBride.getCurrentGame().getPlayer().getLocation();
        LocationType locationType = PrincessBride.getCurrentGame().getPlayer().getLocation().getLocationType();
        
        if(location.getItem() == null) {
            throw new BackpackControlException("No item here");
        }
        
        PrincessBride.getCurrentGame().getPlayer().addItemToBackpack(location.getItem());
        
        Item rtn = location.getItem();
        
        location.setItem(null);
        
        return rtn;
    }       

    ////////////////////////////////////////////////////////////////////////////
    /// THIS IS WHAT THE CODE WAS PRIOR TO MAKING THE ITEM LOCATIONS PART OF ///
    /// THE LOCATIONTYPE ENUM (IT WOULD ASSIGN AN ITEM TO RANDOM LOCATIONS   ///
    ////////////////////////////////////////////////////////////////////////////
    
    /*public boolean addItemToBackpack() throws BackpackControlException {
        
        Location currentLocation = PrincessBride.getPlayer().getLocation();

        if (currentLocation.getItem() != null) {
            PrincessBride.getPlayer().addItemToBackpack(currentLocation.getItem());
            return true;
        } else {
            throw new BackpackControlException("\nThere is nothing here.");
        }
    }*/    
    
    public static List<Item> createItemList() {

        List<Item> backpackItem = new ArrayList<>();

        Item dart = new Item();
        dart.setItemDescription("tranquilizer dart");
        backpackItem.add(dart);

        Item potion = new Item();
        potion.setItemDescription("healing potion");
        backpackItem.add(potion);

        Item water = new Item();
        water.setItemDescription("bucket of water");
        backpackItem.add(water);

        return backpackItem;

    }

    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //TODO Remove items from the backpack list when used in a danger
    public boolean removeItemFromBackpack() throws BackpackControlException {

        System.out.println("\n *** removeItemFromBackpack() function called ***");

        return true;
    }

}
