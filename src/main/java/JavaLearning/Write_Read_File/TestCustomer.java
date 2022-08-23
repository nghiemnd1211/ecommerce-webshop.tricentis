package JavaLearning.Write_Read_File;

import java.util.ArrayList;
import java.util.List;

public class TestCustomer {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        Customer cus1 = new Customer("John", 101);
        Customer cus2 = new Customer("Smith", 102);
        Customer cus3 = new Customer("Bob", 103);
        Customer cus4 = new Customer("Nghiem", 111);
        Customer cus5 = new Customer("Admin", 112);

        customers.add(cus1);
        customers.add(cus2);
        customers.add(cus3);
        customers.add(cus4);
        customers.add(cus5);

        String path = "D:\\TestData.txt";
        System.out.println(DataFactory.isSavingCustomerList(customers, path));

        /*READ DATA*/
        List<Customer> readCustomerList = DataFactory.ReadCustomerList(path);
        System.out.println("Name\tId");
        for (Customer customer : readCustomerList) {
            System.out.println(customer.getName() + "\t" + customer.getId());
        }


    }

}
