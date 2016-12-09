/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.BackpackControl;
import byui.cit260.princessBride.exceptions.BackpackControlException;

/**
 *
 * @author Gina Udy
 */
public final class PotionView extends View {

    @Override
    public void display() {
        
        // display problem
        this.console.println("\n"
            + "\n================================="
            + "\n  You have found a useful item.  "
            + "\n  It may save your life  if you  "
            + "\n  encounter one  of the dangers  "
            + "\n  of the fire swamp! Press T if  "
            + "\n  you want to put the  item in   "
            + "\n  your backpack.                 "
            + "\n=================================");
        
        //get input
        String input = getInput();

        //validate input
        boolean isCorrect = doAction(input);

        // present results
        if (isCorrect) {
            this.console.println("\"You now have a healing potion in your backpack.\"");
        } else {
            //TODO  Check if player has a rope and then use it
            ErrorView.display(this.getClass().getName(), " *** Not sure what this should say. ***");
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
            } catch (Exception ex) {
                ErrorView.display(this.getClass().getName(), "\nInvalid: You must enter a valid letter.");
            }
            input = input.trim(); // trim off leading and trailing blanks

            try {
                validInput = true;
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "\nInvalid: You must enter a valid selection.");
            }
        }
        return input; // return the value entered
    }
    
    @Override
    public boolean doAction(String selection) {
        
        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'P':  // Start New Game 
                BackpackControl bc = new BackpackControl();
        {
            try {
                bc.addItemToBackpack();
            } catch (BackpackControlException ex) {
                ErrorView.display(this.getClass().getName(), "\n*** Not sure what this should say. ***");
            }
        }
                break;
            case 'X':  // Load Saved Game
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again ***");
                break;
        }
       return false;
    }
}
