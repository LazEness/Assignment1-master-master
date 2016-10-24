package Test;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyListException;
import Model.User;
import Utils.ArrayOrderedList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LazEness on 10/12/2016.
 */
public class ArrayOrderedListTest<E extends Comparable> {
    public ArrayOrderedList<User> list = new ArrayOrderedList<User>();

    @Test
    public void add() throws Exception {
        list.add(new User("Sam", "pass1"));
        list.add(new User("Bob", "pass2"));
        list.add(new User("Jack", "pass3"));
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void remove() throws Exception {
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

    @org.junit.Test
    public void String() {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        list.add(Sam);
        list.add(Jack);
        list.add(Tanner);
        Assert.assertFalse(list.toString().equals("User{userName='Jack', email='', phoneNumber='', password='pass3'} User{userName='Sam', email='', phoneNumber='', password='pass1'} User{userName='Tanner', email='', phoneNumber='', password='pass2'}"));

    }
}
