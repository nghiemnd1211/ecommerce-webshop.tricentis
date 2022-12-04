package apilearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;
import utils.DriverFactory;

import java.util.List;

public class CheckboxHandling {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.HEROKU_BASE_URL.concat(Urls.CHECKBOXES_SLUG));
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
