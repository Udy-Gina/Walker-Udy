/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import java.util.ArrayList;

/**
 *
 * @author Gina Udy & Lisa Walker
 */
public class InventoryControl  {

    ArrayList<Item> items = new ArrayList();
    
    
    public void createInventoryList() {
    
        // check to see what is in actual inventory list (what has user picked up/used) 
        
    
    }

    public void removeFromInventoryList() {
    
        // if player enters wrong answer, remove from inventory ("use option" on menu)
        
    
    }

    public boolean addToInventoryList(Location rand) {
        
        // if location has item, add to inventory ("take option" on menu)
        Location 1 = item.getLocation(); 
            if(1.getItem() != null) {
                item.addItem(1.getItem());
                1.setItem(null);
        return true;
    }
    }

}
