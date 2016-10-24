package Utils;

/**
 * Created by LazEness on 10/12/2016.
 */
public class Node<T> {
    T element;
    Node<T> pointer;
    public Node(){
        element = null;
        pointer = null;
    }
    public Node(T element){
        this.element = element;
        pointer = null;
    }
    public Node(T element, Node<T> pointer){
        this.element = element;
        this.pointer = pointer;
    }
    public T getElement(){
        return element;
    }
    public void setElement(T element){
        this.element = element;
    }
    public Node<T> getPointer(){
        return pointer;
    }
    public void setPointer(Node<T> pointer){
        this.pointer = pointer;
    }
}
