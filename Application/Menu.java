/**
* CRITTER PROGRAM
* MENU CLASS
* Contains introduction menu & main menu displays to be used by the main application.
* Accepts a Critter object in each menu to set or display Critter name.
*
* Claire Dupree
* 12/11/21
*/


// Import Java Scanner library
import java.util.Scanner;

public class Menu 
{

   // Declare private attributes
	private String choice;


   // Default constructor
	public void Menu() {
		choice = "";
	}	
   
   
   // User input getter
	public String getChoice() {
		return choice;
	}
   
   
   // Introduction menu, displays at program startup
   // Accepts Critter object to set Critter name attribute
   public void introMenu(Critter thisCritter) {
      // Initialize scanner
      Scanner input = new Scanner(System.in);
      
      // Opening display
      System.out.println("\t\t\t" + "== W E L C O M E ==");
      System.out.println("== TO THE CRITTER CARETAKER GAME ==");
      System.out.println();
      // Input Critter name
      System.out.println("What do you wish to name your critter?");
      thisCritter.setName(input.nextLine());
      System.out.println();
   }


   // Main menu, defines choices for interacting with Critter
   // Accepts Critter object to display Critter name attribute
	public void displayMenu(Critter thisCritter) {
      // Initialize scanner
		Scanner input = new Scanner(System.in);
      // Local Critter name variable
      String name = thisCritter.getName();
      
      // Main menu display
		System.out.println("L" + "\t-\t" + "Listen to " + name);
		System.out.println("F" + "\t-\t" + "Feed " + name);
		System.out.println("P" + "\t-\t" + "Play with " + name);
		System.out.println("Q" + "\t-\t" + "Quit");
      // Input user selection, store in private class attribute
		choice = input.next();
      System.out.println();
	}
}