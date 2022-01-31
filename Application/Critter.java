/**
* CRITTER PROGRAM
* CRITTER CLASS
* Class definition for a Critter class. Contains attributes for a Critter object's status and name -
* set by the main application and a Menu object, a default constructor, and setter for the name attribute.
* talk(), eat(), and play(), modules respond to calls from the main application based on user selections and 
* passTime() is called on a loop to dynamically increment attributes and create a time-based game feel.
*
* Claire Dupree
* 12/10/21
*/


// Import Java Scanner library
import java.util.Scanner;

public class Critter
{

   // Private attributes
   private int hunger;
   private int boredom;
   private String name;

   // Default constructor
   public Critter() {
      hunger = 5;
      boredom = 5;
      name = "";
   }
   

   // Name setter
   public void setName(String newName) {
   
      // Reject empty input
      while (newName.isEmpty()) {
      
         // Initialize Scanner
         Scanner input = new Scanner(System.in);
         
         System.out.println("Invalid entry. Please give your critter a name.");
         // Request valid input
         newName = input.nextLine();
      }
      // Set name attribute
      name = newName;
   }
   
   
   // Name getter
   public String getName() {
      return name;
   }
   
   
   // Displays Critter status based on mood
   public void talk() {
   
      // Mood is sum of boredom and hunger
      int mood = (hunger + boredom);

      if (mood >= 16) {
         System.out.println("\t" + "(> _ <)");
         System.out.println(name + " is angry.");
      }
      else if (mood >= 11) {
         System.out.println("\t" + "(- _ -)");
         System.out.println(name + " is frustrated.");  
      }
      else if (mood >= 6) {
         System.out.println("\t" + "(' - ')");
         System.out.println(name + " is okay.");  
      }
      else {
         System.out.println("\t" + "(^ u ^)");
         System.out.println(name + " is happy.");
      }
   }
   

   // Called when user selects Feed
   // Accepts eat amount value based on menu selection
   public void eat(int eatAmt) {
   
      // Display interaction to user
      System.out.println("\"Buurrp!\"");
         
      // Increment hunger attribute
      hunger = (hunger - eatAmt);
      if (hunger < 0) {
         hunger = 0;
      }
   }
   

   // Called when user selects Play
   // Accepts play amount value based on menu selection
   public void play(int playAmt) {
   
      // Display interaction to user
      System.out.println("\"Wheeee!\"");
      
      // Increment boredom attribute
      boredom = (boredom - playAmt);
      if (boredom < 0) {
         boredom = 0;
      }  
   }


   // Called on a loop to consistently increment attributed
   // Creates a dynamic game feel
   public void passTime() {
   
      // Increase hunger if not already at max
      if (hunger < 10) {
         hunger ++;
      }
      // Increase boredom if not already at max
      if (boredom < 10) {
         boredom ++;
      }
   }
}