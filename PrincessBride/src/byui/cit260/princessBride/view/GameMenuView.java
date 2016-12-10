/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.BackpackControl;
import byui.cit260.princessBride.control.GameControl;
import byui.cit260.princessBride.control.MovementControl;
import byui.cit260.princessBride.exceptions.LoseException;
import byui.cit260.princessBride.exceptions.MovementControlException;
import byui.cit260.princessBride.exceptions.WinException;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.LocationType;
import byui.cit260.princessBride.model.Map;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import princessBride.PrincessBride;

/**
 *
 * @author Lisa Walker
 */
public class GameMenuView extends View {

    public GameMenuView() {

        super("\n"
                + "\n================================="
                + "\n           GAME MENU"
                + "\n================================="
                + "\n    V - View map                 "
                + "\n    B - Backpack inventory       "
                + "\n    I - Inventory report         "
                + "\n    T - Take item                "
                + "\n    U - Use item                 "
                + "\n    N - move North               "
                + "\n    E - move East                "
                + "\n    S - move South               "
                + "\n    W - move West                "
                + "\n    G - save current Game        "
                + "\n    L - Look around              "
                + "\n    H - Help menu                "
                + "\n    M - Map report               "
                + "\n    X - eXit to main menu        "
                + "\n=================================");
    }

    @Override
    public boolean doAction(String selection) {

        char charSel = selection.toUpperCase().charAt(0);
        try {
            switch (charSel) {
                case 'V': //View Map
                    this.viewMap();
                    break;
                case 'B': // List Backpack Inventory
                    this.showBackpack();
                    break;
                case 'I': // Inventory Report
                    this.showCurrentInventory();
                    break;
                case 'T': // Take Item
                    this.takeItemFromLocation();
                    break;
                //case 'U': //Use Item
                //    this.useItemInBackpack();
                //    break;
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
                case 'G':// Save Current Game
                    this.saveCurrentGame();
                    break;
                case 'L': // Look Around
                    this.lookAround();
                    break;
                case 'H':// Help Menu
                    this.HelpMenuView();
                    break;
                case 'M':// Map Report
                    this.createMapReport();
                    break;
                case 'X':// Exit Game
                    return true;
                default:
                    ErrorView.display(this.getClass().getName(), "\n*** Invalid Selection *** Please Try Again ***");
            }
        } catch (LoseException le) {
            this.console.println("You lost to the dreaded Fire Swamp.  Try again!");
        } catch (WinException we) {
            this.console.println("Wow!  You bested the Fire Swamp.  Congratulations!");
        }
        return false;
    }

    private void viewMap() {
        Map map = PrincessBride.getCurrentGame().getMap();

        this.console.println("\n"
                + "\n================================================="
                + "\n                 FIRE SWAMP MAP                  "
                + "\n================================================="
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

        this.console.println("\n=================================================");

        Location currentLocation = PrincessBride.getCurrentGame().getPlayer().getLocation();
        this.console.println("\n             YOU ARE AT LOCATION " + currentLocation.getRow() + "." + currentLocation.getCol());
    }

    // Show the player what they have in their backpack
    private void showBackpack() {

        //create BufferedReader object for input file
        List<Item> currentBackpack = PrincessBride.getCurrentGame().getPlayer().getBackpack();
        try {
            String inventoryList = "myReport.txt";
            PrintWriter out = new PrintWriter(System.out);
            
            out.println("\n\n");
            //print the name, description and quantity of each item
            out.printf("%n%-30s", "=================================");
            out.printf("%n%-30s", "      Items in your backpack     ");
            out.printf("%n%-30s", "=================================");
            for (Item item : currentBackpack) {
                out.printf("%n%-30s", item.getItemDescription());
            }
            out.printf("\n%n%n%n%50s", "Now get out there and conquer the Fire Swamp!");
            out.flush();

        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "You've gotta pick something up first silly!");
        }
    }

    // Create report to show the player which items are in their inventory
    public void showCurrentInventory() {
        //create BufferedReader object for input file
        List<Item> currentBackpack = PrincessBride.getCurrentGame().getPlayer().getBackpack();
        //------------------ new code to catch empty backpack
        if ( currentBackpack == null)
            System.out.printf("You've gotta pick something up first silly!");
        else {
            // ------------------------------------
        try {
            String inventoryList = "myReport.txt";
            PrintWriter out = new PrintWriter(inventoryList); //use this code to print to myReport.txt

            out.println("\n\n");
            //print the name, description and quantity of each item
            out.printf("%n%-30s", "Items in your backpack");
            out.printf("%n%-30s", "----------------------");
            for (Item item : currentBackpack) {
                out.printf("%n%-30s", item.getItemDescription());
            }
            out.printf("\n%n%n%n%50s", "Now get out there and conquer the Fire Swamp!");
            out.flush();

        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "You've gotta pick something up first silly!");
        }
        this.console.println("Your inventory report has been saved as myReport.txt in your system files.");
        // new code to catch empty backpack -----------------
        }
        // -------------------------------------
    }
   
    // Pick up an item and put it in backpack
    private void takeItemFromLocation() {

        Location currentLocation = PrincessBride.getPlayer().getLocation();

        try {
            BackpackControl bc = new BackpackControl();
            Item picked = bc.addItemToBackpack();
            this.console.println("You found a "
                    + picked.getItemDescription()
                    + ".  It will be added to your backpack.");
            currentLocation.setItem(null);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "There is nothing here.");
        }
    }

    // Pick up an item and put it in backpack
    /*private void useItemInBackpack() {

        Location currentLocation = PrincessBride.getPlayer().getLocation();

        try {
            BackpackControl bc = new BackpackControl();
            bc.addItemToBackpack();
            this.console.println("You found a "
                    + currentLocation.getItem().getItemDescription()
                    + ".  It will be added to your backpack.");
            currentLocation.setItem(null);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "There is nothing here.");
        }
    } */

    private void moveNorth() {
        MovementControl mc = new MovementControl();
        try {
            mc.moveNorth();
        } catch (MovementControlException mce) {
            ErrorView.display(this.getClass().getName(), "You cannot move further North!");
        }
        determineNextView();
    }

    private void moveEast() {
        MovementControl mc = new MovementControl();
        try {
            mc.moveEast();
        } catch (MovementControlException mce) {
            ErrorView.display(this.getClass().getName(), "You cannot move further East!");
        }
        determineNextView();
    }

    private void moveSouth() {
        MovementControl mc = new MovementControl();
        try {
            mc.moveSouth();
        } catch (MovementControlException mce) {
            ErrorView.display(this.getClass().getName(), "You cannot move further South!");
        }
        determineNextView();
    }

    private void moveWest() {
        MovementControl mc = new MovementControl();
        try {
            mc.moveWest();
        } catch (MovementControlException mce) {
            ErrorView.display(this.getClass().getName(), "You cannot move further West!");
        }
        determineNextView();
    }

    // Determines the next view based on the player's location
    private void determineNextView() {
        Location currentLocation = PrincessBride.getCurrentGame().getPlayer().getLocation();
        Location itemLocation = PrincessBride.getCurrentGame().getPlayer().getLocation();

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
            } /*else if (currentLocation.getLocationType() == LocationType.DART && !currentLocation.getVisited()) {
                this.console.println("\n You have found a useful item.  Press 'T' to place in your backpack.");
                currentLocation.setVisited(true);
            } else if (currentLocation.getLocationType() == LocationType.WATER && !currentLocation.getVisited()) {
                this.console.println("\n You have found a useful item.  Press 'T' to place in your backpack.");
                currentLocation.setVisited(true);
            } else if (currentLocation.getLocationType() == LocationType.POTION && !currentLocation.getVisited()) {
                this.console.println("\n You have found a useful item.  Press 'T' to place in your backpack.");
                currentLocation.setVisited(true);
            } */ else if (currentLocation.getLocationType() == LocationType.NONE && !currentLocation.getVisited()) {
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

    public void createMapReport() {

        try {
            
            Map map = PrincessBride.getCurrentGame().getMap();
            int locationRow = PrincessBride.getCurrentGame().getPlayer().getLocation().getRow();
            int locationCol = PrincessBride.getCurrentGame().getPlayer().getLocation().getCol();
                        
            String mapLocationReport = "myMap.txt";
            PrintWriter out;
            
            out = new PrintWriter(mapLocationReport);
            
            out.println("Map Locations");
            
            //print the name, description and quantity of each item
            out.printf("%n%-30s%-30s", "Map Coordinates", "Location Types");
            out.printf("%n%-30s%-30s", "-------------------", "-------------------");
            
            for (locationRow = 0; locationRow < 5; locationRow++) {
                for (locationCol = 0; locationCol < 5; locationCol++) {
                    String locationType = map.getLocationAt(locationRow, locationCol).getLocationType().toString();
                    out.printf("%n%-30s%-30s", locationRow + "." + locationCol, locationType);
                    out.flush();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.console.println("Your Map report has been saved as myMap.txt in your system files.");
    }
    
    private void saveCurrentGame() {
        this.console.println("\nSave game as: ");

        try {
            String filePath = this.getInput();
            GameControl.keepCurrentGame(filePath);

        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error on input");
        }
    }

    private void HelpMenuView() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }
}
