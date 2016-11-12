/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.princessbride.view;

/**
 *
 * @author Gina Udy
 */
public class NonDangerView extends View {

    //TODO Complete the noDangerView - this is for spots on the map with no dangers.  Need to look into how to code this...
    //I want it to just pull the GameMenuView.  Is that done in the doAction() function?  Will try to see if it works...
    public NonDangerView() {

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

        System.out.println("\nYou get a brief reprieve...no dangers here!  Take a moment"
                + "\nto catch your breath...but don't take too long.  Dangers await!"
                + "\nWhen you are ready, please select a menu option to continue the game.");

    }

    @Override

    public boolean doAction(String selection) {

        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'V': //view map
                this.viewMap();
                break;
            case 'I': // List Inventory
                this.InventoryMenuView();
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
