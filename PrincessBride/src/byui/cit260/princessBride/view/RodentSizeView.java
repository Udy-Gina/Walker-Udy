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
public class RodentSizeView extends View {

    private double length;

    @Override
    public void display() {
        //random number generated
        Random r = new Random();
        length = r.nextInt(5) + 5;

        // display problem
        this.console.println("\n"
                + "\n==========================================================================="
                + "\n                  AGH!!! IT'S A RODENT OF UNUSUAL SIZE!!!                  "
                + "\n==========================================================================="
                + "\n                                                                           "
                + "\n   You must  jump  over the R.O.U.S. with 6 inches of  clearance in order  "
                + "\n   to pass through safely.                                                 "
                + "\n                                                                           "
                + "\n   The rodent is " + length + "feet long. You know R.O.U.S.'s are half as  "
                + "\n   tall as they are long.  How high must you jump?                         "
                + "\n                                                                           "
                + "\n===========================================================================");

        //get input
        String input = getInput();

        //validate input
        boolean isCorrect = doAction(input);

        // present results
        if (isCorrect) {
            this.console.println("Good job!  You jumped over the vile rodent!");
        } else {
            //TODO  Check if player has a healing potion  and then use it
            ErrorView.display(this.getClass().getName(), "You guessed wrong!  Prepare to be eaten!!!"
+"\n    `                                      "
+"\n  @@@@ .                              @@@@. "
+"\n #'   @@                            .@`   @ "
+"\n @     @@@`         `,.           .@@:    #`"
+"\n @      @ #@@@ . .@@@@@ .#@@@@# . .@@@,.@     #`"
+"\n #'     @:   `@@`          '@ .    @      @ "
+"\n  @#     @   .@               ;@  ;#    `@. "
+"\n    .@    @`@ .                  @`@    #@   "
+"\n     @@  .@;                    @@  ,@'    "
+"\n      :@@@@                      @@@@      "
+"\n         @                       ';        "
+"\n        ''                        @        "
+"\n        @                          .,       "
+"\n        @                          @       "
+"\n       ;;                          @       "
+"\n       @                           @       "
+"\n       @                           @       "
+"\n       @                           @       "
+"\n       @    @@#             `@@ .   #`      "
+"\n       @   @` @             @  @   @       "
+"\n       @   @` @             @  @   @       "
+"\n       #.   @@#              @@ .   @       "
+"\n       ,#                          @       "
+"\n        @                         : .       "
+"\n        @                         @        "
+"\n        ;'                        @        "
+"\n         @                        .;        "
+"\n          .;                      @         "
+"\n          @                     ' .         "
+"\n           .#                    @          "
+"\n           @                   @`          "
+"\n            @                 ;@           "
+"\n .@@@#,      ;@       ``      .@      .'@@@@"
+"\n    .'@@@@@;` .#    @@#@@,    @ :#@@@@ .,    "
+"\n           :@@@@@ .,@    @;@@@@@'.          "
+"\n             .;@@@@@   `@@@@',             "
+"\n     `;#@@@@@#:`,@.@`  @ @@ , .@@@@@@'.     "
+"\n @@@@#;`          @@@;@@@.          : .@@@@ "
+"\n                    '@#.                   ");
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
                Logger.getLogger(RodentSizeView.class.getName()).log(Level.SEVERE, null, ex);
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
            double actualAnswer = dc.calcRodentSize(length, input);
            return dc.checkRodentSize(input, actualAnswer);
        } catch (DangerControlException e) {
            ErrorView.display(this.getClass().getName(), "\nInvalid:  Your answer must be greater than zero");
        }
        return true;
    }
}
