package Utils;

import Exceptions.EmptyListException;

/**
 * Created by LazEness on 10/12/2016.
 */
public class LinkedListQueue<E> implements QueueInterface <E> {
    private int count=0;
    private Node<E> llPointer;
    private Node<E> current;

    public LinkedListQueue(){
        llPointer = null;
        current = null;
    }
    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<E>(element);
        if (isEmpty()) {
            llPointer = newNode;
            current = llPointer;
        } else {
            current.setPointer(newNode);
            current = current.getPointer();
        }
        count++;
    }

    @Override
    public E dequeue() throws EmptyListException {
        if(isEmpty()) {
            throw new EmptyListException("List is empty.");
        }
        E element = llPointer.getElement();
        llPointer = llPointer.getPointer();
        count--;
        return element;
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
