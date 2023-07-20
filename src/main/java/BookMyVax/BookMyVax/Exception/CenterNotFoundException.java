package BookMyVax.BookMyVax.Exception;

public class CenterNotFoundException extends RuntimeException{

    public CenterNotFoundException(String message){
        super(message);
    }
}
