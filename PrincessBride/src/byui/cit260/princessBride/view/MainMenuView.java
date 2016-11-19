/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessbride.view;

import byui.cit260.princessBride.control.GameControl;
import java.util.Scanner;
import princessbride.PrincessBride;

/**
 *
 * @author Gina Udy
 */
public class MainMenuView extends View {

    public MainMenuView() {
    
    super ( "\n"
            + "\n--------------------------------------"
            + "\nMAIN MENU"
            + "\n--------------------------------------"
            + "\nN - New game"
            + "\nL - Load saved game"
            + "\nH - Help menu"
            + "\nS - Save current game"
            + "\nQ - Quit"
            + "\n--------------------------------------"); 
    }

    @Override
    public boolean doAction(String selection) {

        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'N':  // create and start a new game 
                startNewGame();
                break;
            case 'L':  // get and play an existing game 
                loadSavedGame();
                break;
            case 'H':  // display help menu 
                HelpMenuView();
                break;
            case 'S':  // save the current game 
                saveCurrentGame();
                break;
            case 'Q':  // quit the current game 
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again***");
                break;
        }

        return false;
    }

    private void startNewGame() {
        // create and start a new game 
        GameControl gc = new GameControl(); 
        gc.createNewGame(PrincessBride.getPlayer()); 
        GameMenuView gameMenu = new GameMenuView(); 
        gameMenu.display();
        
    }


    //TODO: Need to look into readLine() and ErrorView() functions     
    private void loadSavedGame() { 
        
        Scanner in = new Scanner(System.in);  // get infile for keyboard 
        
        System.out.println("\nEnter file name: ");
        
        try {
            String file = in.readLine();
            GameControl.loadSavedGame(file);
            GameMenuView gmv = new GameMenuView();
            gmv.display();
        } catch (Exception e) {
            System.out.println("\n *** Error about loadSavedGame() ***");
        }
    }

    //TODO: Need to look into readLine() and ErrorView() functions     
    private void saveCurrentGame() { 
        
        Scanner in = new Scanner(System.in);  // get infile for keyboard 
        
        System.out.println("\nEnter file name: ");
        try {
            String file = in.readLine();
            GameControl.saveCurrentGame(file);
        } catch (Exception e) {
            System.out.println("\n *** Error about loadSavedGame() ***");
        }
    }
    

    private void HelpMenuView() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

}
