package JavaLearning.Abstract_Class;

public class ContractEmployee extends Employee{
    private final double RATE = 0.8;
    private double salary;
    public ContractEmployee(String name, String id) {
        super(name, id);
    }

    @Override
    protected double calculateBiWeeklySalary() {
        double salary = RATE * Basic_Salary;
        this.salary = salary;
        return this.salary;
    }
    public String toString() {
        return super.toString()+ " and the salary of Contract Employee is: $"+this.salary;
    }
}
