package Test;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyListException;
import Model.User;
import Utils.LinkedListOrdered;
import org.junit.Assert;

import java.util.Iterator;

/**
 * Created by LazEness on 10/12/2016.
 */
public class LinkedListOrderedTest {
    LinkedListOrdered<User> list = new LinkedListOrdered<User>();

    @org.junit.Test
    public void add1() throws Exception {
        list.add(new User("Sam", "pass1"));
        list.add(new User("Bob", "pass2"));
        list.add(new User("Jack", "pass3"));
        Assert.assertFalse(list.isEmpty());

    }

    @org.junit.Test
    public void remove() {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        User Wit = new User("Wit", "pass4");

        list.add(Sam);
        list.add(Jack);
        list.add(Tanner);
        list.add(Wit);
        try{
            list.remove(Sam);
        } catch(EmptyListException e){
            System.err.print("List is empty.");
        }catch(ElementNotFoundException e){
            System.err.print("Sam does not exist in the list.");
        }
        try{
            list.remove(Jack);
        } catch(EmptyListException e){
            System.err.print("List is empty.");
        }catch(ElementNotFoundException e){
            System.err.print("Jack does not exist in the list.");
        }
        try{
            list.remove(Tanner);
        } catch(EmptyListException e){
            System.err.print("List is empty.");
        }catch(ElementNotFoundException e){
            System.err.print("Bob does not exist in the list.");
        }
        try{
            list.remove(Wit);
        } catch(EmptyListException e){
            System.err.print("List is empty.");
        }catch(ElementNotFoundException e){
            System.err.print("Wit does not exist in the list.");
        }
        Assert.assertTrue(list.isEmpty());
    }

    @org.junit.Test
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

    @org.junit.Test
    public void isEmpty() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        list.add(Tanner);
        Assert.assertFalse(list.isEmpty());
    }

    @org.junit.Test
    public void size() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        User Wit = new User("Wit", "pass4");

        list.add(Sam);
        list.add(Jack);
        list.add(Tanner);
        list.add(Wit);
        Assert.assertTrue(list.size()==4);
    }

    @org.junit.Test
    public void String()  {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        list.add(Sam);
        list.add(Jack);
        list.add(Tanner);
        Assert.assertFalse(list.toString().equals("User{userName='Jack', email='', phoneNumber='', password='pass3'} User{userName='Sam', email='', phoneNumber='', password='pass1'} User{userName='Tanner', email='', phoneNumber='', password='pass2'}"));
    }



}