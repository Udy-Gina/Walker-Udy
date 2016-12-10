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
public class LoseMenuView extends View {
    
    public LoseMenuView() {
    this.console.println("\n *** LoseMenuView() function called *** ");
    }
    
    @Override
    public void display() {
        this.console.println("\n *** LoseMenuView display() function called *** ");
    }

    @Override
    public boolean doAction(String value) {
        this.console.println("\n *** LoseMenuView doAction() function called *** ");
        return false;
    }
}
