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
public class LightningSand implements Serializable {
    
    //class instance variables 
    private int distance;
    private double calculation; 
    private String response; 

    public LightningSand() {
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getCalculation() {
        return calculation;
    }

    public void setCalculation(double calculation) {
        this.calculation = calculation;
    }
    
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.distance;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.calculation) ^ (Double.doubleToLongBits(this.calculation) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.response);
        return hash;
    }

    @Override
    public String toString() {
        return "LightningSand{" + "distance=" + distance + ", calculation=" + calculation + ", response=" + response + '}';
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
        final LightningSand other = (LightningSand) obj;
        if (this.distance != other.distance) {
            return false;
        }
        if (Double.doubleToLongBits(this.calculation) != Double.doubleToLongBits(other.calculation)) {
            return false;
        }
        if (!Objects.equals(this.response, other.response)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
