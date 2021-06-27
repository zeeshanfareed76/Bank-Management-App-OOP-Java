
package Bank;


import java.io.*;
import java.util.ArrayList;


public class AccountList implements Serializable{
    
    ArrayList<Account> accounts = new ArrayList<>();

    public AccountList() {
         
    }
    public  void addAccount(Account a){
        accounts.add(a);
        writeFile();
    }
    public  Account searchAccount(int accNumber){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccNo() == accNumber) {
                return accounts.get(i);
            }
        }
        System.out.println("Task Failed");
        return null;
    }
    public void deleteAccount(int accNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccNo() == accNumber) {
                accounts.remove(i);

                writeFile();
                System.out.println("Account Deleted Successfully");
            }
        }
    }
    public  void updateAccount(Account a){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccNo() == a.getAccNo()) {
                accounts.get(i).setFirstName(a.getFirstName());
                accounts.get(i).setLastName(a.getLastName());
                accounts.get(i).setPhoneNum(a.getPhoneNum());
                accounts.get(i).setAddress(a.getAddress());
                accounts.get(i).setAccNo(a.getAccNo());
                accounts.get(i).setBalance(a.getBalance());
                
                writeFile();
                System.out.println("Account Details have been Modified");
            }
        }
    }
    public void withdraw( double amount, int acNum) {

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccNo() == acNum) {
                if (amount > accounts.get(i).getBalance()) {
                    System.out.println("Insufficent Balance");
                } else {
                    accounts.get(i).setBalance(accounts.get(i).getBalance() - amount);
                    System.out.println("Transaction Successful");
                }

            }
        }

        writeFile();

    }
    public void deposit(double amount, int acNum) {

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccNo() == acNum) {
                accounts.get(i).setBalance(accounts.get(i).getBalance() + amount);
                System.out.println("Transaction Successful");
            }
        }

        writeFile();

    }
    public  void transfer( double amount, int senderacc, int reciveracc) {

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccNo() == senderacc && amount > accounts.get(i).getBalance()) {
                System.out.println("Insufficent Balance");
            } else if (accounts.get(i).getAccNo() == senderacc && amount < accounts.get(i).getBalance()) {
                accounts.get(i).setBalance(accounts.get(i).getBalance() - amount);
                System.out.println(amount + " Sent to: " + reciveracc);

            }
        }
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccNo() == reciveracc) {
                accounts.get(i).setBalance(accounts.get(i).getBalance() + amount);
                System.out.println(amount + " Recived from: " + senderacc);
            }
        }
        writeFile();
    }
    public void writeFile() {
         try {
                    FileOutputStream fos = new FileOutputStream("Accounts");
                    try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                        oos.writeObject(accounts);
                        }

                    } catch (IOException ex) {
                        }
    }

    public void readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
            FileInputStream fis = new FileInputStream("Accounts");
            Object ob;
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            ob = ois.readObject();
        }
            accounts = (ArrayList<Account>) ob;
 
        
} 
public void print() throws IOException, FileNotFoundException, ClassNotFoundException{
        readFile();
        for (int i = 0; i <accounts.size(); i++) {
            System.out.println(accounts.get(i));
    }
    }

}
