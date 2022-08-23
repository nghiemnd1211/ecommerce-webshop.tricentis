package apilearning;

import utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxHandle {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxElms =  driver.findElements(By.cssSelector("input[type='checkbox']"));
        try {

            for (WebElement checkboxElm : checkboxElms) {
                if (!checkboxElm.isSelected()) {
                    checkboxElm.click();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        driver.close();

    }
}
