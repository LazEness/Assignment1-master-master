package View;

import Model.User;
import Model.UserIO;
import Model.UserList;
import Utils.ArrayIndexedList;
import Utils.LinkedListOrdered;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginView extends Application {
    ArrayIndexedList<User> list = new ArrayIndexedList<User>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        loadListUsers();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public void loadListUsers(){
        try {
            UserList.setUsers((ArrayIndexedList<User>)UserIO.readUsers());
        }catch(IOException e){
            System.err.print("Error Loading User.dat file");
        }catch(ClassNotFoundException e){
            System.err.print("Error reading and casting the UserList file due to User class issues.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
