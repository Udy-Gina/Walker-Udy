/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.princessbride.view;

import byui.cit260.princessBride.control.DangerControl;
import java.util.Random;
import java.util.Scanner;
import static javax.management.Query.value;

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
        System.out.println("Uh-oh, the dreaded lightning sand.  This is terrible. "
                + "\n If you can't think quick, you will sink to your death in the dreaded sand."
                + "\nThe diameter is " + diameter + "ft.  How far must you walk around the lightning sand?");
        //get input
        String input = getInput();

        //validate input
        boolean isCorrect = doAction(input);

        // present results
        if (isCorrect) {
            System.out.println("Good job!  You made it across!");
        } else {
            //TODO  Check if player has a rope and then use it
            System.out.println("Oh No!  You fell in.");
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
    public  boolean doAction(String value){
        // convert string input into double
        double input = Double.parseDouble(value);
        // create appropriate controller and evaluate answer
        DangerControl dc = new DangerControl();
        //return answer
        double actualAnswer = dc.calcLightningSand(diameter);

        return (int) actualAnswer == (int) input;
    }
}

