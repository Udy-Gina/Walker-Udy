/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.exceptions.BackpackControlException;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import java.util.ArrayList;
import java.util.List;
import princessBride.PrincessBride;

/**
 *
 * @author Gina Udy
 */
public class BackpackControl {

    public Item addItemToBackpack() throws BackpackControlException {

        Location location = PrincessBride.getCurrentGame().getPlayer().getLocation();
        //LocationType locationType = PrincessBride.getCurrentGame().getPlayer().getLocation().getLocationType();

        if (location.getItem() == null) {
            throw new BackpackControlException("There is nothing here.");
        }

        PrincessBride.getCurrentGame().getPlayer().addItemToBackpack(location.getItem());

        Item rtn = location.getItem();

        location.setItem(null);

        return rtn;
    }

    public static List<Item> createItemList() {

        List<Item> backpackItem = new ArrayList<>();

        Item dart1 = new Item();
        dart1.setItemDescription("Tranquilizer Dart");
        backpackItem.add(dart1);

        Item potion1 = new Item();
        potion1.setItemDescription("Healing Potion");
        backpackItem.add(potion1);

        Item water1 = new Item();
        water1.setItemDescription("Bucket of Water");
        backpackItem.add(water1);
        
        Item dart2 = new Item();
        dart2.setItemDescription("Tranquilizer Dart");
        backpackItem.add(dart2);

        Item potion2 = new Item();
        potion2.setItemDescription("Healing Potion");
        backpackItem.add(potion2);

        Item water2 = new Item();
        water2.setItemDescription("Bucket of Water");
        backpackItem.add(water2);

        return backpackItem;

    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //TODO Remove items from the backpack list when used in a danger
    public int removeItemFromBackpack(List<Item> backpack, String itemDescription) throws BackpackControlException {

        for (Item item : backpack) {
            if (item.getItemDescription().equals(itemDescription)) {
                return backpack.indexOf(item);
            }
        }
        throw new BackpackControlException("Item not found in backpack.");
    }

}
