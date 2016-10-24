package Utils;

import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public class BoundedArrayStack<E> implements BoundedStackInterface<E> {
    private E [] element;
    private final int SIZE = 100;
    private int size = 0 ;
    private int capacity = 0;
    @SuppressWarnings({"unchecked"})
    public BoundedArrayStack(){
        this.capacity = SIZE;
        element = (E[])(new Object[SIZE]);
    }
    @SuppressWarnings({"unchecked"})
    public BoundedArrayStack(int size){
        this.capacity = size;
        element = (E[])(new Object[capacity]);
    }
    @Override
    public void push(E element) {
        this.element[size] = element;
        size ++;
    }

    @Override
    public E pop() throws EmptyListException{
        E temp = this.element[size];
        this.element[size] = null;
        size --;
        return temp;
    }

    @Override
    public E top() throws EmptyListException {
        return this.element[size];
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public int size() {
        return size;
    }
}
