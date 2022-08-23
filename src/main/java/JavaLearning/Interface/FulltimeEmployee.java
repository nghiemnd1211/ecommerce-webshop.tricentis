package JavaLearning.Interface;

public class FulltimeEmployee extends Employee implements Insurance,Bonus {
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
    public String toString(){
        return super.toString() + " and the salary of Fulltime Employee is: "+this.salary;
    }

    @Override
    public double getInsurance() {
        return 100;
    }

    @Override
    public double getBonus() {
        return 50;
    }

    public double getTotal(){
        double total_salary = this.salary+this.getInsurance()+this.getBonus();
        return total_salary;
    }
}
