/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.GameControl;
import byui.cit260.princessBride.control.MovementControl;
import byui.cit260.princessBride.exceptions.GameControlException;
import byui.cit260.princessBride.exceptions.LoseException;
import byui.cit260.princessBride.exceptions.MovementControlException;
import byui.cit260.princessBride.exceptions.WinException;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.LocationType;
import byui.cit260.princessBride.model.Map;
import java.util.List;
import princessBride.PrincessBride;

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

        char charSel = selection.toUpperCase().charAt(0);
try {
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
//            case 'U': //Use Item
//                this.useItemInBackpack();
//                break;
            case 'N':
                this.moveNorth();
                break;
            case 'E':
                this: moveEast();
                break;
            case 'S':
                this.moveSouth();
                break;
            case 'W':
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
                ErrorView.display(this.getClass().getName(), "\n*** Invalid Selection *** Please Try Again ***");
        }
} catch (LoseException le){
        this.console.println("You lost to the dreaded Fire Swamp.  Try again!");
} 
catch(WinException we){
    this.console.println("Wow!  You bested the Fire Swamp.  Congratulations!");
}
        return false;
    }

    private void viewMap() {
        Map map = PrincessBride.getCurrentGame().getMap();

        this.console.println("\n ***********************************************"
                + "\n"
                + "\n                 Fire Swamp Map                 "
                + "\n"
                + "\n");

        for (int row = 0; row < Map.ROWS; row++) {
            for (int col = 0; col < Map.COLUMNS; col++) {
                char locationType = map.getLocationAt(row, col).getLocationType().toString().charAt(0);
                this.console.print("\t" + locationType);
                if (map.getLocationAt(row, col).getItem() != null) {
                    this.console.print(map.getLocationAt(row, col).getItem().getItemDescription().charAt(0));
                }

                this.console.print("  ");

            }

            this.console.println("");
        }

        this.console.println("\n"
                + "\n ***********************************************");

        Location currentLocation = PrincessBride.getCurrentGame().getPlayer().getLocation();
        this.console.println("\nYou are at location " + currentLocation.getRow() + ", " + currentLocation.getCol() + ".");
    }

    // Show the player what they have in their backpack
    private void showBackpack() {

        List<Item> currentBackpack = PrincessBride.getCurrentGame().getPlayer().getBackpack();

        try {
            GameControl gc = new GameControl();
            gc.displayBackpack();
            this.console.println("\nYou have " + "currentBackpackQuantity"
                    + " items in your backpack."
                    + "\nThe items are: "
                    + currentBackpack
                    + ".");
        } catch (GameControlException e) {
            ErrorView.display(this.getClass().getName(), "Your backpack is empty.");
        }
    }

    // Pick up an item and put it in backpack
    private void takeItemFromLocation() {

        try {
            GameControl gc = new GameControl();
            gc.addItemToBackpack();
            Location currentLocation = PrincessBride.getPlayer().getLocation();
            this.console.println("You found a "
                    + currentLocation.getItem().getItemDescription()
                    + ".  It will be added to your backpack.");
            currentLocation.setItem(null);
        } catch (GameControlException e) {
            this.console.println("\nThere is nothing here.");
        }
    }

//    // Use an item from backpack to make it through a danger safely
//    private void useItemInBackpack() {
//        GameControl gc = new GameControl();
//        gc.removeItemFromBackpack();
//    }
    private void moveNorth(){
        MovementControl mc = new MovementControl();
       try{
           mc.moveNorth();
            }
       catch(MovementControlException mce){
           ErrorView.display (this.getClass().getName(), "You cannot move further North");
       }
        determineNextView();
    }

    private void moveEast() {
        MovementControl mc = new MovementControl();
       try{
           mc.moveEast();
            }
       catch(MovementControlException mce){
           ErrorView.display (this.getClass().getName(), "You cannot move further East");
       }
        determineNextView();
    }

    private void moveSouth() {
        MovementControl mc = new MovementControl();
   try{
           mc.moveSouth();
            }
       catch(MovementControlException mce){
           ErrorView.display (this.getClass().getName(), "You cannot move further South");
       }
        determineNextView();
    }

    private void moveWest() {
        MovementControl mc = new MovementControl();
       try{
           mc.moveWest();
            }
       catch(MovementControlException mce){
           ErrorView.display (this.getClass().getName(), "You cannot move further West");
       }
        determineNextView();
    }

    // Determines the next view based on the player's location
    private void determineNextView() {
        Location currentLocation = PrincessBride.getCurrentGame().getPlayer().getLocation();

        try {

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
                this.console.println("\nThere is nothing here.");
                currentLocation.setVisited(true);
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error on input");
        }

    }

    private void lookAround() {
        this.console.println("***lookAround function called****");
    }

    private void goBack() {
        this.console.println("***goBack function called****");
    }

    private void saveGame() {
        this.console.println("***saveGame function called****");
    }

    private void HelpMenuView() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }
}
