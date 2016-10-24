package Utils;

import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public interface QueueInterface <E>{
    public void enqueue(E element);
    public E dequeue() throws EmptyListException;
    public boolean isEmpty();
    public int size();
}
