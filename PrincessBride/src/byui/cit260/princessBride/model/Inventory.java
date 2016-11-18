/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Gina Udy
 */
public class Inventory implements Serializable {
    
    private String item;
    private InventoryType inventoryType;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public InventoryType getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(InventoryType inventoryType) {
        this.inventoryType = inventoryType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.item);
        hash = 53 * hash + Objects.hashCode(this.inventoryType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inventory other = (Inventory) obj;
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return this.inventoryType == other.inventoryType;
    }

    @Override
    public String toString() {
        return "Inventory{" + "item=" + item + ", inventoryType=" + inventoryType + '}';
    }

}




