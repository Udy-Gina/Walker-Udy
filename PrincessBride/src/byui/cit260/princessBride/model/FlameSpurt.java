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
public class FlameSpurt implements Serializable {
    
    private double baseLength;
    private double baseWidth;
    private double baseHeight;
    private double answer;

    public FlameSpurt() {
    }
    

    public double getBaseLength() {
        return baseLength;
    }

    public void setBaseLength(double baseLength) {
        this.baseLength = baseLength;
    }

    public double getBaseWidth() {
        return baseWidth;
    }

    public void setBaseWidth(double baseWidth) {
        this.baseWidth = baseWidth;
    }

    public double getBaseHeight() {
        return baseHeight;
    }

    public void setBaseHeight(double baseHeight) {
        this.baseHeight = baseHeight;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.baseLength) ^ (Double.doubleToLongBits(this.baseLength) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.baseWidth) ^ (Double.doubleToLongBits(this.baseWidth) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.baseHeight) ^ (Double.doubleToLongBits(this.baseHeight) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.answer) ^ (Double.doubleToLongBits(this.answer) >>> 32));
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
        final FlameSpurt other = (FlameSpurt) obj;
        if (Double.doubleToLongBits(this.baseLength) != Double.doubleToLongBits(other.baseLength)) {
            return false;
        }
        if (Double.doubleToLongBits(this.baseWidth) != Double.doubleToLongBits(other.baseWidth)) {
            return false;
        }
        if (Double.doubleToLongBits(this.baseHeight) != Double.doubleToLongBits(other.baseHeight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.answer) != Double.doubleToLongBits(other.answer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FlameSpurt{" + "baseLength=" + baseLength + ", baseWidth=" + baseWidth + ", baseHeight=" + baseHeight + ", answer=" + answer + '}';
    }
    
  
}
