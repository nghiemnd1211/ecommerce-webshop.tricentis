package test.CaseByCase;

import model.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class Login_Invalid_Password {
    @Test
    public void Login_with_Invalid_Password(){
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername("tomsmith")
                .inputPassword("123456")
                .clickSubmitBtn();

        //Verify login FAIL
        loginPage.VerifyInvalidPassword();
        driver.quit();
    }
}
