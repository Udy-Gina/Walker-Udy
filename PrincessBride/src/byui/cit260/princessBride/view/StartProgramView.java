package byui.cit260.princessBride.view;

import byui.cit260.princessBride.model.Player;
import java.io.IOException;
import princessBride.PrincessBride;

/**
 *
 * @author lisawalker
 */
public class StartProgramView extends View {  // calls the welcome banner and asks for user name

    private void displayBanner() {  // this is the welcome banner 
        this.console.println(
                "\n***************************************************************************"
                + "\n*"
                + "\n* Can you survive the Fire Swamp?"
                + "\n* Test your deduction and math skills as you navigate"
                + "\n* the hazards of the most dangerous place in Florin."
                + "\n*"
                + "\n* This game is a text-based adventure game set in "
                + "\n* the fantasy land of the movie The Princess Bride."
                + "\n* The fire swamp of Florin is famous for being deadly"
                + "\n* to all who enter.  You are being pursued by enemies and"
                + "\n* they have driven you toward the fire swamp.  You have no"
                + "\n* choice but to take your chances in the swamp in order to"
                + "\n* escape.  The swamp is dark and musty, with no visible path."
                + "\n* As you enter, you feel your heart beat faster with fear."
                + "\n*"
                + "\n* The game recreates the fire swamp on a grid, with hazards"
                + "\n* on some squares and helpful items on others.  As you travel through"
                + "\n* the swamp you can pick up helpful items, and when you land on "
                + "\n* a square with a hazard, you will have to answer a math question"
                + "\n* to pass through safely.  If you do not answer a question correctly,"
                + "\n* you will need to have a helpful item in your backpack that matches"
                + "\n* the hazard in order to be safe.  If you do not, you will perish!"
                + "\n*"
                + "\n* Good luck, stay alive, and have fun!"
                + "\n*"
                + "\n***************************************************************************");
    }

    public void displayStartProgramView() throws IOException {  // shows user name and banner from above functions

        displayBanner();

        String playerName = getPlayerName();
        
        displayNextView(playerName);
        
        Player p = new Player();
        p.setName(playerName); 
        PrincessBride.setPlayer(p);

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }

    private String getPlayerName() throws IOException {  // gets user name 

        boolean isValidName = false;  // initialize to not valid 
        String name = " ";

        this.console.println("\nPlease enter your name: ");

        while (!isValidName) {
            String input = "";
            input = this.keyboard.readLine();  // get next line typed on keyboard 
            
            if (input != null && input.length() >= 2) {
                isValidName = true;
                name = input.toUpperCase();
                
            } else {
                ErrorView.display(this.getClass().getName(), "\nInput is invalid: name must be greater than one character in length.");
            }
            
        }

        return name;
    }

    private void displayNextView(String playerName) {

        // display a custom welcome message 
        this.console.println("\n===================================="
                + "\n Welcome to the game, " + playerName + "."
                + "\n We hope you have a lot of fun!"
                + "\n====================================");

    }

    @Override
    public boolean doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
