/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.DangerControl;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lisawalker
 */
public class LightningSandView extends View {

    private double diameter;

    @Override
    public void display() {
        //random number generated
        Random r = new Random();
        diameter = r.nextInt(5) + 5;

        // display problem
        this.console.println("Uh-oh, the dreaded lightning sand.  This is terrible"
                + "\nIf you don't think quickly, you will sink to your death."
                + "\n"
                + "\nThe diameter of the sand pit is " + diameter + "ft.  How far"
                + "\nmust you walk around the lightning sand to get to safety?"); 
                
        //get input
        String input = getInput();

        //validate input
        boolean isCorrect = doAction(input);

        // present results
        if (isCorrect) {
            this.console.println("Good job!  You made it across!");
        } else {
            //TODO  Check if player has a rope and then use it
            this.console.println("Oh no!  You fell in.");
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
                ErrorView.display("\nInvalid:  You must enter a number!");
            }
        }
            return input; // return the value entered
    }   

    @Override
    public boolean doAction(String value){
        
        // convert string input into double
        double input = Double.parseDouble(value);
        
        // create appropriate controller and evaluate answer
        DangerControl dc = new DangerControl();
        
        //return answer
        double actualAnswer = dc.calcLightningSand(diameter, input);

        return (int) actualAnswer == (int) input;
    }
}

