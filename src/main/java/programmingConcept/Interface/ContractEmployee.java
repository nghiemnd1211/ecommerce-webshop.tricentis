package programmingConcept.Interface;

public class ContractEmployee extends Employee implements Bonus {
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
        return super.toString()+ " and the salary of Contract Employee is: $"+ this.salary;
    }
    @Override
    public double getBonus() {
        return 50;
    }
    public double getTotal(){
        double total_salary = this.salary+this.getBonus();
        return total_salary;
    }
}
