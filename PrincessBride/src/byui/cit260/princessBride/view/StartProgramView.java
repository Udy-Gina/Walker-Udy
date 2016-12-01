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
        this.console.println("\n"
                + "\n==========================================================================="
                + "\n                     CAN YOU SURVIVE THE FIRE SWAMP?                       "
                + "\n==========================================================================="
                + "\n                                                                           "
                + "\n   Test your deduction and math skills as you navigate the hazards of the  "
                + "\n   most dangerous place in Florin.                                         "
                + "\n                                                                           "
                + "\n   This game is a text-based  adventure game set in the  fantasy land of   "
                + "\n   the movie The Princess Bride.                                           "
                + "\n                                                                           "
                + "\n   The fire swamp of  Florin is famous for being deadly to all who enter.  "
                + "\n   You are being  pursued by enemies and they have driven you  toward the  "
                + "\n   fire swamp.   You have no choice but to take your chances in the swamp  "
                + "\n   in order to escape. The swamp is dark and musty, with no visible path.  "
                + "\n   As you enter, you feel your heart beat faster with fear.                "
                + "\n                                                                           "
                + "\n   The game recreates the fire swamp on a grid. As you travel through the  "
                + "\n   swamp  you will  encounter  dangers and  sometimes find items that may  "
                + "\n   help you survive.                                                       "
                + "\n                                                                           "
                + "\n   Good luck, stay alive, and have fun!"
                + "\n                                                                           " 
                + "\n===========================================================================");
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
        this.console.println("\n"
                + "\n================================="
                + "\n Welcome to the game, " + playerName + "."
                + "\n We hope you have a lot of fun!"
                + "\n=================================");

    }

    @Override
    public boolean doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
