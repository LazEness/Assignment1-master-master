package Utils;

import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public class ArrayStack<E> implements StackInterface<E>{
    private int cap = 100;
    int size = 0;
    private E[] list;
    @SuppressWarnings({"unchecked"})
    public ArrayStack(){
        list = (E[]) new Object[cap];
    }
    @SuppressWarnings({"unchecked"})
    public ArrayStack(int capacity){
        this.cap = capacity;
        list = (E[]) new Object[capacity];
    }
    @Override
    public void push(E element) {
        if (isFull()) {
            enlarge();
        }
        list[size] = element;
        size++;
    }

    @Override
    public E pop() throws EmptyListException {
        if (size == 0) throw new EmptyListException("Stack is empty.");
        E element = list[size];
        list[size] = null;
        size --;
        return element;
    }

    @Override
    public E top() throws EmptyListException {
        if (isEmpty()){
            throw new EmptyListException("Stack is empty.");
        }
        return list[size-1];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }
    @SuppressWarnings({"unchecked"})
    private void enlarge(){
            E[] larger = (E[])(new Object[list.length*2]);

            for (int count=0; count < list.length; count++)
                larger[count] = list[count];

            list = larger;
    }
    private boolean isFull(){
        return size == cap ;
    }

    public String toString(){

        String tostring = "";
        for (int count=0; count < size; count++)
            tostring = list[count].toString();
        return tostring;
    }
}
