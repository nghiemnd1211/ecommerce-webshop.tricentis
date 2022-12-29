package models.pages.herokuDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SecurePage {
    private By logoutBtnSelector = By.linkText("Logout");
    private By flashMsgSelector = By.id("flash");
    private By welcomeTextSelector = By.cssSelector(".subheader");

    WebDriver driver;

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickOnLogoutBtn(){
        WebElement logoutBtn = driver.findElement(logoutBtnSelector);
        logoutBtn.click();
    }
    public String getFlashMsg(){
        WebElement flashMsg = driver.findElement(flashMsgSelector);
        return flashMsg.getText();
    }
    public String getWelcomeText(){
        WebElement welcomeText = driver.findElement(welcomeTextSelector);
        return welcomeText.getText();
    }
    public void VerifyValidCreds(){

        String expectedFlagMsg = "You logged into a secure area!";
        String expectedWelcomeText = "Welcome to the Secure Area. When you are done click logout below.";

        String actualFlagMsg = this.getFlashMsg();
        System.out.println("Actual Flag Msg: "+ actualFlagMsg);

        String actualWelcomeText = this.getWelcomeText();
        System.out.println("Actual Welcome Msg: "+ actualWelcomeText);

        //Assertions
        Assert.assertTrue(actualFlagMsg.contains(expectedFlagMsg));
        Assert.assertTrue(actualWelcomeText.contains(expectedWelcomeText));
    }
}
