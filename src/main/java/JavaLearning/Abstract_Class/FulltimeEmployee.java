package JavaLearning.Abstract_Class;

public class FulltimeEmployee extends Employee {
    private final double RATE = 1;
    private double salary;

    public FulltimeEmployee(String name, String id){
        super(name,id);
    }
    @Override
    protected double calculateBiWeeklySalary() {
        double salary = Basic_Salary*RATE;
        this.salary = salary;
        return this.salary;
    }

    @Override
    public String toString() {
        return super.toString()+ " and the salary of Contract Employee is: "+this.salary;
    }
}
