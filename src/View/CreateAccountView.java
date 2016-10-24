package View;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreateAccountView {


    public CreateAccountView() throws Exception {
        Stage CreateAccount = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        CreateAccount.setTitle("Create Account");
        CreateAccount.setScene(new Scene(root, 300, 275));
        CreateAccount.show();
    }

}
