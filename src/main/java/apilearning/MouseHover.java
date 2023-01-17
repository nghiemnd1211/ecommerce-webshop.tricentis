package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.util.List;

public class MouseHover {
    public final static By figureSel = By.cssSelector(".figure");
    public final static By profileNameSel = By.tagName("h5");
    public final static By profileLinkSel = By.cssSelector(".figcaption a");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //Navigate to the hover page
            driver.get(Urls.HEROKU_BASE_URL.concat(Urls.HOVER_SLUG));
            //Locate to the hover image elems
            List<WebElement> imageElems = driver.findElements(figureSel);
            if (imageElems.isEmpty()) {
                System.out.println("There is no profile");
            }
            for (WebElement imageElem : imageElems) {

                // Mouse hover
                Actions action = new Actions(driver);
                action.moveToElement(imageElem).perform();

                WebElement profileNameElem = imageElem.findElement(profileNameSel);
                WebElement profileLinkElem = imageElem.findElement(profileLinkSel);

                // Get value after hovering
                System.out.println(profileNameElem.getText());
                System.out.println(profileLinkElem.getAttribute("href"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
