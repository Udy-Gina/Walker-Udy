/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import princessBride.PrincessBride;

/**
 *
 * @author Gina Udy
 */
public abstract class View implements InterfaceView {

    private String displayMessage;

    protected final BufferedReader keyboard = PrincessBride.getInFile();
    protected final PrintWriter console = PrincessBride.getOutFile();

    public View() {
    }

    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display() {  // displays start program view

        boolean done = false;

        do {
            this.console.println("\n" + this.displayMessage);

            String value = this.getInput();

            done = this.doAction(value);
        } while (!done);
    }

    /**
     *
     * @return
     */
    @Override
    public String getInput() {

        String input = " ";  // value to be returned 
        boolean validInput = false;  // initialize to not valid 

        while (!validInput) {
            try {
                // loop while an invalid value is enter

                input = this.keyboard.readLine();  // get next line typed on keyboard 
                input = input.trim();  // trim off leading and trailing blanks 
                input = input.toUpperCase();  // converts input to upper case 

            } catch (Exception e) {
                throw new RuntimeException("Error reading input");
            }

            if (input.length() < 1) {  // value is blank 
                ErrorView.display(this.getClass().getName(), "\nInvalid value: You must enter a character.");
            } else {
                validInput = true;
            }
        }

        return input;  // return the value entered
    }
}
