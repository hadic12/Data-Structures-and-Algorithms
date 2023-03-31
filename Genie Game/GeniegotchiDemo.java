import java.util.*;
/**
 * This program displays/demonstrates the orginal Geniegotchi
 * program and gives the user choices regarding their genie.
 */

public class GeniegotchiDemo {
    public static void menu() {// The method that promts the user with multiple choices.
        System.out.println("Welcome to Geniegotchi (the game)!");
        System.out.println("Press: \n0 -  To Quit");
        System.out.println("1 - To Rename your Geniegotchi.");
        System.out.println("2 - To Get current stats on the Geniegotchi.");
        System.out.println("3 - To feed the Geniegotchi.");
        System.out.println("4 - To Play with your Geniegotchi.");
        System.out.println("5 - To Ask your fortune from the Geniegotchi!");
        System.out.println("6 - To Print Menu.");
    }

    public static void main(String[] args) {// Plays the Geniegotchi game.
        Scanner keyboard = new Scanner(System.in);
        Geniegotchi gg = new Geniegotchi();// gg stands for Geniegotchi.
        menu(); 
        int option = 1;

        try{
            while (option != 0) {
                System.out.print("Enter your option: ");

                option = Integer.parseInt(keyboard.nextLine()); 
                int happyCheck = gg.getHappiness();
                int enduranceCheck = gg.getEndurance();

                if (enduranceCheck <= 0 || happyCheck <= 0){
                    System.out.println("Geniegotchi has run away due to being hungry or unhappy");
                    System.exit(0);
                }
                //Schematic for user interaction below.
                switch (option) {
                    case 1:
                        System.out.print("Enter a new name for your Geniegotchi: ");
                        String name = keyboard.nextLine();
                        gg.setName(name);
                        break;
                    case 2:
                        gg.getInfo();
                        break;
                    case 3:
                        gg.feed();
                        break;
                    case 4:
                        gg.play();
                        break;
                    case 5:
                        gg.askFortune();
                        break;
                    case 6:
                        menu();
                        break;
                    case 0:
                        System.out.print("Thank you for playing!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }
        catch(Exception e){
            System.out.println("Invalid input");
            GeniegotchiDemo.main(args);
        }
    }
}