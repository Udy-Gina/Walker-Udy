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
                + "\nV - View map"
                + "\nI - backpack Inventory"
                + "\nT - Take item"
                + "\nU - Use item"
                + "\nN - move North"
                + "\nE - move East"
                + "\nS - move South"
                + "\nW - move West"
                + "\nG - save Game"
                + "\nH - Help menu"
                + "\nL - Look around"
                + "\nB - go Back"
                + "\nX - eXit to main menu"
                + "\n--------------------------------------");
    }

    @Override
    public boolean doAction(String selection) {

        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'V': //View map
                this.viewMap();
                break;
            case 'I': // List Backpack  Inventory
                this.showBackpack();
                break;
            case 'T': // Take Item
                this.takeItemFromLocation();
                break;
            case 'U': //Use Item
                this.useItemInBackpack();
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
                    System.out.print(map.getLocationAt(row, col).getItem().getItemDescription().charAt(0));
                }

                System.out.print("  ");

            }

            System.out.println("");
        }

        System.out.println("\n"
                + "\n ***********************************************");

        Location currentLocation = PrincessBride.getCurrentGame().getPlayer().getLocation();
        System.out.println("\nYou are at location " + currentLocation.getRow() + ", " + currentLocation.getCol() + ".");
    }

    // Show the player what they have in their backpack
    private void showBackpack() {
        GameControl gc = new GameControl();
        gc.displayBackpack();
    }
    
    // Pick up an item and put it in backpack
    private void takeItemFromLocation() {
        GameControl gc = new GameControl();
        gc.addItemToBackpack();
    }

    // Use an item from backpack to make it through a danger safely
    private void useItemInBackpack() {
        GameControl gc = new GameControl();
        gc.removeItemFromBackpack();
    }

    private void moveNorth() {
        MovementControl mc = new MovementControl();
        boolean success = mc.moveNorth();
        if (!success) {
            System.out.println("You are unable to move further North!");
        }
        determineNextView();
    }

    private void moveEast() {
        MovementControl mc = new MovementControl();
        boolean success = mc.moveEast();
        if (!success) {
            System.out.println("You are unable to move further East!");
        }
        determineNextView();
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

    // Determines the next view based on the player's location
    private void determineNextView() {
        Location currentLocation = PrincessBride.getCurrentGame().getPlayer().getLocation();

        if (currentLocation.getLocationType() == LocationType.FLAMESPURT && !currentLocation.getVisited()) {
            FlameSpurtView fsv = new FlameSpurtView();
            fsv.display();
            currentLocation.setVisited(true);
        } else if (currentLocation.getLocationType() == LocationType.ROUS && !currentLocation.getVisited()) {
            RodentSizeView rsv = new RodentSizeView();
            rsv.display();
            currentLocation.setVisited(true);
        } else if (currentLocation.getLocationType() == LocationType.LIGHTNINGSAND && !currentLocation.getVisited()) {
            LightningSandView lsv = new LightningSandView();
            lsv.display();
            currentLocation.setVisited(true);
        } else if (currentLocation.getLocationType() == LocationType.NONE && !currentLocation.getVisited()) {
            System.out.println("\nThere is nothing here.");
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
