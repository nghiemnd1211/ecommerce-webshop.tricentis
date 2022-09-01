package test;

import model.pages.LoginPage;
import model.pages.SecurePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class Login_with_Multiple_Sets_of_Data {
    @Test(dataProvider = "loginData")
    public void login(String scenario, String username, String password) {
        System.out.println(username + "\t" + password);
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        SecurePage securePage = new SecurePage(driver);

        loginPage
                .inputUsername(username)
                .inputPassword(password)
                .clickSubmitBtn();
        if(scenario.equals("valid_creds")){
            securePage.VerifyValidCreds();
        }
        else if(scenario.equals("invalid_username")){
            loginPage.VerifyInvalidUsername();
        }
        else{
            loginPage.VerifyInvalidPassword();
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] logindata() {
        return new Object[][]{
                {"valid_creds", "tomsmith", "SuperSecretPassword!" },
                {"invalid_username","nghiemnguyen","SuperSecretPassword!"},
                {"invalid_password","tomsmith","123456!"},
        };
    }
}
