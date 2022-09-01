package test.CaseByCase;

import model.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class Login_Invalid_Username {
    @Test
    public void Login_with_invalid_Username(){
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername("nghiemnguyen")
                .inputPassword("SuperSecretPassword!")
                .clickSubmitBtn();

        //Verify login FAIL
        driver.quit();
    }
}
