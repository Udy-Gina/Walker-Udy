/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princessbride;

import byui.cit260.princessBride.model.Game;

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
        
        String playerInfo = gameOne.toString(); 
        System.out.println(playerInfo);
        
    }
    
}
