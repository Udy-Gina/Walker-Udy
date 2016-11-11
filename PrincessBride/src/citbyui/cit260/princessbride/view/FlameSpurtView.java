/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citbyui.cit260.princessbride.view;

import byui.cit260.princessBride.control.DangerControl;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gina Udy
 */
public class FlameSpurtView extends View {
    
    private double length; 
    private double height; 
    private double width;

    @Override
    public void display() {
        //random number generated
        Random r = new Random();
        length = r.nextInt(5) + 5;
        height = r.nextInt(5) + 5;
        width = r.nextInt(5) + 5;
        

        // display problem
        System.out.println("Beware the Flame Spurt!  Your path is blocked."
                + "You must calculate the volume of a pyramid to safely"
                + "\ncross this danger.  Answer incorrectly and you with perish!"
                + "\n"
                + "\nThe pyramid's dimensions are: Length = " + length + "; Height = " 
                + "\n" + height + "; Width = " + width + ".  What is the volume?");
        //get input
        String input = getInput();

        //validate input
        boolean isCorrect = doAction(input);

        // present results
        if (isCorrect) {
            System.out.println("You are correct!  You may continue on your journey");
        } else {
            //TODO  Check if player has a healing potion  and then use it
            System.out.println("You are incorrect!  You will now perish by fire!");
        }
    }

    @Override
    public String getInput() {
        Scanner in = new Scanner(System.in); // get input from keyboard
        String input = " ";  // value to be returned
        boolean validInput = false;    // initialize to not valid

        while (!validInput) { // loop while an invalid value is entered

            input = in.nextLine(); //  get next line typed
            input = input.trim(); // trim off leading and trailing blanks

            try {
                Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("\n Invalid:  You must enter a number! ");
            }
        }
        return input; // return the value entered
    }

    @Override
    public boolean doAction(String value) {
        // convert string input into double
        double input = Double.parseDouble(value);
        // create appropriate controller and evaluate answer
        DangerControl dc = new DangerControl();
        //return answer
        double actualAnswer = dc.calcFlameSpurt(length);

        return (int) actualAnswer == (int) input;
    }
    
}
