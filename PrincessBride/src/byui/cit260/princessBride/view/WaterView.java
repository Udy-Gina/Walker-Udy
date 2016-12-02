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
public class WaterView extends View{
    public WaterView() {
    this.console.println("\n *** WaterView() function called *** ");
    }
    
    @Override
    public void display() {
        this.console.println("\n *** WaterView display() function called *** ");
    }

    @Override
    public boolean doAction(String value) {
        this.console.println("\n *** WaterView doAction() function called *** ");
        return false;
    }
}
