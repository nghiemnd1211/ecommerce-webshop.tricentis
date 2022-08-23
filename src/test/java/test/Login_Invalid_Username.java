package test;

import model.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class Login_Invalid_Username {
    @Test
    public void TestLoginPass(){
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername("nghiemnguyen")
                .inputPassword("SuperSecretPassword!")
                .clickSubmitBtn();

        //Verify login FAIL
        loginPage.VerifyInvalidUsername();
        driver.quit();
    }
}
