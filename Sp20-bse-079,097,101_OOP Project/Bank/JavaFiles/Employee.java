
package Bank;

import java.io.*;

public class Employee extends Person implements Serializable {
    private int employeId;
   private double salary;
   private String designation;

    

    public Employee( String firstName, String lastName, String phoneNum, String address,int employeid, String designation,double salary) {
        super(firstName, lastName, phoneNum, address);
        this.employeId = employeid;
        this.salary = salary;
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    @Override
    public String toString() {
        return "---------Employee Details---------" + super.toString() + "Employee Id: " + employeId + "\tDesignation: " + designation + "\nSalary: "+ salary;
    }
   

}
