/*
Project made by
-Mujtaba Ahmed-079-
-Umair Arshad-097-
-Zeeshan Fareed-101-

This stimulates a bank's working on 2 entities i.e
-ACCOUNTS-
-EMPLOYEES-

they both have following in common:
-personal details
        Name, Phone Number, Address
for which we used a base class "Person" and derived 2 classes from it.

An acoount has the following attributes:
    -Account Number
    -Balance

A Employee has the following attributes:
    -Employee Id
    -Designation
    -Salary

the we have 2 classes
    -AccountList
    -EmployeeList
which are used to store data regarding both entities, 
AcoountList works out diffrent tasks performed on an Account and intereacts with it
EmployeeList interacts with Employee

It implements following OOP Concepts
-Classes
-Inheritace
-Encapsulation
-Polymorphism
-Interface
-ArrayList
-Exceptions
-File Handling
*/
package Bank;

import java.io.*;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        AccountList a1 = new AccountList();
        EmployeeList e1 = new EmployeeList();
        //ADDING ACCOUNTS
        a1.addAccount(new Account("Mujtaba", "Ahmed", "0349", "Mrp", 548, 8500));
        a1.addAccount(new Account("Zeeshan", "Fareed", "0542", "Isb", 534, 96500));
        a1.addAccount(new Account("Zargham", "Javed", "0684", "Man", 894, 958));
        //ADDING EMPLOYEES
        e1.addEmployee(new Employee("Umair","Arshad","7894","Lhr",221,"Manager",85000));
        
        
        
        //CRUD
        int n = 1;
        Scanner key = new Scanner(System.in);
        while (n != 0) {
            String fn;
            String ln;
            String ph;
            String add;
            String des;
            int accno, senacc, recacc, emId;
            double bal, sal, inc;

            int choice = 0;
            System.out.println("Please Choose which list you want to work on:");
            System.out.println("1.Customer's \n2.Emloyee's");
            choice = key.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please Enter one of the following:");
                    System.out.println("1.Enter new Account\n2.Search Account\n3.Update Account\n4.Delete Account\n5.Withdraw Money\n6.Deposit Money\n7.Transfer Money\n8.Display");
                    choice = key.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("------ADD ACCOUNT--------");
                            System.out.println("Please Enter First Name:");
                            key.nextLine();
                            fn = key.nextLine();
                            System.out.println("Please Enter Last Name:");
                            ln = key.nextLine();
                            System.out.println("Please Enter Phone Number:");
                            ph = key.nextLine();
                            System.out.println("Please Enter Address");
                            add = key.nextLine();
                            System.out.println("Please Enter Account Number");
                            accno = key.nextInt();
                            System.out.println("Please Enter Balance");
                            bal = key.nextDouble();

                            a1.addAccount(new Account(fn, ln, ph, add, accno, bal));
                            System.out.println("Account Added Successfully");
                            break;
                        case 2:
                            System.out.println("------SEARCH ACCOUNT--------");
                            System.out.println("Please Enter Account Number:");
                            key.nextLine();
                            accno = key.nextInt();

                            System.out.println(a1.searchAccount(accno));
                            break;
                        case 3:
                            System.out.println("------UPDATE ACCOUNT--------");
                            System.out.println("Please Enter Updated Details");
                            System.out.println("Please Enter First Name:");
                            key.nextLine();
                            fn = key.nextLine();
                            System.out.println("Please Enter Last Name:");
                            ln = key.nextLine();
                            System.out.println("Please Enter Phone Number:");
                            ph = key.nextLine();
                            System.out.println("Please Enter Address");
                            add = key.nextLine();
                            System.out.println("Please Enter Account Number");
                            accno = key.nextInt();
                            System.out.println("Please Enter Balance");
                            bal = key.nextDouble();
                            a1.updateAccount(new Account(fn, ln, ph, add, accno, bal));
                            break;
                        case 4:
                            System.out.println("------DELETE ACCOUNT--------");
                            System.out.println("Please Enter Account Number to be Deleted");
                            key.nextLine();
                            accno = key.nextInt();
                            a1.deleteAccount(accno);
                            break;
                        case 5:
                            System.out.println("------WITHDRAW MONEY--------");
                            System.out.println("Please Enter Account Details");
                            System.out.println("Please Enter Account Number");
                            accno = key.nextInt();
                            System.out.println("Please Enter Amount to be withdrawn");
                            bal = key.nextDouble();
                            a1.withdraw(bal, accno);
                            break;
                        case 6:
                            System.out.println("------DEPOSIT MONEY--------");
                            System.out.println("Please Enter Account Details");
                            System.out.println("Please Enter Account Number");
                            accno = key.nextInt();
                            System.out.println("Please Enter Amount to be Deposited");
                            bal = key.nextDouble();
                            a1.deposit(bal, accno);
                            break;
                        case 7:
                            System.out.println("------TRANSFER MONEY--------");
                            System.out.println("Please Enter Account Details");
                            System.out.println("Please Enter Sender Account Number");
                            senacc = key.nextInt();
                            System.out.println("Please Enter Reciver Account Number");
                            recacc = key.nextInt();
                            System.out.println("Please Enter Amount to be transfered");
                            bal = key.nextDouble();
                            a1.transfer(bal, senacc, recacc);
                            break;
                        case 8:
                            a1.print();
                            break;
                        default:
                            break;
                    }
                    break;
                    
                    
                case 2:
                    System.out.println("Please Enter one of the following:");
                    System.out.println("1.Enter new Employee\n2.Search Employee\n3.Update Employee\n4.Delete Employee\n5.Increment Salary\n6.Display");
                    choice = key.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("------ADD EMPLOYEE--------");
                            System.out.println("Please Enter First Name:");
                            key.nextLine();
                            fn = key.nextLine();
                            System.out.println("Please Enter Last Name:");
                            ln = key.nextLine();
                            System.out.println("Please Enter Phone Number:");
                            ph = key.nextLine();
                            System.out.println("Please Enter Address");
                            add = key.nextLine();
                            System.out.println("Please Enter Employee Id");
                            emId = key.nextInt();
                            System.out.println("Please Enter Designation");
                            key.nextLine();
                            des = key.nextLine();
                            System.out.println("Please Enter Salaray");
                            sal = key.nextDouble();

                            e1.addEmployee(new Employee(fn, ln, ph, add, emId, des, sal));
                            System.out.println("Account Added Successfully");
                            break;
                        case 2:
                            System.out.println("------SEARCH EMPLOYEE--------");
                            System.out.println("Please Enter Employee Id:");
                            key.nextLine();
                            emId = key.nextInt();

                            System.out.println(e1.searchEmployee(emId));
                            break;
                        case 3:
                            System.out.println("------UPDATE EMPLOYEE--------");
                            System.out.println("PLease Enter Updated Details");
                            System.out.println("Please Enter First Name:");
                            key.nextLine();
                            fn = key.nextLine();
                            System.out.println("Please Enter Last Name:");
                            ln = key.nextLine();
                            System.out.println("Please Enter Phone Number:");
                            ph = key.nextLine();
                            System.out.println("Please Enter Address");
                            add = key.nextLine();
                            System.out.println("Please Enter Employee Id");
                            emId = key.nextInt();
                            System.out.println("Please Enter Designation");
                            key.nextLine();
                            des = key.nextLine();
                            System.out.println("Please Enter Salaray");
                            sal = key.nextDouble();

                            e1.updateEmployee(new Employee(fn, ln, ph, add, emId, des, sal));
                            break;
                        case 4:
                            System.out.println("------DELETE ACCOUNT--------");
                            System.out.println("PLease Enter Id of the Employee to be delted");
                            key.nextLine();
                            emId = key.nextInt();
                            e1.deleteEmployee(emId);
                            break;
                        case 5:
                            System.out.println("------INCREMENT SALARAY--------");
                            System.out.println("PLease Enter Employee Id");
                            key.nextLine();
                            emId = key.nextInt();
                            System.out.println("PLease Increment Percentage");
                            inc = key.nextDouble();
                            e1.increment(inc, emId);
                            break;
                        case 6:
                            e1.print();
                            break;
                        default:
                            break;
                    }
                    break;
            }

            System.out.println("Press 1 to continue and 0 to exit");
            n = key.nextInt();
        }
    }

}
