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
public class InventoryMenuView extends View {

    public InventoryMenuView() {
    
    super ("\n"
            + "\n--------------------------------------"
            + "\nINVENTORY MENU"
            + "\n--------------------------------------"
            + "\nR - Rope"
            + "\nW - Water"
            + "\nP - Healing Potion"
            + "\nX - Exit to Previous Menu"
            + "\n--------------------------------------");
}
    
    @Override
    public boolean doAction(String selection) {

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













