
package Bank;

import java.io.*;

public class Account extends Person implements Serializable{
    
    private int accNo;
    private double balance;

    public Account(String firstName, String lastName, String phoneNum, String address, int accNo, double balance) {
        super(firstName,lastName,phoneNum,address);
        this.accNo = accNo;
        this.balance = balance;
    }

    
    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "---------Account Details---------" + super.toString() + "Account Number: " + accNo + "\tBalance: " + balance + '\n';
    }
   

   
}


