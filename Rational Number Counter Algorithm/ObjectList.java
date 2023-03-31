
public class ObjectList {
    private int numElements = 0; //counter starts at 0
    private FractionCounter[]fractionList = new FractionCounter[100]; //new int array that can hold 100 elements
  
    public void addFraction(FractionCounter f){
        fractionList[numElements++] = f;
        //set the element of array equal to f, then increment counter numElements by 1 each time
    }
  
    public FractionCounter getValue(int i){
        return fractionList[i];
        //returns the value 
    }
  
    public int length() {
        return numElements; //returns the number of fractions we've saved into the ObjectList
    }
  
    public String toString (){
        String retVal = "";
        for (int i =0; i < numElements; i++){ //iterate over array
            retVal += fractionList[i] + "\n"; //add the value of each element to the string with a comma separating terms
        }
        return retVal; //return String var
    }
  
}