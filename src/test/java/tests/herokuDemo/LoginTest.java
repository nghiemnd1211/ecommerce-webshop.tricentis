package tests.herokuDemo;

import models.pages.herokuDemo.LoginPage;
import models.pages.herokuDemo.SecurePage;
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
