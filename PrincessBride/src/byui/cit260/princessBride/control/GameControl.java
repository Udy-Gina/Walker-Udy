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

        player.setLocation(map.getLocationAt(0, 0));

        // Set map for the current game
        currentGame.setMap(map);

        // Assign items to random locations
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

    public boolean displayBackpack() {

        //TODO Loop over backpack to display sorted/counted list
        List<Item> currentBackpack = PrincessBride.getCurrentGame().getPlayer().getBackpack();
        
        if (currentBackpack != null) {
            System.out.println("\nYou have " + "currentBackpackQuantity" + " items in your backpack." 
                    + "\nThe items are: " + currentBackpack + ".");
            return true;
        } else {
            System.out.println("\nYour backpack is empty.");
            return false;
        }
    }

    // Add items to the backpack list
    public boolean addItemToBackpack() {
        Location currentLocation = PrincessBride.getPlayer().getLocation();

        if (currentLocation.getItem() != null) {
            PrincessBride.getPlayer().addItemToBackpack(currentLocation.getItem());
            System.out.println("You found a " + currentLocation.getItem().getItemDescription() + ".  It will be added to your backpack.");
            currentLocation.setItem(null);
            return true;
        } else {
            System.out.println("\nThere is nothing here.");
            return false;
        }
    }

    // TODO Remove items from the backpack list when used in a danger
    public void removeItemFromBackpack() {

        //TODO Build function to remove item from backpack list
        System.out.println("\n *** removeItemFromBackpack() function called *** ");
    }

    // Create starting point on map at location 0,0 
    private void startingLocation(Map map, Player player) {  //TODO: set starting point on map 

        player.setLocation(map.getLocationAt(0, 0));

    }

    // Creates map and assigns random items from backpack to various locations 
    public void createAndAssignItems(Map map) {

        List<Item> items = new ArrayList<>();

        Item rope1 = new Item();
        rope1.setItemDescription("rope");
        rope1.setItemName("Rope");
        rope1.setItemQuantity(1);
        items.add(rope1);

        Item rope2 = new Item();
        rope2.setItemDescription("rope");
        rope2.setItemName("Rope2");
        rope2.setItemQuantity(1);
        items.add(rope2); 
        
        Item rope3 = new Item();
        rope3.setItemDescription("rope");
        rope3.setItemName("Rope2");
        rope3.setItemQuantity(1);
        items.add(rope3); 
        
        Item potion1 = new Item();
        potion1.setItemDescription("healing potion");
        potion1.setItemName("Healing Potion");
        potion1.setItemQuantity(1);
        items.add(potion1);
        
        Item potion2 = new Item();
        potion2.setItemDescription("healing potion");
        potion2.setItemName("Healing Potion");
        potion2.setItemQuantity(1);
        items.add(potion2);
        
        Item potion3 = new Item();
        potion3.setItemDescription("healing potion");
        potion3.setItemName("Healing Potion");
        potion3.setItemQuantity(1);
        items.add(potion3);

        Item water1 = new Item();
        water1.setItemDescription("bucket of water");
        water1.setItemName("Bucket of Water");
        water1.setItemQuantity(1);
        items.add(water1);
        
        Item water2 = new Item();
        water2.setItemDescription("bucket of water");
        water2.setItemName("Bucket of Water");
        water2.setItemQuantity(1);
        items.add(water2);
        
        Item water3 = new Item();
        water3.setItemDescription("bucket of water");
        water3.setItemName("Bucket of Water");
        water3.setItemQuantity(1);
        items.add(water3);

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
//    public static void saveGame(String filePath) {
//        try {
//            FileOutputStream fos = new FileOutputStream(filePath);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            
//            oos.writeObject(PrincessBride.getGame());
//        } catch(Exception e) {
//            ErrorView.display("GameControl", e.getMessage());
//        }
//    }
//    
//    public static void loadGame(String filePath) {
//        Game game = null;
//        
//        try {
//            FileInputStream fis = new FileInputStream(filePath);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            
//            game = (Game)ois.readObject();
//            
//            PrincessBride.setGame(game);
//            PrincessBride.setPlayer(game.getPlayer());
//        } catch (Exception e) {
//            ErrorView.display("GameControl", e.getMessage());
//        }
//    }
}
