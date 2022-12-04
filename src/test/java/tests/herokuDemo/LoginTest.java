package tests.herokuDemo;

import models.pages.herokuPage.LoginPage;
import models.pages.herokuPage.SecurePage;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername("tomsmith")
                .inputPassword("SuperSecretPassword!")
                .clickSubmitBtn();
        new SecurePage(driver).VerifyValidCreds();

        driver.close();
    }
}
