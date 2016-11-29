/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.exceptions.GameControlException;
import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.view.ErrorView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import princessBride.PrincessBride;

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

        // TODO Need to set the inventory list...example from Ship game:
        // InventoryItem[] = inventoryList = GameControl.createInventoryList(); 
        // game.setInventory(InventoryList);
        // Create map
        Map map = new Map();
        map.init();

        player.setLocation(map.getLocationAt(0, 0));

        // Set map for the current game
        currentGame.setMap(map);

        // Assign items to random locations
        createAndAssignItems(map);

    }

    // Save the current game
    public static void keepCurrentGame(String filePath)
            throws GameControlException {

        try {
            FileOutputStream fops = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fops);

            oos.writeObject(PrincessBride.getCurrentGame()); // write the ame object out to file
        } catch (Exception e) {
            ErrorView.display("ProgramController", e.getMessage());
        }
    }

//    public static void saveGame(String filePath) {
//        try {
//            FileOutputStream fos = new FileOutputStream(filePath);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            
//            oos.writeObject(PrincessBride.getGame());
//        } catch(Exception e) {
//            ErrorView.display(this.getClass().getName(), "GameControl", e.getMessage());
//        }
//    }
    public static void playSavedGame(String filePath) {
        Game game = null;

        try {
            FileInputStream fips = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fips);

            game = (Game) ois.readObject();

            PrincessBride.setCurrentGame(game);
            PrincessBride.setPlayer(game.getPlayer());

        } catch (Exception e) {
            ErrorView.display("ProgramController", e.getMessage());
        }
    }

    // Reload and play a saved game 
//    public static void playSavedGame(String file) throws IOException, ClassNotFoundException {
//        this.console.println("\n *** playSavedGame() function called *** ");
//    }
    public boolean displayBackpack() throws GameControlException {

        //TODO Loop over backpack to display sorted/counted list
        List<Item> currentBackpack = PrincessBride.getCurrentGame().getPlayer().getBackpack();

        if (currentBackpack != null) {
            return true;
        } else {
            throw new GameControlException("\nYour backpack is empty.");
        }

        //return currentBackpack != null;
    }

    // Add items to the backpack list
    public boolean addItemToBackpack() throws GameControlException {
        Location currentLocation = PrincessBride.getPlayer().getLocation();

        if (currentLocation.getItem() != null) {
            PrincessBride.getPlayer().addItemToBackpack(currentLocation.getItem());
            return true;
        } else {

            throw new GameControlException("\nThere is nothing here.");
        }
    }

    // TODO Remove items from the backpack list when used in a danger
//    public void removeItemFromBackpack() {
//
//        //TODO Build function to remove item from backpack list
//        this.console.println("\n *** removeItemFromBackpack() function called *** ");
//    }
//
//    // Create starting point on map at location 0,0 
//    private void startingLocation(Map map, Player player) {  //TODO: set starting point on map 
//
//        player.setLocation(map.getLocationAt(0, 0));
//
//    }
    // Creates map and assigns random items from backpack to various locations 
    public void createAndAssignItems(Map map) {

        List<Item> items = new ArrayList<>();

        Item rope = new Item();
        rope.setItemDescription("rope");
        rope.setItemName("Rope");
        rope.setItemQuantity(1);
        items.add(rope);

        Item potion = new Item();
        potion.setItemDescription("healing potion");
        potion.setItemName("Healing Potion");
        potion.setItemQuantity(1);
        items.add(potion);

        Item water = new Item();
        water.setItemDescription("bucket of water");
        water.setItemName("Bucket of Water");
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
