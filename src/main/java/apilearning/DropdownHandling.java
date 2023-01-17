package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import url.Urls;

public class DropdownHandling {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.HEROKU_BASE_URL.concat(Urls.DROPDOWN_SLUG));
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