/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;

import java.io.Serializable;

/**
 *
 * @author lisawalker
 */
public class Map implements Serializable {
  
    //class instance variables
            private double rowNumber;
            private double columnNumber;

    public Map() {
    }
            
            

    public double getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(double rowNumber) {
        this.rowNumber = rowNumber;
    }

    public double getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(double columnNumber) {
        this.columnNumber = columnNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.rowNumber) ^ (Double.doubleToLongBits(this.rowNumber) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.columnNumber) ^ (Double.doubleToLongBits(this.columnNumber) >>> 32));
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
        final Map other = (Map) obj;
        if (Double.doubleToLongBits(this.rowNumber) != Double.doubleToLongBits(other.rowNumber)) {
            return false;
        }
        if (Double.doubleToLongBits(this.columnNumber) != Double.doubleToLongBits(other.columnNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "rowNumber=" + rowNumber + ", columnNumber=" + columnNumber + '}';
    }
            
            
    
}
