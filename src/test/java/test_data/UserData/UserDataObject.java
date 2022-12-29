package test_data.UserData;

public class UserDataObject {
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String country;
    private String state;
    private String city;
    private String address1;
    private String address2;
    private String zipCode;
    private String phoneNum;
    private String faxNum;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getFaxNum() {
        return faxNum;
    }

    @Override
    public String toString() {
        return "UserDataObject{" +
                "firstName='" + firstName + '\'' +
                ", lastLame='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", faxNum='" + faxNum + '\'' +
                '}';
    }
}