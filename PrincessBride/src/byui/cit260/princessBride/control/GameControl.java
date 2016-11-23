/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import princessbride.PrincessBride;

/**
 *
 * @author Gina Udy
 */
public class GameControl {

    public static Player createPlayer(String name) {

        if (name == null) {
            return null;
        }

        Player player = new Player();
        player.setName(name);

        PrincessBride.setPlayer(player);  // save the player 

        return player;

    }

    public void createNewGame(Player player) {

        // New Game - create new game
        Game currentGame = new Game();
        PrincessBride.setCurrentGame(currentGame);

        // Player - create player 
        currentGame.setPlayer(player);

        // Create map
        Map map = new Map();
        map.init();

        // Set map for the current game
        currentGame.setMap(map);

        // Assign inventory to random locations
        createAndAssignItems(map);

    }

    // Save the current game
    public static void keepCurrentGame(String fileName) {
        System.out.println("\n *** keepCurrentGame() function called *** ");
    }

    // Reload and play a saved game 
    public static void playSavedGame(String file) throws IOException, ClassNotFoundException {
        System.out.println("\n *** playSavedGame() function called *** ");
    }

    // Show the current inventory, sort it alphabetically, and show a total 
    public void displayInventory() {
        
        //TODO Loop over inventory to display sorted/counted list
        System.out.println("\n *** displayInventory() function called *** ");
    }
    
    // Add items to the inventory list
    public void addItemToInventory() { 
        Location currentLocation = PrincessBride.getPlayer().getLocation();
        
        if(currentLocation.getItem() != null) {
            PrincessBride.getPlayer().addItemToInventory(currentLocation.getItem());
            System.out.println("\nYou found a " + currentLocation.getItem().getItemDescription());
            currentLocation.setItem(null);
        }
        else {
            System.out.println("\nThere is nothing here.");
        }
    } 

    // Remove items from the inventory list when used in a danger
    public void removeItemFromInventory() { 
        
    //TODO Build function to remove item from inventory list
    System.out.println("\n *** removeItemFromInventory() function called *** ");
}
    
    // Create starting point on map at location 0,0 
    private void startingLocation(Map map, Player player) {  //TODO: set starting point on map 
        
        player.setLocation(map.getLocationAt(0, 0));
        
    }

    // Creates map and assigns random items from inventory to various locations 
    public void createAndAssignItems(Map map) {

        List<Item> items = new ArrayList<>();

        Item rope = new Item();
        rope.setItemDescription("Rope");
        rope.setItemName("rope");
        rope.setItemQuantity(1);
        items.add(rope);

        Item potion = new Item();
        potion.setItemDescription("Healing Potion");
        potion.setItemName("potion");
        potion.setItemQuantity(1);
        items.add(potion);

        Item water = new Item();
        water.setItemDescription("Bucket of Water");
        water.setItemName("water");
        water.setItemQuantity(1);
        items.add(water);

        Random rand = new Random();

        for (Item item : items) {
            boolean placed = false;
            while (!placed) {
                int randomRow = rand.nextInt(Map.ROWS);
                int randomCol = rand.nextInt(Map.COLUMNS);

                Location location = map.getLocationAt(randomRow, randomCol);
                if (location.getItem() == null) {
                    location.setItem(item);
                    placed = true;
                }
            }

        }

    }

}