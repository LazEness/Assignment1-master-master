package Controller;

import Model.User;
import Model.UserIO;
import Model.UserList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountController extends UserList {
    @FXML
    TextField createFirstName;
    @FXML
    TextField createLastName;
    @FXML
    TextField createDOB;
    @FXML
    TextField createUserName;
    @FXML
    PasswordField createPassword;
    @FXML
    PasswordField createConfirmPassword;
    @FXML
    TextField createEmail;
    @FXML
    TextField createPhoneNumber;
    @FXML
    TextField createSSN;
    @FXML
    ChoiceBox createGender;
    @FXML
    TextField profilePicture;


    public void createAccount(MouseEvent mouseEvent) throws Exception {
        if (((isPasswordMatch(createPassword.getText(), createConfirmPassword.getText())) &&
                (isPasswordValid(createPassword.getText())) && (isEmailValid(createEmail.getText()))) &&
                (isSSNValid(createSSN.getText())) && (isPhoneNumberValid(createPhoneNumber.getText()))) {
            boolean userExists = false;
            outerLoop:
            while (!userExists == true) {
                for (int i = 0; i < UserList.getUsers().size(); i++) {
                    if (createUserName.getText().equals(UserList.getUsers().get(i).getUserName())) {
                        System.err.print("Username already exists.");
                        break outerLoop;
                    }
                }
               if (!userExists) {
                    User user = new User(createUserName.getText().toString(), createPassword.getText().toString(), createEmail.getText().toString(), createPhoneNumber.getText().toString(), createFirstName.getText().toString(), createLastName.getText().toString(), createSSN.getText().toString(), createDOB.getText().toString(), createGender.getValue().toString(), profilePicture.getText());
                    UserList.getUsers().add(user);
                    System.out.print(user.toString());
                    userExists = true;
                }
                try {
                    UserIO.writeUsers(UserList.getUsers());
                    System.out.print("Worked");
                } catch (IOException e) {
                    System.err.print("Cannot write Users");
                    e.printStackTrace();

                }
                System.out.print(UserList.getUsers());
                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.close();


            }
        }
    }


    public void openFileChooser(MouseEvent e) {
        Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Profile Picture Browser");
        profilePicture.setText((fileChooser.showOpenDialog(primaryStage)).getAbsolutePath());
    }

    public static boolean isSSNValid(String ssn){
        boolean isValid = false;
        String regex = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";
        CharSequence inputStr = ssn;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isEmailValid(String email){
        boolean isValid = false;
        String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]{0,10})*@[A-Za-z0-9]+(\\.[A-Za-z0-9]{0,10})*(\\.[A-Za-z]{0,5})$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isPhoneNumberValid(String phoneNumber){
        boolean isValid = false;
        String regex = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isPasswordMatch(String password1, String password2){
        boolean isValid = false;
        if (password1.equals(password2)){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isPasswordValid(String password){
        boolean isValid = false;
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$&+,:;=?@#|'<>.^*()%!-]).{1,}$";
        CharSequence inputStr = password;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }

}

