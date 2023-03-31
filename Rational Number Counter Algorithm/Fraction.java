public class Fraction {
    private int numerator = 1;
    private int denominator = 1;
  
    public Fraction(int n, int d){
        setNumerator(n);
        setDenominator(d);
        setReduce(n, d);
    }

    public Fraction() { }
  
    public int gcdReduce(int n, int d) { // From StackOverflow.
        int gcd = (d == 0? n : gcdReduce(d, n % d));
        return gcd;
    }


    public void setReduce(int n, int d){
        int gcd = gcdReduce(n,d); //call gcdReduce with n, d
        this.numerator = (n/gcd); //set numerator to numerator/gcd
        this.denominator = (d/gcd); //set denominator to denominator/gcd
    }
  
    public String toString(){
        return numerator + "/" + denominator;
    }


    @Override
    public boolean equals(Object other){
        if (other == null){ //if input param is null/nonexistent, return false
            return false;
        }
        if (other instanceof Fraction == false){ //if input param is not a Fraction object then return false
            return false;
        }
        //if input is a Fraction object then compare its numerator and denominator to the numerator and denominator Fraction class variables
        Fraction that = (Fraction) other;
        return this.numerator == that.numerator &&
                this.denominator == that.denominator; //returns true if equal
    }

    public int getNumerator() {
        return numerator; //return numerator
    }
  
    public void setNumerator(int num) {
        this.numerator = num; //sets numerator
        //don't have to check if input is 0 this time because you can divide 0 by a number, which equals 0
    }

    public int getDenominator() {
        return denominator; //return denominator
    }

    public void setDenominator(int denom) {
        if (denom == 0) { //if input denom is 0, print error since you cannot divide a number by 0
            System.out.println("Invalid fraction.");
        }
        else { //if input is 0 then set it to the denominator
            this.denominator = denom;
        }
    }

}