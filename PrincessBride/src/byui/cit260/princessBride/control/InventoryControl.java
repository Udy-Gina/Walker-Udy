/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Inventory;
import byui.cit260.princessBride.model.Item;
import java.io.Serializable;
import princessbride.PrincessBride;

/**
 *
 * @author Gina Udy & Lisa Walker
 */
public class InventoryControl implements Serializable {

    private String item;
    private InventoryType inventoryType;

    public void createInventory(Item item) {

        Inventory currentInventory = new Inventory();

        currentInventory.setInventory(Inventory);

        PrincessBride.setCurrentInventory(currentInventory);

    }

}
