/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.princessbride.view;

import java.util.Scanner;

/**
 *
 * @author Gina Udy
 */
class InventoryMenuView {
    
    private String menu = "\n"
            + "\n--------------------------------------"
            + "\nINVENTORY MENU"
            + "\n--------------------------------------"
            + "\nR - Rope"
            + "\nW - Water"
            + "\nP - Healing Potion"
            + "\nX - Exit to Previous Menu"
            + "\n--------------------------------------";

    public void displayInventoryMenuView() {  // displays start program view

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
            case 'R':  // view movement tips 
                System.out.println("\n*** Rope ***");
                break;
            case 'W':  // inventory information 
                System.out.println("\n*** Water ***");
                break;
            case 'P':  // display clues 
                System.out.println("\n*** Healing Potion ***");
                break;
            case 'X':  // exit to the main menu 
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again***");
                break;
        }

        return false;
    }

}
