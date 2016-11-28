/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author lisawalker
 */
public class Map implements Serializable {

    //class instance variables
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;
    private Location[][] matrix = new Location[ROWS][COLUMNS];
    
    //private Location mapEntrance;
    //private Location mapExit; 
    //if used, need to do getters & setters
    
    public Map() { 
    }
    
                
    public void init() {

        Random rand = new Random();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                int randLocation = rand.nextInt(LocationType.values().length);

                Location location = new Location();
                location.setCol(col);
                location.setRow(row);
                location.setVisited(false);

                location.setLocationType(LocationType.values()[randLocation]);

                matrix[row][col] = location;
            }

        }
    }

    public Location getLocationAt(int row, int col)  {
        return matrix[row][col];
    }

    public void setMatrix(Location[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Arrays.deepHashCode(this.matrix);
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
        return Arrays.deepEquals(this.matrix, other.matrix);
    }

    @Override
    public String toString() {
        return "Map{" + "matrix=" + matrix + '}';
    }

}
