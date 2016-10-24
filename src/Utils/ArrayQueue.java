package Utils;

import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public class ArrayQueue<E> implements QueueInterface<E> {
    private final int SIZE = 100;
    private int end;
    private E[] queue;

    public ArrayQueue() {
        end = 0;
        queue = (E[]) new Object[SIZE];
    }

    public ArrayQueue(int capacity) {
        end = 0;
        queue = (E[]) (new Object[capacity]);
    }
    @Override
    public void enqueue(E element) {
        if (size() == queue.length)
            expandCapacity();

        queue[end] = element;
        end++;
    }
    @Override
    public E dequeue() throws EmptyListException
    {
        if (isEmpty())
            throw new EmptyListException("empty");

        E result = queue[0];

        end--;

        for (int count=0; count < end; count++)
            queue[count] = queue[count+1];

        queue[end] = null;

        return result;
    }
    @Override
    public boolean isEmpty()
    {
        return (end == 0);
    }
    @Override
    public int size()
    {
        return end;
    }
    public String toString()
    {
        String result = "";

        for (int count=0; count < end; count++)
            result = result + queue[count].toString() + "\n";

        return result;
    }
    private void expandCapacity()
    {
        E[] larger = (E[])(new Object[queue.length*2]);

        for (int count=0; count < queue.length; count++)
            larger[count] = queue[count];

        queue = larger;
    }


}
