
public class GroceryException extends RuntimeException{
    public GroceryException(){
        super("Item not found");
    }

    public GroceryException(String msg) {
        super(msg);
    }
}
