abstract class Employee {
    protected String name;
    protected int id;
    protected double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary(); // Abstract method to be implemented by subclasses

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + calculateSalary());
    }
}
interface Payable {
    double getPaymentAmount();
}
class FullTimeEmployee extends Employee implements Payable {


    public FullTimeEmployee(String name, int id, double baseSalary) {
        super(name, id, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (baseSalary * 0.2);
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }
}
class ContractEmployee extends Employee implements Payable {
    private double hourlyRate;
    private int hoursWorked;

    public ContractEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }


}
public class Main {

    public static void main(String[] args) {

        FullTimeEmployee a = new FullTimeEmployee("Umar Isakov", 111, 5000);
        ContractEmployee b = new ContractEmployee("Nunmuhammed Kalmamatov", 222, 50, 160);


        System.out.println("Full-Time Employee Details:");
        a.displayEmployeeInfo();


        System.out.println("Contract Employee Details:");
        b.displayEmployeeInfo();
    }
}
