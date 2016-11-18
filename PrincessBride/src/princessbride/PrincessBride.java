/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princessbride;

import byui.cit260.princessBride.model.FlameSpurt;
import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Inventory;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.model.Rodent;
import byui.cit260.princessBride.model.LightningSand;
import byui.cit260.princessBride.model.LocationType;
import citbyui.cit260.princessbride.view.StartProgramView;

/**
 *
 * @author Gina Udy
 */
public class PrincessBride {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    private static Player player = null;
    private static Item item;
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        PrincessBride.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return PrincessBride.player;
    }

    public static void setPlayer(Player player) {
        PrincessBride.player = player;
    }

    public static void main(String[] args) {
        //create StartProgramViewOrig and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
    } 
    
   public static void setInventory(Inventory inventory) {
        System.out.println("\n***create inventory***") ;
    } 

    static {
        Player playerOne = new Player();

        playerOne.setName("John Doe");
        playerOne.setCoordinates(3.0);
        playerOne.setItem("Item");

        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);

        Location locationOne = new Location();
        
        locationOne.setDescription(playerInfo);
        locationOne.setTravelTime(0);
        locationOne.setDisplaySymbol(playerInfo);
        locationOne.setRow(0);
        locationOne.setCol(0);
        locationOne.setLocationType(LocationType.NONE);
        locationOne.setVisited(true);
        locationOne.setItem(item);

        String locationInfo = locationOne.toString();
        System.out.println(locationInfo);
        
        Map mapOne = new Map();
        
        String mapInfo = mapOne.toString();
        System.out.println(mapInfo);

        Rodent rodentOne = new Rodent();

        rodentOne.setLength(0);
        rodentOne.setHeight(0);
        rodentOne.setCalculation(0);

        String rodentInfo = rodentOne.toString();
        System.out.println(rodentInfo);

        FlameSpurt flameSpurtOne = new FlameSpurt();

        flameSpurtOne.setBaseWidth(0);
        flameSpurtOne.setBaseLength(0);
        flameSpurtOne.setBaseHeight(0);
        flameSpurtOne.setAnswer(0);

        String flameSpurtInfo = flameSpurtOne.toString();
        System.out.println(flameSpurtInfo);

        Item itemOne = new Item();

        itemOne.setItemName("Rope");
        itemOne.setItemDescription("rope");
        itemOne.setItemQuantity(3);

        String itemInfo = itemOne.toString();
        System.out.println(itemInfo);

        LightningSand guessOne = new LightningSand();

        guessOne.setDistance(4);
        guessOne.setCalculation(4);
        guessOne.setResponse("Wrong!  You are dead.");

        String lightningSandInfo = guessOne.toString();
        System.out.println(lightningSandInfo);
        
        Inventory inventoryOne = new Inventory(); 
        
        String inventoryInfo = inventoryOne.toString();
        System.out.println(inventoryInfo);
        
    } 

}
