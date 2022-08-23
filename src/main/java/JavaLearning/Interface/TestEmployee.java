package JavaLearning.Interface;

public class TestEmployee {

    public static void main(String[] args) {
        FulltimeEmployee fte_emp = new FulltimeEmployee("Admin","000");
        fte_emp.calculateBiWeeklySalary();
        System.out.println("Total salary of Full time Employee with Bonus and Insurance: $"+fte_emp.getTotal());

        ContractEmployee ctr_emp = new ContractEmployee("Nghiem","001");
        ctr_emp.calculateBiWeeklySalary();
        System.out.println("Total salary of Full time Employee with Bonus only: $"+ctr_emp.getTotal());
    }
}

