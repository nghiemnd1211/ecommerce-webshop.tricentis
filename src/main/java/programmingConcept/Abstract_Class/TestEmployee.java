package programmingConcept.Abstract_Class;

public class TestEmployee {
    public static void main(String[] args) {
        Employee fte_emp = new FulltimeEmployee("Admin","000");
        fte_emp.calculateBiWeeklySalary();
        System.out.println(fte_emp);

        Employee ctr_emp = new ContractEmployee("Nghiem","001");
        ctr_emp.calculateBiWeeklySalary();
        System.out.println(ctr_emp);
    }
}
