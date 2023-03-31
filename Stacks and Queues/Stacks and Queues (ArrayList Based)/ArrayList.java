/* Author: Hadi Chohan
 * Teacher: Professor Kalmin
 * Date: 10/21/2022
 */
import java.util.*;
public class ArrayList {
    private Object[] array = new Object[1];
    private int count;

    //inserts new element at location, index-location is to be placed

    public void insert(Object object, int index){
        if(index > this.size()){
            System.out.println("Index " + index + " outside of list size; max: " + this.size());
            System.exit(0);
        }
        int count = 0;
        try {
            Object[] other = new Object[this.array.length+1];
            switch(index){
                case 0:{
                        other[0] = object;
                        for(int i = 1;i<this.array.length;i++)
                            other[i] = this.array[i-1];

                        this.array = other;
                        break;
                }
                default: {
                        for(int i = 0;i < index;i++)
                            other[i] = this.array[i];
                        other[index] = object;
                        for(int j = index + 1;j < this.array.length;j++)
                            other[j] = this.array[j];
                        this.array = other;
                        break;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            largerArray();
            if(++count == 2){
                System.out.println("Oops! Something went wrong.");
                System.exit(0);
            } 
        }
    }

    public void append(Object o){
        try{
            array[count++] = o;
        }
        catch (ArrayIndexOutOfBoundsException e){
            array = Arrays.copyOf(array, array.length + 100);
            array[count++] = o;
        }
    }

    //Removes element at index

    public Object remove(int index){
        if(index>this.size()){
            System.out.println("Index "+index +" outside of list size; max: " +this.size());
            System.exit(0);
        }
        Object temp = this.array[index];
        int count = 0;
        try {
            Object[] other = new Object[this.array.length-1];
            switch(index){
                case 0:{
                        other[0] = this.array[1];
                        for(int j = 1;j<this.size();j++)
                            other[j] = this.array[j+1];

                        this.array = other;
                        break;
                    }
                default: {
                        for(int j = 0;j<index;j++)
                            other[j] = this.array[j];
                        for(int k = index;k<this.size();k++)
                            other[k] = this.array[k+1];
                        this.array = other;
                        break;
                    }
            }
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            largerArray();
            if(++count == 2){
                System.out.println("Something went wrong.");
                System.exit(0);
            } 
        }
        return temp;
    }

    //Copies the array to a new array twice the size.

    public void largerArray(){
        Object[] other = new Object[this.array.length*2];
        System.arraycopy(this.array, 0, other, 0, this.array.length);
        this.array = other;
    }

    // return true if there are null elements

    public boolean isEmpty() {
        boolean bool = true;
        for (Object element : this.array) {
            if(element != null){
                bool = false;
                break;
            }
            else{
                bool = true;
                break;
            }
        }
        return bool;
    }

    //Determines the real length of the array and return length of non-null elements.

    public int size(){
        int count = 0;
        for(int i=0;i<this.array.length;i++){
            if(this.array[i] == null)
                continue;
            else
                count++;
        }
        return count;
    }
    // Converts array to string.
    // return the Array as a string

    public String toString(){
        String string = "";
        for(int i = 0;i<this.size();i++){
            if(i<this.size()-1)
                string += this.array[i]+", ";
            else
                string += this.array[i];
        }
        return string;
    }

    // Similar to get, input the character, retrieve index.

    public int getIndexOf(Object object){
        int index = -1;
        for(int i = 0;i<this.array.length;i++){
            if(this.array[i] == (object))
                index = i;
            else continue;
        }
        return index;
    }

    //Return true, if the elements of the arrays are equivalent.

    public boolean equals(ArrayList object){
        boolean bool = false;
        int thisLength = this.array.length;
        int objectLength = object.array.length;
        if(thisLength > objectLength){
            for(int i=0;i<this.array.length;i++)
                if(this.array[i] == object.array[i])
                    bool = true;
                else{
                    bool = false;
                    break;
                }
        }
        else{
            for(int i=0;i<object.array.length;i++)
                if(this.array[i] == object.array[i])
                    bool = true;
                else{
                    bool = false;
                    break;
                }
        }
        return bool;
    }
    // Getter to check what is at an index

    Object get(int index){
        if (index <= array.length){
            return this.array[index];
        }
        else {
            return "Sorry, the index does not exist.";
        }
    }
}
