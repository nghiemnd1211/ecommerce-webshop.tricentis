package apilearning;

import utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MultiWindowsHandle {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHereLinkText = driver.findElement(By.linkText("Click Here"));
        clickHereLinkText.click();

        List<String> WindowsId = new ArrayList<>(driver.getWindowHandles());
        int firstWindowId = 0;
        int secondWindowId = 1;

        //Switch the second window
        driver.switchTo().window(WindowsId.get(secondWindowId));
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        //Close the second window
        driver.close();

        //Switch the 1st window
        driver.switchTo().window(WindowsId.get(firstWindowId));
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();
    }
}
