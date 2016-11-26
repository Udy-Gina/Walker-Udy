/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Gina Udy
 */
public class Game implements Serializable {
    
    //class instance variables
    private Player player; 
    private Map map; 
    private Item[] item;
    private Backpack[] backpack;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Item[] getItem() {
        return item;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public Backpack[] getInventory() {
        return backpack;
    }

    public void setInventory(Backpack[] backpack) {
        this.backpack = backpack;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.player);
        hash = 89 * hash + Objects.hashCode(this.map);
        hash = 89 * hash + Arrays.deepHashCode(this.item);
        hash = 89 * hash + Arrays.deepHashCode(this.backpack);
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Arrays.deepEquals(this.item, other.item)) {
            return false;
        }
        return Arrays.deepEquals(this.backpack, other.backpack);
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + player + ", map=" + map + ", item=" + item + ", backpack=" + backpack + '}';
    }

}
