package Bank;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address;

    public Person(String firstName, String lastName, String phoneNum, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "\nFirstName: " + firstName + "\tLastName: " + lastName + "\nPhone Number: " + phoneNum + "\tAddress: " + address + '\n';
    }
    
}
