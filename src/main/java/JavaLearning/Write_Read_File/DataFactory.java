package JavaLearning.Write_Read_File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    public static boolean isSavingCustomerList(List<Customer>customers, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (Customer customer : customers) {
                String dataLine = customer.getName() + ";" + customer.getId();
                bufferedWriter.write(dataLine);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*READ DATA*/
    public static List<Customer> ReadCustomerList(String path) {
        List<Customer> customers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String dataLine = bufferedReader.readLine();
            while (dataLine != null) {
                String[] CustomerData = dataLine.split(";");
                String cusName = CustomerData[0];
                int cusId = Integer.parseInt(CustomerData[1]);

                customers.add(new Customer(cusName, cusId));

                dataLine = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}
