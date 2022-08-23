package apilearning;

import utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandle {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        try {
            WebElement dropdownElm = driver.findElement(By.cssSelector("#dropdown"));

            Select select = new Select(dropdownElm);
            select.selectByValue("1");
            select.selectByValue("2");

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}