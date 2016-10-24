package Model;

import java.io.Serializable;

/**
 * Created by edb2785 on 8/29/2016.
 */
public class User extends Person implements Comparable {
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private String profilePicture;

    public User(){
        super();
        this.userName = "";
        this.email = "";
        this.phoneNumber = "";
        this.password = "";
        this.profilePicture = null;
    }
    public User(String userName, String password){
        super();
        this.userName = userName;
        this.password = password;
        this.email = "";
        this.phoneNumber = "";
        this.profilePicture = null;
    }
    public User(String userName, String password, String email, String phoneNumber, String firstName, String lastName, String ssn, String dob, String gender, String profilePicture){
        super(firstName, lastName, ssn, dob, gender);
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.dob = dob;
        this.gender = gender;
        this.profilePicture = profilePicture;
    }


    public String getProfilePicture(){
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture){
        this.profilePicture = profilePicture;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public int compareTo(Object o)throws ClassCastException {
        if (!(o instanceof User))
            throw new ClassCastException("A User object expected.");
        return this.userName.compareTo(((User)o).getUserName());
    }
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
