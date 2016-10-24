package Utils;

import Exceptions.EmptyListException;
import Model.User;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Created by LazEness on 10/12/2016.
 */
public class ArrayOrderedList <E extends Comparable> implements ListInterface<E>{
    private final int SIZE = 100;
    private int end = 0;
    private E[] list;
    @SuppressWarnings({"unchecked"})
    public ArrayOrderedList() {
        list = (E[]) new Comparable[SIZE];
    }
    @SuppressWarnings({"unchecked"})
    public ArrayOrderedList(int capacity) {
        list = (E[]) (new Object[capacity]);
    }
    @SuppressWarnings({"unchecked"})
    @Override
    public void add(E element) {
        if (size() == list.length)
            expandCapacity();

        Comparable<E> temp = (Comparable<E>) element;

        int count = 0;
        while (count < end && temp.compareTo(list[count]) > 0)
            count++;

        for (int count2=end; count2 > count; count2--)
            list[count2] = list[count2-1];

        list[count] = element;
        end++;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public E remove(E element) throws EmptyListException {
        E removed = element;
        E[] temp = (E[])new Comparable[list.length - 1];
        for(int i = 0, j = 0; i < list.length; i++){
            if (list[i] != element) {
                temp[j++] = list[i];
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
        return (end == 0);
    }

    @Override
    public int size() {
        return end;
    }
    @SuppressWarnings({"unchecked"})
    private void expandCapacity()
    {
        E[] larger = (E[])(new Object[list.length*2]);

        for (int count=0; count < list.length; count++)
            larger[count] = list[count];

        list = larger;
    }

    public String toString(){

        String tostring = "";
        for (int count=0; count < end; count++)
            tostring = list[count].toString();
        return tostring;
    }
}
