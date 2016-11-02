/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.princessbride.view;

import java.util.Scanner;

/**
 *
 * @author Lisa Walker
 */
class GameMenuView {
   private String menu = "\n"
            + "\n--------------------------------------"
            + "\n GAME MENU"
            + "\n--------------------------------------"
            + "\nV - View Map"
            + "\nI - Inventory List"
            + "\nT - Take Item"
            + "\nU - Use Item"
           + "\nN - Move North"
           + "\nE - Move East"
           +"\nS - Move South"
           +"\nG - Save Game"
           +"\nH - Help"
           +"\nL - Look Around"
           +"\nB - Back"
            + "\nE - Exit to main menu"
            + "\n--------------------------------------";
   
   public String getInput(){
       Scanner keyboard = new Scanner(System.in);
       boolean valid = false;
       String selection = null;
       
       //while a valid name has not been retrieved
       while (!valid) {
       
            //get the value entered from the keyboard
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() < 1) {   //blank value entered
                System.out.println("\n*** Invalid section *** Try again");
                continue;
            }
            break;
   }
       return selection; // return the name
   }
   
      public boolean doAction(String choice) {
         
          choice = choice.toUpperCase(); // convert choice to upper case
         char charSel = choice.charAt(0);
          
       switch (choice){
           case "V": //view map
               this.viewMap();
               break;
           case "I": // List Inventory
               this.inventoryList();
               break;
           case "T": // Take Item
               this.takeItem();
               break;
           case "U": //Use Item
               this.useItem();
               break;
           case "N": // move North
               this.moveNorth();
               break;
           case "E":// move East
               this.moveEast();
               break;
           case "S": // moveSouth
               this.moveSouth();
               break;
           case "W"://moveWest
               this.moveWest();
               break;
           case "L": // look around
               this.lookAround();
               break;
           case "B": // go Back
               this.goBack();
               break;
            case "G":// save Game
               this.saveGame();
            default:
                System.out.println("\n*** Invalid Selection *** Please Try Again");
       }
       return false;
   }
      
      private void viewMap(){
          System.out.println("This is a 5 x 5 grid");
      }
      private void inventoryList(){
          System.out.println("*** inventoryList function called");
      }
      private void takeItem(){
          System.out.println("***takeItem function called");
      }
      private void useItem(){
          System.out.println("*** useItem function called****");
      }
      private void moveNorth(){
          System.out.println("***moveNorth function called****");
      }
      private void moveEast(){
          System.out.println("***moveEast function called ****");
      }
      private void moveSouth(){
          System.out.println("*** moveSouth function called***");
      }
      private void moveWest(){
          System.out.println("***moveWest function called****");    
      }
      private void lookAround(){
          System.out.println("***lookAround function called****");
      }
      private void goBack(){
          System.out.println("***goBack function called****");
      }
      private void saveGame(){
          System.out.println("***saveGame function called****");
      }
      
      
    void displayGameMenu() {
        System.out.println("\n*** displayGameMenu function called***");
    }

}
