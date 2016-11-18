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
 * @author lisawalker
 */
public class Location implements Serializable {

    //class instance variables
    private String description;
    private double travelTime;
    private String displaySymbol;
    private int row;
    private int col;
    private LocationType locationType;
    private boolean visited;
    private String item;

    public Location() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public String getDisplaySymbol() {
        return displaySymbol;
    }

    public void setDisplaySymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean b) {
        this.visited = visited;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.travelTime) ^ (Double.doubleToLongBits(this.travelTime) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.displaySymbol);
        hash = 89 * hash + this.row;
        hash = 89 * hash + this.col;
        hash = 89 * hash + Objects.hashCode(this.locationType);
        hash = 89 * hash + (this.visited ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.item);
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
        final Location other = (Location) obj;
        if (Double.doubleToLongBits(this.travelTime) != Double.doubleToLongBits(other.travelTime)) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        if (this.col != other.col) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.displaySymbol, other.displaySymbol)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return this.locationType == other.locationType;
    }

    @Override
    public String toString() {
        return "Location{" + "description=" + description + ", travelTime=" + travelTime + ", displaySymbol=" + displaySymbol + ", row=" + row + ", col=" + col + ", locationType=" + locationType + ", visited=" + visited + ", item=" + item + '}';
    }

    public void setItem(Item item) {
        System.out.println("testing");
    }

}
