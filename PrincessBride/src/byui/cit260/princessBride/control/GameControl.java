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

        PrincessBride.setPlayer(player);  

        return player;

    }

    public void createNewGame(Player player) {

        Game currentGame = new Game();
        PrincessBride.setCurrentGame(currentGame);

        currentGame.setPlayer(player);

        // TODO Need to set the inventory list...example from Ship game:
        // InventoryItem[] = inventoryList = GameControl.createInventoryList(); 
        // game.setInventory(InventoryList);
        // Create map
        Map map = new Map();
        map.init();

        player.setLocation(map.getLocationAt(0, 0));

        currentGame.setMap(map);

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

    // Play saved game
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
