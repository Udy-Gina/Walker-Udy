/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.princessbride.view;

import byui.cit260.princessBride.control.GameControl;
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
            + "\nN - Start new game"
            + "\nG - Get and start saved game"
            + "\nH - Help menu"
            + "\nS - Save game"
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
            case 'G':  // get and play an existing game 
                startExistingGame();
                break;
            case 'H':  // display help menu 
                HelpMenuView();
                break;
            case 'S':  // save the current game 
                saveGame();
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

    private void startExistingGame() {
        System.out.println("\n*** startExistingGame function called***");
    }

    private void saveGame() {
        System.out.println("\n*** saveGame function called***");
    }

    private void HelpMenuView() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

}
