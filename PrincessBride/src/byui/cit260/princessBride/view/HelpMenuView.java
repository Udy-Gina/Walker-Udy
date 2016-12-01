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
            + "\n================================="
            + "\n            HELP MENU            "
            + "\n================================="
            + "\n    M - Movement help            "
            + "\n    B - Backpack help            "
            + "\n    C - Clues                    "
            + "\n    D - Danger help              "
            + "\n    X - eXit to previous menu    "
            + "\n=================================");
}
    
    @Override
    public boolean doAction(String selection) {

        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'M':  // view movement tips 
                this.console.println("\n"
                        + "\n==========================================================================="
                        + "\n                              MOVEMENT HELP                                "
                        + "\n==========================================================================="
                        + "\n                                                                           "
                        + "\n   In the fire swamp  you will be able  to move  north, south,  east, and  "
                        + "\n   west.   You will  not  be allowed  to move outside the confines of the  "
                        + "\n   map...you will receive an error  message if you try.   You will  enter  "
                        + "\n   the map at location 0.0, which is at the top, left-hand  corner of the  "
                        + "\n   map.  The first coordinate refers to the row you are on, which  starts  "
                        + "\n   at row zero and continues to row four.   The second coordinate  refers  "
                        + "\n   to the column you are on, which starts at column zero and continues to  "
                        + "\n   column four.   You may move in  any direction  at any time  within the  "
                        + "\n   confines of the map.  The game ends at location 4.4 (if you're lucky).  "
                        + "\n                                                                           "
                        + "\n===========================================================================");
                break;
            case 'B':  // backpack inventory information 
                this.console.println("\n"
                        + "\n==========================================================================="
                        + "\n                              BACKPACK HELP                                "
                        + "\n==========================================================================="
                        + "\n                                                                           "
                        + "\n   In the fire  swamp you  will encounter  dangers at some locations.  At  "
                        + "\n   other locations you will find items you may pick up and place in  your  "
                        + "\n   backpack.   The items may save your life.   The dangers you  face will  "
                        + "\n   require you  to calculate  math problems.   If you  guess incorrectly,  "
                        + "\n   having  the appropriate  item in your backpack  will allow you to move  "
                        + "\n   on  to the  next location.   You may choose to  pick up an  item or to  "
                        + "\n   to pick up an item or to leave it.   Once you pick up an item, it will  "
                        + "\n   no longer be available at that location.                                "
                        + "\n                                                                           "
                        + "\n   To view the  formulas for the calculations, see the  Dangers option in  "
                        + "\n   the Help Menu.                                                          "
                        + "\n                                                                           "
                        + "\n===========================================================================");
                break;
            case 'C':  // display clues 
                this.console.println("\n*** Clues ***");
                break;
            case 'D':  // display dangers 
                this.console.println("\n"
                        + "\n==========================================================================="
                        + "\n                               DANGER HELP                                 "
                        + "\n==========================================================================="
                        + "\n                                                                           "
                        + "\n   You will  face three  types of  dangers in the  Fire Swamp, which will  "
                        + "\n   require you to solve  various math  equations.  The formulas for those  "
                        + "\n   equations are as follows:                                               "
                        + "\n                                                                           "
                        + "\n   Rodent of Unusual Size (R.O.U.S.):                                      "
                        + "\n                                                                           "
                        + "\n   (((length * 12) / 2) + 6) / 12                                          "
                        + "\n                                                                           "
                        + "\n                                                                           "
                        + "\n   Lightning Sand:                                                         "
                        + "\n                                                                           "
                        + "\n   (pi * diameter) / 2                                                     "
                        + "\n                                                                           "
                        + "\n                                                                           "
                        + "\n   Flame Spurt:                                                            "
                        + "\n                                                                           "
                        + "\n   (length * width * height) / 3                                           "
                        + "\n                                                                           "
                        + "\n===========================================================================");
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
