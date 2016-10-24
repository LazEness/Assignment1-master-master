package Exceptions;

/**
 * Created by LazEness on 10/12/2016.
 */
public class EmptyListException extends Exception {
    public EmptyListException(){
        super();
    }
    public EmptyListException(String msg){
        super(msg);
    }
}
