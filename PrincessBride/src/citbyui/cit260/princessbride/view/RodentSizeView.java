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
 * @author lisawalker
 */
public class RodentSizeView extends View {

    private double length;

    @Override
    public void display() {
        //random number generated
        Random r = new Random();
        length = r.nextInt(5) + 5;

        // display problem
        System.out.println("\nAGH!  A Rodent of Unusual Size.  Your path is blocked."
                + "\nYou must calculate how high must jump to clear this "
                + "\ngiant rodent.  You must have six inches of clearance."
                + "\nPlease answer carefully...you could get injured and die!"
                + "\n"
                + "\nThe length  of the rodent is " + length + "ft.  You know ROUS's are"
                + "\nhalf as tall as they are long.  How high must you jump?");
        //get input
        String input = getInput();

        //validate input
        boolean isCorrect = doAction(input);

        // present results
        if (isCorrect) {
            System.out.println("Good job!  You jumped over the vile rodent!");
        } else {
            //TODO  Check if player has a healing potion  and then use it
            System.out.println("Oh no!  You tripped on the smelly  rodent.  The nasty thing bit you!");
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
        double actualAnswer = dc.calcRodentSize(length, input);

        return (int) actualAnswer == (int) input;
    }
}
