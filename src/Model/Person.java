package Model;

/**
 * Created by edb2785 on 8/29/2016.
 */
public class Person {
    protected String firstName;
    protected String lastName;
    protected String ssn;
    protected String dob;
    protected String gender;

    public Person(){
        this.firstName = "";
        this.lastName = "";
        this.ssn = "";
        this.dob = "";
        this.gender = "";
    }
    public Person(String firstName, String lastName, String ssn, String dob, String gender ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.dob = dob;
        this.gender = gender;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getssn(){
        return ssn;
    }
    public void setssn(String ssn){
        this.ssn = ssn;
    }
    public String getdob(){
        return dob;
    }
    public void setdob(String dob){
        this.dob = dob;
    }
    public String getGender(String gender){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
