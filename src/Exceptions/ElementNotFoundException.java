package Exceptions;

/**
 * Created by LazEness on 10/12/2016.
 */
public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(){
        super();
    }
    public ElementNotFoundException(String msg){
        super(msg);
    }
}
