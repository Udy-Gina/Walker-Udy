/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.princessbride.view;

import byui.cit260.princessBride.control.InventoryControl;
import byui.cit260.princessBride.model.Map;
import princessbride.PrincessBride;

/**
 *
 * @author Lisa Walker
 */
public class GameMenuView extends View {

    public GameMenuView() {

        super("\n"
                + "\n--------------------------------------"
                + "\n GAME MENU"
                + "\n--------------------------------------"
                + "\nV - View Map"
                + "\nI - Inventory List"
                + "\nT - Take Item"
                + "\nU - Use Item"
                + "\nN - Move North"
                + "\nE - Move East"
                + "\nS - Move South"
                + "\nW - Move West"
                + "\nG - Save Game"
                + "\nH - Help"
                + "\nL - Look Around"
                + "\nB - Back"
                + "\nX - Exit to Main Menu"
                + "\n--------------------------------------");
    }

    @Override
    public boolean doAction(String selection) {

        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'V': //view map
                this.viewMap();
                break;
            case 'I': // List Inventory
                this.createInventory();
                break;
            case 'T': // Take Item
                this.takeItem();
                break;
            case 'U': //Use Item
                this.useItem();
                break;
            case 'N': // move North
                this.moveNorth();
                break;
            case 'E':// move East
                this.moveEast();
                break;
            case 'S': // moveSouth
                this.moveSouth();
                break;
            case 'W'://moveWest
                this.moveWest();
                break;
            case 'L': // look around
                this.lookAround();
                break;
            case 'B': // go Back
                this.goBack();
                break;
            case 'H'://ask for Help
                this.HelpMenuView();
                ;
                break;
            case 'X':// exit Game
                return true;
            case 'G':// save Game
                this.saveGame();
                break;
            default:
                System.out.println("\n*** Invalid Selection *** Please Try Again ***");
        }
        return false;
    }

    private void viewMap() {
        Map map = PrincessBride.getCurrentGame().getMap();

        for (int row = 0; row < Map.ROWS; row++) {
            for (int col = 0; col < Map.COLUMNS; col++) {
                char locationType = map.getLocationAt(row, col).getLocationType().toString().charAt(0);
                System.out.print(locationType);
                if (map.getLocationAt(row, col).getItem() != null) {
                    System.out.print(map.getLocationAt(row, col).getItem().getItemName().charAt(0));
                }

                System.out.print("  ");

            }

            System.out.println("");
        }
    }

    private void createInventory() {
        System.out.println("\n***createInventory function called");
        
        InventoryControl ic = new InventoryControl(); 
        ic.createNewInventory(); 
    }

    private void takeItem() {
        System.out.println("***takeItem function called");
    }

    private void useItem() {
        System.out.println("*** useItem function called****");
    }

    private void moveNorth() {
        System.out.println("***moveNorth function called****");
        LightningSandView lsv = new LightningSandView();
        lsv.display();
    }

    private void moveEast() {
        System.out.println("***moveEast function called ****");
        FlameSpurtView fsv = new FlameSpurtView();
        fsv.display();
    }

    private void moveSouth() {
        System.out.println("*** moveSouth function called***");
        RodentSizeView rsv = new RodentSizeView();
        rsv.display();
    }

    private void moveWest() {
        determineNextView();
    }

    private void lookAround() {
        System.out.println("***lookAround function called****");
        NonDangerView ndv = new NonDangerView();
        ndv.display();
    }

    private void goBack() {
        System.out.println("***goBack function called****");
    }

    private void saveGame() {
        System.out.println("***saveGame function called****");
    }

    private void HelpMenuView() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void determineNextView() {
        System.out.println("***determineNextView function called***");
    }
}
