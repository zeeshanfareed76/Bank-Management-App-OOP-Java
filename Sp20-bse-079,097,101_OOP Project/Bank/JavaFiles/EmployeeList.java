package Bank;

import java.io.*;
import java.util.ArrayList;

public class EmployeeList implements Serializable{

    ArrayList<Employee> employes = new ArrayList<>();

    public EmployeeList() {

    }

    public void addEmployee(Employee a) {
        employes.add(a);
        writeFile();
    }

    public Employee searchEmployee(int emId) {
        for (int i = 0; i < employes.size(); i++) {
            if (employes.get(i).getEmployeId() == emId) {
                return employes.get(i);
            }
        }
        System.out.println("Task Failed");
        return null;
    }

    public void deleteEmployee(int accNumber) {
        for (int i = 0; i < employes.size(); i++) {
            if (employes.get(i).getEmployeId()== accNumber) {
                employes.remove(i);

                writeFile();
                System.out.println("Employee Deleted Successfully");
            }
        }
    }

    public void updateEmployee(Employee a) {
        for (int i = 0; i < employes.size(); i++) {
            if (employes.get(i).getEmployeId()== a.getEmployeId()) {
                employes.get(i).setFirstName(a.getFirstName());
                employes.get(i).setLastName(a.getLastName());
                employes.get(i).setPhoneNum(a.getPhoneNum());
                employes.get(i).setAddress(a.getAddress());
                employes.get(i).setSalary(a.getSalary());
                employes.get(i).setDesignation(a.getDesignation());
                writeFile();
                System.out.println("Employee Details have been Modified");
            }
        }
    }

    public void increment(double inc, int acNum) {
        double sal=0;
        for (int i = 0; i < employes.size(); i++) {
            if (employes.get(i).getEmployeId() == acNum) {
                sal=employes.get(i).getSalary();
                sal=sal+sal*(inc/100);
                employes.get(i).setSalary(sal);
            }
        }

        writeFile();

    }

   

    public void writeFile() {
        try {
                    FileOutputStream fos = new FileOutputStream("Employee List");
                    try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                        oos.writeObject(employes);
                        }

                    } catch (IOException ex) {
                        }}



    public void readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
            FileInputStream fis = new FileInputStream("Employee List");
            Object ob;
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            ob = ois.readObject();
        }
            employes = (ArrayList<Employee>) ob;
 
        
}
    public void print() throws IOException, FileNotFoundException, ClassNotFoundException{
        readFile();
        for (int i = 0; i <employes.size(); i++) {
            System.out.println(employes.get(i));
    }
    }
}
