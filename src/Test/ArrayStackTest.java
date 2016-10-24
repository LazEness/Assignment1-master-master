package Test;

import Model.User;
import Utils.ArrayStack;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LazEness on 10/12/2016.
 */
public class ArrayStackTest<E extends Comparable> {
    public ArrayStack<User> list = new ArrayStack<User>();

    @Test
    public void push() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        User Wit = new User("Wit", "pass4");

        list.push(Sam);
        list.push(Jack);
        list.push(Tanner);
        list.push(Wit);

        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void pop() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        User Wit = new User("Wit", "pass4");

        list.push(Sam);
        list.push(Jack);
        list.push(Tanner);
        list.push(Wit);

        list.pop();
        list.pop();
        list.pop();
        list.pop();

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void top() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        User Wit = new User("Wit", "pass4");

        list.push(Sam);
        list.push(Jack);
        list.push(Tanner);
        list.push(Wit);

        Assert.assertTrue(list.top().equals(Wit));
    }

    @Test
    public void isEmpty() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        list.push(Tanner);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void size() throws Exception {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        User Wit = new User("Wit", "pass4");

        list.push(Sam);
        list.push(Jack);
        list.push(Tanner);
        list.push(Wit);
        Assert.assertTrue(list.size() == 4);
    }

    @org.junit.Test
    public void String() {
        User Tanner = new User("Tanner", "pass2");
        User Sam = new User("Sam", "pass1");
        User Jack = new User("Jack", "pass3");
        list.push(Sam);
        list.push(Jack);
        list.push(Tanner);
        Assert.assertFalse(list.toString().equals("User{userName='Jack', email='', phoneNumber='', password='pass3'} User{userName='Sam', email='', phoneNumber='', password='pass1'} User{userName='Tanner', email='', phoneNumber='', password='pass2'}"));

    }
}