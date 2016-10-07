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
public class Game implements Serializable {
    
    //class instance variables
    private double totalTime; 
    private String getItem; 
    private double getMap; 
    private double saveGame; 
    private double loadGame; 

    public Game() {
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public String getGetItem() {
        return getItem;
    }

    public void setGetItem(String getItem) {
        this.getItem = getItem;
    }

    public double getGetMap() {
        return getMap;
    }

    public void setGetMap(double getMap) {
        this.getMap = getMap;
    }

    public double getSaveGame() {
        return saveGame;
    }

    public void setSaveGame(double saveGame) {
        this.saveGame = saveGame;
    }

    public double getLoadGame() {
        return loadGame;
    }

    public void setLoadGame(double loadGame) {
        this.loadGame = loadGame;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.getItem);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.getMap) ^ (Double.doubleToLongBits(this.getMap) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.saveGame) ^ (Double.doubleToLongBits(this.saveGame) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.loadGame) ^ (Double.doubleToLongBits(this.loadGame) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + ", getItem=" + getItem + ", getMap=" + getMap + ", saveGame=" + saveGame + ", loadGame=" + loadGame + '}';
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
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.getMap) != Double.doubleToLongBits(other.getMap)) {
            return false;
        }
        if (Double.doubleToLongBits(this.saveGame) != Double.doubleToLongBits(other.saveGame)) {
            return false;
        }
        if (Double.doubleToLongBits(this.loadGame) != Double.doubleToLongBits(other.loadGame)) {
            return false;
        }
        return Objects.equals(this.getItem, other.getItem);
    }
    
    
    
}
