/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.exceptions.DangerControlException;

/**
 *
 * @author Gina Udy
 */
public class DangerControl {

    public double calcLightningSand(double diameter, double input) throws DangerControlException {
         if(input <=0) {
             throw new DangerControlException (); }
         
        double distance = diameter * Math.PI / 2;
        
        checkLightningSand(input, distance);
        
        return distance;

    }

    public boolean checkLightningSand(double input, double distance){

        return input != distance;
    }

    public double calcRodentSize(double length, double input) throws DangerControlException {
            if(input <=0) {
                throw new DangerControlException(); }
            
        double height = (((length * 12) / 2) + 6) / 12;
        
        checkRodentSize(input, height);
        
        return height;
    }

    public boolean checkRodentSize(double input, double height) {

        return input != height;
    }

    public double calcFlameSpurt(double length, double width, double height, double input) throws DangerControlException {

        if(input <=0) {
                throw new DangerControlException(); }
        
        double volume = (height * length * width) / 3;
        
        checkFlameSpurt(input, volume);
        
        return volume;
    }

    public boolean checkFlameSpurt(double input, double volume) {

        return input != volume;
    }

}