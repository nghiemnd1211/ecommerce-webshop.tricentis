package models.pages.herokuPage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
        private By usernameSelector = By.id("username");
        private By passwordSelector = By.id("password");
        private By loginBtnSelector = By.cssSelector("[type='submit']");

        private By flashMsgSelector = By.id("flash");
        private static WebDriver driver;

        public LoginPage(WebDriver driver) {
                this.driver = driver;
        }
        @Step("Input username as {username}")
        public LoginPage inputUsername(String username) {
                WebElement usernameElm = driver.findElement(usernameSelector);
                usernameElm.sendKeys(username);
                return this;
        }

        @Step("Input password as {password}")
        public LoginPage inputPassword(String password) {
                WebElement passwordElm = driver.findElement(passwordSelector);
                passwordElm.sendKeys(password);
                return this;
        }

        @Step("Click on the Login button")
        public void clickSubmitBtn() {
                WebElement loginBtn = driver.findElement(loginBtnSelector);
                loginBtn.click();
        }

        public String getFlashMsg(){
               String flagMsg = driver.findElement(flashMsgSelector).getText();
               return flagMsg;
        }
        public void VerifyInvalidUsername(){
                String expectedFlagMsg = "Your username is invalid!";
                String actualFlagMsg = this.getFlashMsg();

                Assert.assertTrue(actualFlagMsg.contains(expectedFlagMsg));
        }
        public void VerifyInvalidPassword(){
                String expectedFlagMsg = "Your password is invalid!";
                String actualFlagMsg = this.getFlashMsg();

                Assert.assertTrue(actualFlagMsg.contains(expectedFlagMsg));
        }

}
