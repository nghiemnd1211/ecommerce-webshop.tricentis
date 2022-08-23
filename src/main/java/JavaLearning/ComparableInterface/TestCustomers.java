package JavaLearning.ComparableInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCustomers {
    public static void main(String[] args) {
        List<Customers> customers = new ArrayList<>();
        Customers cus1 = new Customers("AAA",111);
        Customers cus2 = new Customers("ZZZ",112);
        Customers cus3 = new Customers("BBB", 113);

        customers.add(cus1);
        customers.add(cus2);
        customers.add(cus3);

        System.out.println("BEFORE sorting");
             for (Customers customer : customers) {
                 System.out.println(customer);
             }

        System.out.println("\nAFTER sorting");
        Collections.sort(customers);
            for (Customers customer : customers) {
            System.out.println(customer);
            }
    }
}
