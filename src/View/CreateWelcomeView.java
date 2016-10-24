package View;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class CreateWelcomeView {



    public CreateWelcomeView() throws Exception {
        Stage CreateWelcomeView = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        CreateWelcomeView.setTitle("Welcome");
        CreateWelcomeView.setScene(new Scene(root, 600, 600));
       // welcomeUserName.setText(user);
        CreateWelcomeView.show();
    }
}
