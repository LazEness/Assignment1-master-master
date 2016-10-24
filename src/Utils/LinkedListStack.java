package Utils;

import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public class LinkedListStack<E> implements StackInterface <E> {
    private int count=0;
    private Node<E> llPointer;
    private Node<E> current;

    public LinkedListStack(){
        llPointer = null;
        current = null;
    }
    @Override
    public void push(E element) {
        Node<E> newNode = new Node<E>(element);
        if (isEmpty()) {
            llPointer = newNode;
            current = llPointer;
        } else {
            newNode.setPointer(current);
            current = newNode;
        }
        count++;
    }
    @Override
    public E pop() throws EmptyListException{
        if(isEmpty()) {
            throw new EmptyListException("List is empty.");
        }
        E temp = current.getElement();
        current = current.getPointer();
        count --;
        return temp;
    }

    @Override
    public E top() {
        return current.getElement();
    }

    @Override
    public boolean isEmpty() {
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
