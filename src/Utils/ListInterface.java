package Utils;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public interface ListInterface <E extends Comparable> {
    public void add(E element);
    public E remove(E element) throws EmptyListException, ElementNotFoundException;;
    public boolean contains(E element) ;
    public boolean isEmpty();
    public int size();
}
