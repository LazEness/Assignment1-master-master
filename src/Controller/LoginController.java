package Controller;

import Model.User;
import Model.UserList;
import Utils.LinkedListOrdered;
import View.CreateAccountView;
import View.CreateWelcomeView;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.lang.model.element.Element;

import static Utils.LinkedListOrdered.*;

public class LoginController {
    @FXML
    TextField userName;
    @FXML
    PasswordField password;

    public void authenticate(MouseEvent mouseEvent) throws Exception {
        for (int i = 0; i < UserList.getUsers().size(); i++) {
            if (userName.getText().equals(UserList.getUsers().get(i).getUserName()) && password.getText().equals(UserList.getUsers().get(i).getPassword())) {
                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.close();
                openWelcomeView();

            }
        }
    }


    public void openCreateAccountView() throws Exception {
        new CreateAccountView();
    }
    public void openWelcomeView() throws Exception {
        new CreateWelcomeView();
    }

}



