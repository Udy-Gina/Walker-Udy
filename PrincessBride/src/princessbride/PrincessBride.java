/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princessbride;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Player;

/**
 *
 * @author Gina Udy
 */
public class PrincessBride {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Game gameOne = new Game(); 
        
        gameOne.setTotalTime(3.0); 
        gameOne.setGetItem("Item"); 
        gameOne.setGetMap(0); 
        gameOne.setSaveGame(0);
        gameOne.setLoadGame(0); 
        
        String gameInfo = gameOne.toString(); 
        System.out.println(gameInfo);
        
        Player playerOne = new Player(); 
        
        playerOne.setName("John Doe"); 
        playerOne.setCoordinates(3.0); 
        
        String playerInfo = playerOne.toString(); 
        System.out.println(playerInfo);
        
        Location locationOne = new Location();
        
        locationOne.setColumn(0);
        locationOne.setDescription("description");
        locationOne.setRow(0 );
        locationOne.setTravelTime(0);
        locationOne.setVisited(0);
        locationOne.setDisplaySymbol("symbol");
        
        String locationInfo = locationOne.toString();
        System.out.println(locationInfo);
        
    }
    
}
