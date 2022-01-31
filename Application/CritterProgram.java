/**
* CRITTER PROGRAM
* MAIN APPLICATION
* A simple game in which the user meets a critter, gives it a name, and cares for it.
* The user can feed or play with the critter and listen to its status. The critter's 
* mood changes with each user selection and the user must determine what the critter
* needs in order to be happy!
* Application creates a single object of the Critter and Menu class.
*
* Claire Dupree
* 12/11/21
*/


// Import Java Scanner library
import java.util.Scanner;

public class CritterProgram
{

   // main module
   public static void main(String[] args)
   {
      // Create a Critter object and Menu object
      Critter thisCritter = new Critter();
      Menu thisMenu = new Menu();
      
      // Display introduction menu
      // Send Critter argument to set Critter name
      thisMenu.introMenu(thisCritter);
      
      // Display main menu
      // Send Critter argument to get Critter name
      // User input menu selection
      thisMenu.displayMenu(thisCritter);
      
      // Local variable for user selection
      // Prime read
      String choice = thisMenu.getChoice();
      
      // Outer loop for critter interaction
      // Repeats until quit is selected
      while (!choice.equals("Q") && !choice.equals("q")) {
      
         // Call module to process user selection
         playGame(choice, thisCritter);
         
         // Increment hunger or boredom
         thisCritter.passTime();
         
         // Display menu again
         thisMenu.displayMenu(thisCritter);
         
         // Input next menu selection
         choice = thisMenu.getChoice();
      }
      // End program message
      System.out.println("Goodbye, " + thisCritter.getName() + "!");
   }
   
   
   // Module to process user input from main menu
   // Prompts inner loop menu & sets object attributes
   public static void playGame(String choice, Critter thisCritter) {
   
      // Initialize 
      int amount = 0;
      switch (choice) {
      
         // User select Listen
         case "L":   
         case "l": 
            // Print current status of Critter object
            thisCritter.talk();
            break;
            
         // User select Feed   
         case "F":
         case "f":   
            // Call askForQuantity to determine food increment amount
            amount = askForQuantity("food");
            // Send food amount to Critter object
            thisCritter.eat(amount);
            break;
            
         // User select Play
         case "P":
         case "p":
            // Call askForQuantity to determine play increment amount
            amount = askForQuantity("play");
            // Send play amount to Critter object
            thisCritter.play(amount);
            break;
            
         // Invalid selection   
         default:
            System.out.println("Invalid entry. Enter L, F, or P.");
      }
   }
   
   
   // Module to convert user menu selection into values to increment attributes
   public static int askForQuantity(String prevChoice) {
      // Initialize Scanner
      Scanner input = new Scanner(System.in);
      
      // Local variables
      int amount = 0;
      String nextChoice = "";
      boolean isValid = false;

      // Inner loop for continued critter interaction
      while (!isValid) {
 
         // Specific menu options based on playGame selections
         System.out.println("S" + "\t-\t" + "Small amount of " + prevChoice);
         System.out.println("M" + "\t-\t" + "Medium amount of " + prevChoice);
         System.out.println("L" + "\t-\t" + "Large amount of " + prevChoice);
         // Input user selection
         nextChoice = input.next();
         System.out.println();
               
         switch (nextChoice) {
         
            // User select Small
            case "S":
            case "s":
               // Set small amount, exit loop
               amount = 2;
               isValid = true;
               break;
            
            // User select Medium
            case "M":
            case "m":
               // Set medium amount, exit loop
               amount = 4;
               isValid = true;
               break;
               
            // User select Large
            case "l":
            case "L":
               // Set large amount, exit loop          
               amount = 6;
               isValid = true;
               break;
            
            // Invalid selection
            default:
               System.out.println("Invalid entry. Enter S, M, or L.");
         } // End case
      } // End While
      
      // Return value to increment amount
      return amount;
   }
}