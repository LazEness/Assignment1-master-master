package Model;
import Utils.ArrayIndexedList;

public class UserList extends ArrayIndexedList {
    private static ArrayIndexedList<User> users = new ArrayIndexedList<>();
    public static ArrayIndexedList <User> getUsers(){
        return users;
    }
    public static void setUsers(ArrayIndexedList<User> users){
        UserList.users = users;
    }
}
