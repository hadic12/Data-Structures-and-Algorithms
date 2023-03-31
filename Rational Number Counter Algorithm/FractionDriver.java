/* Name: Hadi Chohan
 * Class: CSS 143
 * Date: 10/8/2022
 * Teacher: Professor Kalmin
 */


import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;


public class FractionDriver {

    public static void main (String[]args) throws IOException {
        ObjectList fractions = new ObjectList(); //creates new instance of ObjectList class

        int current = 0; //counter current keeps track of which iteration of loop we are in
        Scanner in = new Scanner(new FileInputStream("fractions.txt")); //Scanner object initialized and accesses fractions txt file

        do { 
            int numerator;
            int denominator; 
            String fractionsTxt = in.nextLine();
            String[]splitFrac = fractionsTxt.split("/");
            numerator = Integer.parseInt(splitFrac[0]); //the first index carries the numerator
            denominator = Integer.parseInt(splitFrac[1]); //the second index carries the denominator
            Fraction createFraction = new Fraction(numerator, denominator);

            if (current == 0) { 
                FractionCounter newCount = new FractionCounter(createFraction); //create new FractionCounter for the Fraction object
                fractions.addFraction(newCount); //add the new object to the ObjectList
                current++; //update current value by +1

            } else {
                boolean counted = false; //if it is not the first iteration of loop
                for (int i = 0; i < fractions.length(); i++) { //iterate over the ObjectList
                    FractionCounter currentCount = fractions.getValue(i);
                    //new FractionCounter object equal to the fraction at index i, checks for all fractions already in the ObjectList

                    if (currentCount.compareAndIncrement(createFraction)) { //if the currentCount is equal to the createFraction, boolean is set true

                        counted = true; //this fraction has already been added
                        break; //end, because we don't want to add duplicates to the ObjectList
                    }
                }
                if (counted == false){ //if currentCount was not equal to createFraction
                    FractionCounter newCurrentCount = new FractionCounter(createFraction);
                    //create new FractionCounter object with createFraction fraction object

                    fractions.addFraction(newCurrentCount);
                    //and add this fraction to the ObjectList

                }
            }
        } while (in.hasNextLine()); //continue this loop while there is a next line in the input file

        in.close(); //close the Scanner object

        System.out.println(fractions.toString()); //print the values in the ObjectList

    }
}