package citbyui.cit260.princessbride.view;

/**
 *
 * @author lisawalker
 */
public class StartProgramView {

    private String promptMessage;

    public StartProgramView() {

        //prompt message = "Please enter your name"
        this.promptMessage = "\n*************************"
                + "\nPlease enter your name:"
                + "\n********************************";
        // display the banner when view is created
        this.displayBanner();
    }

    public void displayBanner() {
        System.out.println(
                "\n************************************************************"
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
                + "\n**********************************************************");
//To change body of generated methods, choose Tools | Templates.
    }

    public void displayStartProgramView() {
       

           boolean done = false;  // set flag to not done
            do {
                //prompt for and get players name
                String playersName = this.getPlayersName();
                if (playersName.toUpperCase().equals("Q")) //user wants to quit
                    return; // exit the game
           
                // do the requested action and display the next view
                done = this.doAction(playersName);
            } while (!done);
        }

        private String getPlayersName() {
            System.out.println("\n*** getPlayersName() called***");
            return "Joe";
        }

        private boolean doAction(String playersName) {
            System.out.println("\n*** doAction() called ***");
            return true;
        }
    }

