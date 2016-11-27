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
public class BackpackMenuView extends View {

    public BackpackMenuView() {
    this.console.println("\n *** BackbackMenuView() function called *** ");
    }
    
    @Override
    public void display() {
        this.console.println("\n *** BackpackMenuView display() function called *** ");
    }

    @Override
    public boolean doAction(String value) {
        this.console.println("\n *** BackpackMenuView doAction() function called *** ");
        return false;
    }
}
