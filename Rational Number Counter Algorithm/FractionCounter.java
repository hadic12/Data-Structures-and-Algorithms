public class FractionCounter {

    private Fraction theFraction; //new Fraction object
    private int counter = 1; //new int counter variable
  
    FractionCounter(Fraction fraction){
        this.theFraction = fraction;
    }

    public String toString(){
        String retVal = theFraction.toString() + " has a count of " + counter;
        return retVal; //return the String retVal
    }

    public boolean compareAndIncrement(Fraction newFraction){
        if (theFraction.equals(newFraction)){ //if the two fractions are equal
            counter++; //increment the counter variable
            return true; //return boolean true
        } else {
            return false; //if not equal, return false
        }
    }
}