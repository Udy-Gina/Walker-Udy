/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.DangerControl;
import byui.cit260.princessBride.exceptions.DangerControlException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            ErrorView.display(this.getClass().getName(), "Oh no!  You fell in."
+"\n"
+"\n             ://////////////////           "
+"\n             #//            `//            "
+"\n             ///            //#            "
+"\n             //            ///             "
+"\n            ,//           ///              "
+"\n             //           ///              "
+"\n            ///          #//               "
+"\n            //#          //`               "
+"\n            //         '///////////        "
+"\n           ///                ///          "
+"\n           ///             :///            "
+"\n          ;///////       ////              "
+"\n               ///     `///                "
+"\n               ///    `///                 "
+"\n              ;//     ///,                 "
+"\n              //'   ///;                   "
+"\n             #//   ///'                    "
+"\n             ///  ///                      "
+"\n             //, ///#                      "
+"\n            ///////                        "
+"\n           ;//////                         "
+"\n          #////                            "
+"\n         `///                              "
+"\n         ///                               "
+"\n        :/                                 "
+"\n        /                                  "

);
        }
    }

    @Override
    public String getInput() {
        
        String input = " ";  // value to be returned
        boolean validInput = false;    // initialize to not valid

        while (!validInput) {
            try {
                // loop while an invalid value is entered

                input = this.keyboard.readLine();  // get next line typed on keyboard 
            } catch (IOException ex) {
                Logger.getLogger(LightningSandView.class.getName()).log(Level.SEVERE, null, ex);
            }
            input = input.trim(); // trim off leading and trailing blanks

            try {
                Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                ErrorView.display(this.getClass().getName(), "\nInvalid: You must enter a valid number!");
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
        try {
            double actualAnswer = dc.calcLightningSand(diameter, input);
            return dc.checkLightningSand(input, actualAnswer);
        } catch (DangerControlException e)  {
            ErrorView.display(this.getClass().getName(), "\nInvalid: Your answer must be greater than zero");
        }
        
        return false;
    }
}
