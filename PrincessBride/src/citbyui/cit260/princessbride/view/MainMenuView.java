/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.princessbride.view;

import byui.cit260.princessBride.control.GameControl;
import java.util.Scanner;
import princessbride.PrincessBride;

/**
 *
 * @author Gina Udy
 */
public class MainMenuView {

    private String menu = "\n"
            + "\n--------------------------------------"
            + "\nMAIN MENU"
            + "\n--------------------------------------"
            + "\nN - Start new game"
            + "\nG - Get and start saved game"
            + "\nH - Help menu"
            + "\nS - Save game"
            + "\nQ - Quit"
            + "\n--------------------------------------";

    public void displayMainMenuView() {  // displays start program view

        boolean done = false;

        do {
            System.out.println("\n" + this.menu);

            String value = this.getMenuOption();

            done = this.doAction(value);
        } while (!done);
    }

    private String getMenuOption() {

        Scanner in = new Scanner(System.in);  // get infile for keyboard 
        String input = " ";  // value to be returned 
        boolean validInput = false;  // initialize to not valid 

        while (!validInput) {  // loop while an invalid value is enter 

            input = in.nextLine();  // get next line typed on keyboard 
            input = input.trim();  // trim off leading and trailing blanks 
            input = input.toUpperCase();  // converts input to upper case

            if (input.length() < 1) {  // value is blank 
                System.out.println("\nInvalid value: You must enter a character.");
            } else {
                validInput = true;
            }
        }

        return input;  // return the value entered
    }

    private boolean doAction(String selection) {

        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'N':  // create and start a new game 
                startNewGame();
                break;
            case 'G':  // get and play an existing game 
                startExistingGame();
                break;
            case 'H':  // display help menu 
                HelpMenuView();
                break;
            case 'S':  // save the current game 
                saveGame();
                break;
            case 'Q':  // quit the current game 
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again***");
                break;
        }

        return false;
    }

    private void startNewGame() {
        // create and start a new game 
        GameControl.createNewGame(PrincessBride.getPlayer());

        // display the game menu 
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayGameMenuView();
    }

    private void startExistingGame() {
        System.out.println("\n*** startExistingGame function called***");
    }

    //private void displayHelpMenu() {
    // display the help menu 
    //  HelpMenuView helpMenu = new HelpMenuView();
    //helpMenu.displayHelpMenu();
    //}
    private void saveGame() {
        System.out.println("\n*** saveGame function called***");
    }

    private void HelpMenuView() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayHelpMenuView();
    }

}
