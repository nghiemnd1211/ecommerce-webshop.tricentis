package programmingConcept.Abstract_Class;

public abstract class Employee {

    protected abstract double calculateBiWeeklySalary();
    protected final double Basic_Salary = 1000;
    private String name;
    private String id;
    public Employee(){
    }
    public Employee(String name, String id){
        this.name = name;
        this.id = id;
        System.out.println("Try to print");
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
