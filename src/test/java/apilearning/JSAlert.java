package apilearning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;
import utils.DriverFactory;

import java.time.Duration;

public class JSAlert {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.HEROKU_BASE_URL.concat(Urls.JAVASCRIPT_ALERTS_SLUG));
        WebElement JSAlert = driver.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]"));
        WebElement JSConfirm = driver.findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]"));
        WebElement JSPropmt = driver.findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]"));
        WebElement result = driver.findElement(By.id("result"));

        //Play with JS Alert
        JSAlert.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("JS Alert - Content: "+alert.getText());

        alert.accept();
        System.out.println("JS Alert - Result: "+result.getText());

        //Play with JS Confirm
        JSConfirm.click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("JS Confirm - Content: "+alert.getText());
        alert.dismiss();
        System.out.println("JS Confirm - Result: "+result.getText());

        //Play with JS Prompt
        JSPropmt.click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Nghiem Nguyen");
        alert.accept();
        System.out.println("JS Prompt - Result: "+result.getText());

        driver.quit();

    }
}
