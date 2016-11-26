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
                ErrorView.display("\n*** Invalid selection *** Try again***");
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

    /*private void saveCurrentGame() {
        this.console.println("\nPlease enter your name: ");
        try {
            String fileName = in.readLine();
            GameControl.keepCurrentGame(fileName);
        } catch (Exception e) {
            this.console.println("\n *** Please enter a valid file name! ***");
        }
    } */
    private void saveCurrentGame() {
        this.console.println("\nSave game as: ");
        String filePath = this.getInput();
                try{
                    GameControl.keepCurrentGame(PrincessBride.getCurrentGame(),filePath);
                    
                }
                catch(Exception e) {
                    ErrorView.display("\nMainMenuView", e.getMessage());
                }
    }

    private void loadSavedGame() {
        this.console.println("\nEnter the saved file name: ");
        String filePath = this.getInput();
        try {
            GameControl.playSavedGame(filePath);
        } catch (Exception e) {
            ErrorView.display("MainMenuView", e.getMessage());
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void HelpMenuView() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

}

/* console.println("Enter file name: ");
        try {
            String fileName = in.readLine();
            ProgramController.loadCurrentGame(fileName);
            GameMenuView gmv = new GameMenuView();
            gmv.display();
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error on input");
        } */
