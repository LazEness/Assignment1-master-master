package Utils;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyListException;

import java.util.Comparator;

/**
 * Created by LazEness on 10/12/2016.
 */
public class LinkedListOrdered<E extends Comparable>implements ListInterface<E> {
    private Node<E> llPointer;
    private Node<E> current;
    private Node<E> previous;
    private int count = 0;

    public LinkedListOrdered(){
        llPointer = null;
        current = null;
        previous = null;
    }
    @Override
    public void add(E element){
        Node<E>newNode = new Node<E>(element);
        if (isEmpty()){
            llPointer = newNode;
        }else{
            current = llPointer;
            previous = llPointer;
            while(current != null){
                if(element.compareTo(current.getElement()) < 0){
                    if(llPointer.equals(current)){
                        llPointer = newNode;
                    } else{
                        previous.setPointer(newNode);
                    }
                    newNode.setPointer(current);
                    break;
                }
                previous = current;
                current = current.getPointer();
            }
            if(current == null){
                previous.setPointer(newNode);
            }
        }
        count ++;
    }
    @Override
    public E remove(E element) throws EmptyListException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyListException("List is empty.");
        }
        current = llPointer;
        previous = llPointer;
        while (current != null) {
            if (element.compareTo(current.getElement()) == 0) {
                if(llPointer.equals(current)){
                    llPointer = llPointer.getPointer();
                    current = llPointer;
                    previous = llPointer;
                    count--;
                    return element;
                }
                previous.setPointer(current.getPointer());
                current = (current.getPointer());
                count--;
                return element;
            }
            previous = current;
            current = current.getPointer();
        }
        throw new ElementNotFoundException(element +" does not exist in list.");
    }

    public E get(){
        return current.getElement();

    }
    @Override
    public boolean contains(E element){
        boolean found = false;
        current = llPointer;
        while(current != null){
            if(element.equals(current.getElement())){
                found = true;
                break;
            }
            current = current.getPointer();
        }
        return found;
    }
    @Override
    public boolean isEmpty(){
        return llPointer == null;
    }

    @Override
    public int size() {
        return count;
    }

    public String toString(){
        Node<E> current = llPointer;
        String list = "";
        while(current != null){
            list += current.getElement() + " ";
            current = current.getPointer();
        }
        return list;
    }


}
