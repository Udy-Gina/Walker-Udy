/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princessBride;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.view.ErrorView;
import byui.cit260.princessBride.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Gina Udy
 */
public class PrincessBride {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    private static Game loadSavedGame = null;
    private static Game saveCurrentGame = null;
    private static Player player = null;
    private static Item item;
    private static Map map;
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        PrincessBride.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        PrincessBride.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        PrincessBride.inFile = inFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static Game getLoadSavedGame() {
        return loadSavedGame;
    }

    public static void setLoadSavedGame(Game loadSavedGame) {
        PrincessBride.loadSavedGame = loadSavedGame;
    }

    public static Game getSaveCurrentGame() {
        return saveCurrentGame;
    }

    public static void setSaveCurrentGame(Game saveCurrentGame) {
        PrincessBride.saveCurrentGame = saveCurrentGame;
    }

    public static Item getItem() {
        return item;
    }

    public static void setItem(Item item) {
        PrincessBride.item = item;
    }

    public static Map getMap() {
        return map;
    }

    public static void setMap(Map map) {
        PrincessBride.map = map;
    }

    public static void setCurrentGame(Game currentGame) {
        PrincessBride.currentGame = currentGame;
    }

    public static Game getloadSavedGame() {
        return loadSavedGame;
    }

    public static void setloadSavedGame(Game loadSavedGame) {
        PrincessBride.loadSavedGame = loadSavedGame;
    }

    public static Game getsaveCurrentGame() {
        return saveCurrentGame;
    }

    public static void setsaveCurrentGame(Game saveCurrentGame) {
        PrincessBride.saveCurrentGame = saveCurrentGame;
    }

    public static Player getPlayer() {
        return PrincessBride.player;
    }

    public static void setPlayer(Player player) {
        PrincessBride.player = player;
    }

    public static void main(String[] args) {
        try {
            PrincessBride.inFile = new BufferedReader(new InputStreamReader(System.in));
            PrincessBride.outFile = new PrintWriter(System.out, true);

            String filePath = "log.txt";
            PrincessBride.logFile = new PrintWriter(filePath);

            //create StartProgramViewOrig and display the start program view
            StartProgramView spv = new StartProgramView();
            spv.displayStartProgramView();
            return;
            
        } catch (Exception e) {
            
            ErrorView.display("Exception: " + e.toString()
                    + "\nCause: " + e.getCause()
                    + "\nMessage: " + e.getMessage());
            //e.printStackTrace();
        } 
        finally {
              try {
                    if (PrincessBride.inFile != null) 
                        PrincessBride.inFile.close();

                    if (PrincessBride.outFile != null) 
                        PrincessBride.outFile.close();

                    if (PrincessBride.logFile != null) 
                        PrincessBride.logFile.close();
                    }
                } catch (IOException e) {
                ErrorView.display("Error closing files");
                return;
            }
            PrincessBride.outFile.close();
        }

    }

}

/*static {
        Player playerOne = new Player();

        playerOne.setName("John Doe");
        //playerOne.setCoordinates(3.0);
        playerOne.setItem("Item");

        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);

        Location locationOne = new Location();
        
        locationOne.setDescription(playerInfo);
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
        
    } */
