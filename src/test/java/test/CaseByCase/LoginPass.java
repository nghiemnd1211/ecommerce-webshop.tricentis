package test.CaseByCase;

import model.pages.LoginPage;
import model.pages.SecurePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class LoginPass {
    @Test
    public void TestLoginPass(){
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        SecurePage securePage = new SecurePage(driver);
        loginPage
                .inputUsername("tomsmith")
                .inputPassword("SuperSecretPassword!")
                .clickSubmitBtn();

        //Verify login pass
        securePage.VerifyValidCreds();
        driver.quit();
    }
}
