/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.princessbride.view;

/**
 *
 * @author Lisa Walker
 */
public class GameMenuView extends View {

    public GameMenuView() {
    
    super ("\n"
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
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); // convert choice to upper case
        char charSel = choice.charAt(0);

        switch (choice) {
            case "V": //view map
                this.viewMap();
                break;
            case "I": // List Inventory
                this.InventoryMenuView();
                break;
            case "T": // Take Item
                this.takeItem();
                break;
            case "U": //Use Item
                this.useItem();
                break;
            case "N": // move North
                this.moveNorth();
                break;
            case "E":// move East
                this.moveEast();
                break;
            case "S": // moveSouth
                this.moveSouth();
                break;
            case "W"://moveWest
                this.moveWest();
                break;
            case "L": // look around
                this.lookAround();
                break;
            case "B": // go Back
                this.goBack();
                break;
            case "H"://ask for Help
                this.HelpMenuView();;
                break;
            case "X":// exit Game
                return true;
            case "G":// save Game
                this.saveGame();
                break;
            default:
                System.out.println("\n*** Invalid Selection *** Please Try Again ***");
        }
        return false;
    }

    private void viewMap() {
        System.out.println("This is a 5 x 5 grid");
    }

    private void InventoryMenuView() {
        InventoryMenuView inventoryMenu = new InventoryMenuView();
        inventoryMenu.display();
    }

    private void takeItem() {
        System.out.println("***takeItem function called");
    }

    private void useItem() {
        System.out.println("*** useItem function called****");
    }

    private void moveNorth() {
        System.out.println("***moveNorth function called****");
    }

    private void moveEast() {
        System.out.println("***moveEast function called ****");
    }

    private void moveSouth() {
        System.out.println("*** moveSouth function called***");
    }

    private void moveWest() {
        System.out.println("***moveWest function called****");
    }

    private void lookAround() {
        System.out.println("***lookAround function called****");
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
}
