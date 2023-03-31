import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This program creates a user interactie game
 * where the game acts like a genie(pet) but 
 * we have to take care of the genie like feed
 * it and play with it othrwise it will not 
 * predict the user's fortune.
 */

public class Geniegotchi {
    private String name = "Bob";
    private int endurance = 5;
    private int happiness = 4;

    public void setName(String n) {
        name = n; 
        System.out.println("Your Genie's name has been set to " + name); 
    }

    public void getInfo() {// genie stats/information.
        System.out.println("Name: " + name);
        System.out.println("Endurance: " + endurance + " (Hint: Should be greater or equals to 5.)");
        System.out.println("Happiness: " + happiness + " (Hint: Should be greater or equals to 6.)");
    }
    // returns current endurance 
    public int getEndurance() {// genie's endurance level.
        return endurance;
    }
    // returns current happiness
    public int getHappiness() {// genie's happiness level.
        return happiness;
    }
    
    public String tester(String a){// This is for part c, it is not use in the code.
        System.out.println("Geniegotchi's previous name was " + name);
        name = a;
        System.out.println("You gave Geniegotchi the new name " + name);
        return name;
    }

    public void feed() {// genie feeding method increases endurance if endureance not already maxed.
        if (endurance < 10) {
            endurance += 1;
            System.out.println("Feeding...");
        } else {
            System.out.println("I'm full.");
        }
    }

    public void play() {// play method increases happiness at the cost of endurance unless happiness already maxed.
        if (happiness < 10) {
            System.out.println("Playing...");
            happiness++;
            endurance -= 2;
        } else {
            System.out.println("I'm tired, no more please.");
        }
    }

    public void askFortune() {// genie tells the user's fortune.
        if (happiness > 6 && endurance > 5) {
            int num = (int) (Math.random() * 100) + 1;// num is for random number

            try {
                Scanner scanner = new Scanner(new File("fortunes.txt"));
                String fortuneText = "";

                for (int i = 0; i < num; i++) {
                    fortuneText = scanner.nextLine();
                }

                System.out.println(fortuneText);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

        } else if (happiness > 6 && endurance <= 5) {
            System.out.println("Low endurance. Please feed the Geniegotchi to raise its endurance.");
        } 
        else if (happiness <= 6 && endurance > 5) {
            System.out.println("Low happiness. Please play with the Genigotchi to raise its happiness.");
        } 
        else if (happiness <= 6 && endurance <= 5) {

            System.out.println("Feed and play with the Geniegotchi to make it healty and happy enough to get your fortune. ");
        }

        endurance--;
        happiness--;
    }
}
