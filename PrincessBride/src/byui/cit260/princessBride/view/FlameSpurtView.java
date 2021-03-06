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
        width = r.nextInt(5) + 5;
        height = r.nextInt(5) + 5;

        // display problem
        this.console.println("\n"
                + "\n==========================================================================="
                + "\n                         BEWARE THE FLAME SPURT!!!                         "
                + "\n==========================================================================="
                + "\n                                                                           "
                + "\n   Your path is blocked.  You must  calculate the volume of a  pyramid in  "
                + "\n   order to pass through the flame safely.  The pyramid's dimensions are:                                         "
                + "\n                                                                           "
                + "\n   The pyramid's dimensions are:                                           "
                + "\n                                                                           "
                + "\n   Length = " + length
                + "\n   Height = " + height
                + "\n   Width = " + width
                + "\n                                                                           "
                + "\n   What is the volume?                                                     "
                + "\n                                                                           "
                + "\n===========================================================================");

        //get input
        String input = getInput();

        //validate input
        boolean isCorrect = doAction(input);

        // present results
        if (isCorrect) {
            this.console.println("You are correct! You may continue on your journey");
        } else {
            //TODO  Check if player has a healing potion  and then use it
            ErrorView.display(this.getClass().getName(), "You are incorrect! You will now perish by fire!"
                    + "\n"
                    + "\n             :                                 "
                    + "\n             '      ;                          "
                    + "\n            ;'     ,;                          "
                    + "\n            ''     ''                          "
                    + "\n            ':    :;'                          "
                    + "\n                  ';;    ;                     "
                    + "\n                ;;:::;'  '' ;                  "
                    + "\n      '   ,    :;:::::;  ,, '     ,            "
                    + "\n     ';   ;;   ;::,,,::;    ;;:  ''            "
                    + "\n     ';  ;;;  ;::,,,,,::;  ;;;; :':            "
                    + "\n         ;:;, ;::,,,,,::; ;;::;;               "
                    + "\n        :;:::,::,,,,,,,::;:::::;               "
                    + "\n        ;::,::::,,,,,,,,:::,,,::;              "
                    + "\n       ,::,,,,,,,,,,,,,,,,,,,,,:::             "
                    + "\n       ::,,,,,,             ,,,,:::            "
                    + "\n       ::,,,,,     ````     ,,,,::,            "
                    + "\n       ::,,,,    ````````    ,,,::             "
                    + "\n       ;::,,    ``````````   ,,,:;             "
                    + "\n        ;::,,   ```    ```   ,::;              "
                    + "\n         ;::,,,   ``````   ,,::;               "
                    + "\n          ;::::::,,,,,,,,:::::;                "
                    + "\n            ;::::::::::::::::                  ");
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
                Logger.getLogger(FlameSpurtView.class.getName()).log(Level.SEVERE, null, ex);
            }
            input = input.trim(); // trim off leading and trailing blanks

            try {
                Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                ErrorView.display(this.getClass().getName(), "\n Invalid: You must enter a valid number! ");
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
            double actualAnswer = dc.calcFlameSpurt(length, width, height, input);
            return dc.checkFlameSpurt(input, actualAnswer);
        } catch (DangerControlException e) {
            ErrorView.display(this.getClass().getName(), "\nInvalid: Your answer must be greater than zero.");
        }
        return false;
    }

}
