package test_data.gson;

import com.google.gson.Gson;

public class TestGson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        // From JSON(String) to object
        String jsonStr = "{\n" +
                "    \"name\": \"Nghiem Nguyen\",\n" +
                "    \"age\": 23,\n" +
                "    \"job\": \"automation tester\"\n" +
                "  }";

        User aUser = gson.fromJson(jsonStr, User.class);
        System.out.println(aUser);

        // From object to JSON
        aUser.setJob("Test Manager");
        String convertedJson = gson.toJson(aUser);
        System.out.println(convertedJson);


    }
}
