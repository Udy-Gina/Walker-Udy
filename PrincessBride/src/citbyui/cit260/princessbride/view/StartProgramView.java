package citbyui.cit260.princessbride.view;

import java.util.Scanner;

/**
 *
 * @author lisawalker
 */
public class StartProgramView {  // calls the welcome banner and asks for user name

    private void displayBanner() {  // this is the welcome banner 
        System.out.println(
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
                + "\n* you will need to have a helpful item in your inventory that matches"
                + "\n* the hazard in order to be safe.  If you do not, you will perish!"
                + "\n*"
                + "\n* Good luck, stay alive, and have fun!"
                + "\n*"
                + "\n***************************************************************************");
    }

    public void displayStartProgramView() {  // shows user name and banner from above functions

        displayBanner();

        String playerName = getPlayerName();

        displayNextView(playerName);

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }

    private String getPlayerName() {  // gets user name 

        Scanner in = new Scanner(System.in);  // get infile for keyboard 
        boolean isValidName = false;  // initialize to not valid 
        String name = " ";

        System.out.println("\nPlease enter your name: ");

        while (!isValidName) {
            String input = "";
            input = in.nextLine();
            
            if (input != null && input.length() >= 2) {
                isValidName = true;
                name = input.toUpperCase();
                
            } else {
                System.out.println("\nInput is invalid: name must be greater than one character in length.");
            }
            
        }

        return name;
    }

    private void displayNextView(String playerName) {

        // display a custom welcome message 
        System.out.println("\n===================================="
                + "\n Welcome to the game, " + playerName + "."
                + "\n We hope you have a lot of fun!"
                + "\n====================================");

    }

}
