package Utils;

import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public interface StackInterface <E> {
    public void push (E element);
    public E pop() throws EmptyListException;
    public E top() throws EmptyListException;
    public boolean isEmpty();
    public int size();
}
