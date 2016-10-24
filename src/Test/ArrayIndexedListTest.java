package Test;

import Exceptions.EmptyListException;
import Model.User;
import Utils.ArrayIndexedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by LazEness on 10/12/2016.
 */
 public class ArrayIndexedListTest<E extends Comparable> implements Iterator {
    ArrayIndexedList<User> list = new ArrayIndexedList<User>();

    @Test
    public void add() throws Exception {
        list.add(new User("Sam", "pass1"));
        list.add(new User("Bob", "pass2"));
        list.add(new User("Jack", "pass3"));
        Assert.assertFalse(list.isEmpty());
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Test
    public void remove() {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        User Wit = new User("Wit", "pass4");

        list.add(Sam);
        list.add(Jack);
        list.add(Tanner);
        list.add(Wit);
        try {
            list.remove(Sam);
        } catch (EmptyListException e) {
            System.err.print("List is empty.");
        }
        try {
            list.remove(Jack);
        } catch (EmptyListException e) {
            System.err.print("List is empty.");
        }
        try {
            list.remove(Tanner);
        } catch (EmptyListException e) {
            System.err.print("List is empty.");
        }
        try {
            list.remove(Wit);
        } catch (EmptyListException e) {
            System.err.print("List is empty.");
        }
        Assert.assertTrue(list.isEmpty());

    }

    @Test
    public void contains() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        User Wit = new User("Wit", "pass4");

        list.add(Sam);
        list.add(Jack);
        list.add(Tanner);
        list.add(Wit);
        Assert.assertTrue(list.contains(Tanner));
    }

    @Test
    public void isEmpty() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        list.add(Tanner);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void size() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        User Wit = new User("Wit", "pass4");

        list.add(Sam);
        list.add(Jack);
        list.add(Tanner);
        list.add(Wit);
        Assert.assertTrue(list.size() == 4);
    }
    
}


