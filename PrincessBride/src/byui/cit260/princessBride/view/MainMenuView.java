/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.GameControl;
import princessBride.PrincessBride;

/**
 *
 * @author Gina Udy
 */
public class MainMenuView extends View {

    public MainMenuView() {

        super("\n"
                + "\n--------------------------------------"
                + "\nMAIN MENU"
                + "\n--------------------------------------"
                + "\nN - start New game"
                + "\nL - Load saved game"
                + "\nS - Save current game"
                + "\nH - Help menu"
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
            case 'L':  // load and play an existing game 
                loadSavedGame();
                break;
            case 'S':  // save the current game 
                saveCurrentGame();
                break;
            case 'H':  // display help menu 
                HelpMenuView();
                break;
            case 'Q':  // quit the current game 
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again***");
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

    private void saveCurrentGame() {
        this.console.println("\nSave game as: ");

        try {
            String filePath = this.getInput();
            GameControl.keepCurrentGame(filePath);

        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error on input");
        }
    }

    private void loadSavedGame() {
        this.console.println("\nEnter the saved file name: ");

        try {
            String filePath = this.getInput();
            GameControl.playSavedGame(filePath);
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.display();
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error on input");
        }

    }

    private void HelpMenuView() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

}
