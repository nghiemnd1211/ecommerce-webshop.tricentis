package programmingConcept.Interface;

public abstract class Employee {

    protected abstract double calculateBiWeeklySalary();
    protected final double Basic_Salary = 1000;
    private String name;
    private String id;
    public Employee(String name, String id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
