package Utils;

import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public class ArrayIndexedList<E extends Comparable> implements ListInterface <E> {
    private final int SIZE = 100;
    private int end = 0;
    private E[] list;
    @SuppressWarnings({"unchecked"})
    public ArrayIndexedList() {
        list = (E[]) new Comparable[SIZE];
    }
    @SuppressWarnings({"unchecked"})
    public ArrayIndexedList(int capacity) {
        list = (E[]) (new Object[capacity]);
    }

    @Override
    public void add(E element) {
        if (size() == list.length)
            expandCapacity();
        list[end+1] = element;
        end++;

    }
    @SuppressWarnings({"unchecked"})
    @Override
    public E remove(E element) throws EmptyListException {
        E removed = element;
        E[] temp = (E[])(new Comparable[list.length - 1]);
        for(int i = 0, j = 0; i < list.length; i++){
            if (list[i] != element) {
                temp[j++] =  list[i];
            }
        }
        list = temp;
        end--;
        return removed;
    }

    @Override
    public boolean contains(E element) {
        for(int i = 0; i < list.length; i++) {
            if (list[i] == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return end == 0;
    }


    public E get(int i) {
        return  list[i];
    }

    @Override
    public int size() {
        return end;
    }
    @SuppressWarnings({"unchecked"})
    private void expandCapacity(){
        E[] larger = (E[])(new Object[list.length*2]);

        for (int count=0; count < list.length; count++)
            larger[count] =  list[count];

        list = larger;
    }

    public String toString(){

        String tostring = "";
        for (int count=0; count < list.length; count++)
            tostring += list[count].toString();
        return tostring;
    }
}
