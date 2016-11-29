/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

/**
 *
 * @author Gina Udy
 */
public class HelpMenuView extends View { 
    
    public HelpMenuView() {

    super ("\n"
            + "\n--------------------------------------"
            + "\nHELP MENU"
            + "\n--------------------------------------"
            + "\nM - Movement information"
            + "\nI - backpack Inventory"
            + "\nC - Clues"
            + "\nD - Dangers"
            + "\nX - eXit to previous menu"
            + "\n--------------------------------------");
}
    
    @Override
    public boolean doAction(String selection) {

        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'M':  // view movement tips 
                this.console.println("\n***************************************************************************"
                        + "\n*                                                                         *"
                        + "\n*  In the fire swamp you will be able to move north, south,               *"
                        + "\n*  east, and west.  You will not be allowed to move outside               *"
                        + "\n*  the confines of the map...you will receive an error message            *"
                        + "\n*  if you try.  You will enter the map at location 0.0, which             *"
                        + "\n*  is the top, left-hand corner of the map.  The first coordinate         *"
                        + "\n*  represents the row you are on, which starts at row zero and            *"
                        + "\n*  continues to row four.  The second coordinate represents the           *"
                        + "\n*  column you are on, which starts at column zero and continues           *"
                        + "\n*  to column four.  You may move in any direction at any time             *"
                        + "\n*  within the confines of the map.  The game ends at location             *"
                        + "\n*  4.4 (if you make it that far, that is!)                                *"
                        + "\n*                                                                         *"
                        + "\n***************************************************************************");
                break;
            case 'I':  // backpack inventory information 
                this.console.println("\n***************************************************************************"
                        + "\n*                                                                         *"
                        + "\n*  In the fire swamp you will encounter dangers at some                   *"
                        + "\n*  locations.  At other locations you will find items you                 *"
                        + "\n*  may pick up and place in your backpack.  The items may                 *"
                        + "\n*  save your life.  The dangers you face will require you                 *"
                        + "\n*  to calculate math problems.  If you guess incorrectly,                 *"
                        + "\n*  having the appropriate item in your backpack will allow                *"
                        + "\n*  you to continue on to the next location.  You may choose               *"
                        + "\n*  to pick up an item or to leave it.  Once you pick up an                *"
                        + "\n*  item, it will no longer be available at that location.                 *"
                        + "\n*                                                                         *"
                        + "\n*  To view the formulas for the calculations, see the Dangers             *"
                        + "\n*  option in the Help Menu.                                               *"
                        + "\n*                                                                         *"
                        + "\n***************************************************************************");
                break;
            case 'C':  // display clues 
                this.console.println("\n*** Clues ***");
                break;
            case 'D':  // display dangers 
                this.console.println("\n***************************************************************************"
                        + "\n*"
                        + "\n* The dangers you will face in this game are: "
                        + "\n*"
                        + "\n* Rodent of Unusual Size (R.O.U.S.)"
                        + "\n*"
                        + "\n* You will need to perform a calculation to pass"
                        + "\n* through this danger safely.  The formula for the"
                        + "\n* calculation is:"
                        + "\n*"
                        + "\n* (((length * 12) / 2) + 6) / 12"
                        + "\n*"
                        + "\n*"
                        + "\n* Lightning Sand"
                        + "\n*"
                        + "\n* You will need to perform a calculation to pass"
                        + "\n* through this danger safely.  The formula for the"
                        + "\n* calculation is:"
                        + "\n*"
                        + "\n* (pi * diameter) / 2"
                        + "\n*"
                        + "\n*"
                        + "\n* Flame Spurt"
                        + "\n*"
                        + "\n* You will need to perform a calculation to pass"
                        + "\n* through this danger safely.  The formula for the"
                        + "\n* calculation is:"
                        + "\n*"
                        + "\n* (length * width * height) / 3"
                        + "\n*"
                        + "\n***************************************************************************");
                break;
            case 'X':  // exit to the main menu 
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again***");
                break;
        }

        return false;
    }

    }
