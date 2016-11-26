/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessbride.view;

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
            + "\nM - Movement"
            + "\nI - backpack Inventory"
            + "\nC - Clues"
            + "\nD - Dangers"
            + "\nX - Exit to Previous Menu"
            + "\n--------------------------------------");
}
    
    @Override
    public boolean doAction(String selection) {

        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'M':  // view movement tips 
                System.out.println("\n*** View movement tips ***");
                break;
            case 'I':  // backpack inventory information 
                BackpackMenuView();
                break;
            case 'C':  // display clues 
                System.out.println("\n*** Clues ***");
                break;
            case 'D':  // display dangers 
                System.out.println("\n***************************************************************************"
                        + "\n*"
                        + "\n* The dangers you will face in this game are: "
                        + "\n*"
                        + "\n* Rodent of Unusual Size (R.O.U.S.)"
                        + "\n*"
                        + "\n* Your way is blocked by an R.O.U.S.!  You must jump over the"
                        + "\n* rodent with six inches of clearance in order to pass through"
                        + "\n* the danger and continue the game.  Given the rodent's length," 
                        + "\n* you must calculate the height of your jump.  If you are correct,"
                        + "\n* you will be allowed to pass through the danger.  If you are"
                        + "\n* incorrect, you will be bitten by the rodent and only a healing"
                        + "\n* potion will save you.  You may check your backpack inventory, and"
                        + "\n* if you have a healing potion, you will be allowed to continue the game."
                        + "\n* If you don't, you will perish!"
                        + "\n*"
                        + "\n*"
                        + "\n* Lightning Sand"
                        + "\n*"
                        + "\n* Need to add this description..."
                        + "\n*"
                        + "\n*"
                        + "\n* Flame Spurt"
                        + "\n*"
                        + "\n* Need to add this description..."
                        + "\n*"
                        + "\n***************************************************************************");
                break;
            case 'X':  // exit to the main menu 
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again***");
                break;
        }

        return false;
    }

    private void BackpackMenuView() {
        BackpackMenuView backpackMenu = new BackpackMenuView();
        backpackMenu.display();
    }

  
}
