/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessbride.view;

import byui.cit260.princessBride.control.GameControl;
import byui.cit260.princessBride.control.MovementControl;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.LocationType;
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
                this.showInventory();
                break;
            case 'T': // Take Item
                this.takeItemFromLocation();
                break;
            case 'U': //Use Item
                this.useItemInInventory();
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

        System.out.println("\n ***********************************************"
                + "\n"
                + "\n                 Fire Swamp Map                 "
                + "\n"
                + "\n");

        for (int row = 0; row < Map.ROWS; row++) {
            for (int col = 0; col < Map.COLUMNS; col++) {
                char locationType = map.getLocationAt(row, col).getLocationType().toString().charAt(0);
                System.out.print("\t" + locationType);
                if (map.getLocationAt(row, col).getItem() != null) {
                    System.out.print(map.getLocationAt(row, col).getItem().getItemName().charAt(0));
                }

                System.out.print("  ");

            }

            System.out.println("");
        }

        System.out.println("\n"
                + "\n ***********************************************");
        
        Location a = PrincessBride.getCurrentGame().getPlayer().getLocation();
        System.out.println("\nPlayer is at:  " + a.getRow() + ", " + a.getCol());

    }

    private void showInventory() {
        GameControl gc = new GameControl();
        gc.displayInventory();
    }

    private void takeItemFromLocation() {
        Location currentLocation = PrincessBride.getPlayer().getLocation();
        
        if(currentLocation.getItem() !=null) {
                PrincessBride.getPlayer().addItemToInventory(currentLocation.getItem());
                System.out.println("you found a " + currentLocation.getItem().getItemName());
                currentLocation.setItem(null);
        }   else{
           
                System.out.println("there is nothing here");
                  
        }
    }

    private void useItemInInventory() {
        GameControl gc = new GameControl();
        gc.removeItemFromInventory();
    }

    private void moveNorth() {
        System.out.println("***moveNorth function called****");
    }

    private void moveEast() {
        System.out.println("***moveEast function called ****");
    }

    private void moveSouth() {
        MovementControl mc = new MovementControl();
        boolean success = mc.moveSouth();
        if (!success) {
            System.out.println("You are unable to move further South!");
        }
        determineNextView();
    }

    private void moveWest() {
        MovementControl mc = new MovementControl();
        boolean success = mc.moveWest();
        if (!success) {
            System.out.println("You are unable to move further West!");
        }
        determineNextView();
    }

    /**
     * Determines next view based on player location
     */
    private void determineNextView() {
        Location currentLocation = PrincessBride.getCurrentGame().getPlayer().getLocation();

        if (currentLocation.getLocationType() == LocationType.FLAMESPURT && !currentLocation.getVisited()) {
            FlameSpurtView fsv = new FlameSpurtView();
            fsv.display();
            currentLocation.setVisited(true);
        }
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
