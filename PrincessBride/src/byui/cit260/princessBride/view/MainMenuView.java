/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.GameControl;
import java.io.PrintWriter;
import princessBride.PrincessBride;

/**
 *
 * @author Gina Udy
 */
public class MainMenuView extends View {

    public MainMenuView() {

        super("\n"
                + "\n================================="
                + "\n           MAIN MENU             "
                + "\n================================="
                + "\n      N - start New game         "
                + "\n      L - Load saved game        "
                + "\n      S - Save current game      "
                + "\n      H - Help menu              "
                + "\n      C - Creator's report       "
                + "\n      Q - Quit                   "
                + "\n=================================");
    }

    @Override
    public boolean doAction(String selection) {

        char charSel = selection.charAt(0);

        switch (charSel) {
            case 'N':  // Start New Game 
                startNewGame();
                break;
            case 'L':  // Load Saved Game
                loadSavedGame();
                break;
            case 'S':  // Save Current Game 
                saveCurrentGame();
                break;
            case 'H':  // Help Menu
                HelpMenuView();
                break;
            case 'C': // Creators
                GameCreators();
                break;
            case 'Q':  // Quit 
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again***");
                break;
        }

        return false;
    }

    private void startNewGame() {
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

    private void GameCreators() {
        try {
            String filePath = "Created by.txt";
            PrintWriter output = new PrintWriter(filePath);

            output.println("We created this game for you to enjoy!");

            output.printf("%20s%20s%20s", "Gina Udy", "Lisa Walker", "Kelly Johnson");
            output.printf("%n%20s%20s%20s", "Student",  "Student", "Student");

            output.flush();
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), e.getMessage());
        }
    }
}
