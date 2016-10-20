/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

/**
 *
 * @author Gina Udy
 */
public class DangerControl {

    public double calcLightningSand(double diameter) {

        if (diameter <= 0 || diameter > 20) {    // if diameter is less than or equal to zero, or greater than 20, throw error 
            return -1;
        }

        double diameterCalc = diameter * Math.PI / 2;
        return diameterCalc;

    }

    public double checkLightningSand(double playerDistance, double diameterCalc) {

        if (playerDistance != diameterCalc) {    // if distance does not equal 1/2 circumference, throw error 
            return -1;
        }

        return 1;
    }

    public double calcRodentSize(double rodentLength) {

        if (rodentLength <= 0 ||  rodentLength >= 10) {
            return -1;
        }

        double heightCalc = (((rodentLength * 12) / 2) + 6) / 12;
        return heightCalc;
    }

    public double checkRodentSize(double playerHeight, double heightCalc) {

        if (playerHeight != heightCalc) {
            return -1;
        }

        return 1;
    }

public double calcFlameSpurt (double length, double width, double height) {
    if (volume <=0 || volume> 50){
        return -1;
               }
    else{
            return 1;
}
    double volume = (length * width * height);
    return volume;
    
}
