/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gina Udy
 */
public class Player implements Serializable {

    //class instance variables 
    private String name;
    private String item;
    private Location location;
    private List<Item> backpack;

    public List<Item> getBackpack() {
        return backpack;
    }

    public Player() {
        backpack = new ArrayList<>();
    }

    public void addItemToBackpack(Item item) {
        backpack.add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.item);
        hash = 71 * hash + Objects.hashCode(this.location);
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return Objects.equals(this.location, other.location);
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", item=" + item + ", location=" + location + '}';
    }

}
