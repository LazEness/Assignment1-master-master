package Utils;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public interface IteratorInterface<E extends Comparable> {
    public void reset();
    public E next();
    public boolean hasNext();
    public E getNext(E element) throws ElementNotFoundException;
    public boolean hasNext(E element) throws ElementNotFoundException;
}
