/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princessbride;

import byui.cit260.princessBride.model.FlameSpurt;
import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.model.Rodent;
import byui.cit260.princessBride.model.LightningSand; 
import citbyui.cit260.princessbride.view.StartProgramView;

/**
 *
 * @author Gina Udy
 */
public class PrincessBride {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create StartProgramViewOrig and display the start program view
        StartProgramView startProgramview = new StartProgramView();
        StartProgramView.displayStartProgramView();

        Player playerOne = new Player();

        playerOne.setName("John Doe");
        playerOne.setCoordinates(3.0);
        playerOne.setItem("Item");

        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);

        Location locationOne = new Location();

        locationOne.setColumn(0);
        locationOne.setDescription("description");
        locationOne.setRow(0);
        locationOne.setTravelTime(0);
        locationOne.setVisited(0);
        locationOne.setDisplaySymbol("symbol");

        String locationInfo = locationOne.toString();
        System.out.println(locationInfo);

        Map mapOne = new Map();

        mapOne.setColumnNumber(0);
        mapOne.setRowNumber(0);

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

        itemOne.setName("John Doe");
        itemOne.setType("Item");
        itemOne.setQuantity(4);

        String itemInfo = itemOne.toString();
        System.out.println(itemInfo);

        LightningSand guessOne = new LightningSand();

        guessOne.setDistance(4);
        guessOne.setCalculation(4);
        guessOne.setResponse("Wrong!  You are dead.");

        String lightningSandInfo = guessOne.toString();
        System.out.println(lightningSandInfo);
    }

}
