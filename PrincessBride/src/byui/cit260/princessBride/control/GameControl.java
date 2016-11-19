/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Inventory;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
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
        
        
        // Inventory - create inventory list
        Inventory[] inventoryList = GameControl.createInventoryList();
        currentGame.setInventory(inventoryList);
        
        // Map - create and populate with dangers/inventory items and starting point 
        Map map = new Map();
        map.init();
        
        currentGame.setMap(map);
        
        createAndAssignItems(map);

        startingLocation(map); 

    }

    private static Inventory[] createInventoryList() {
        System.out.println("\n *** createInventoryList() function called ***");
        return null;
    }
    
    private void setInventory() {
        System.out.println("\n *** setInventory() function called ***");
    }
            
    private void startingLocation(Map map) {
        System.out.println("\n *** startingLocation() function called ***");
    }

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
