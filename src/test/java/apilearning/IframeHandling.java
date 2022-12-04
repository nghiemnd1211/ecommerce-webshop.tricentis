package apilearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;
import utils.DriverFactory;

public class IframeHandling {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.HEROKU_BASE_URL.concat(Urls.IFRAME_SLUG));

        By iframeSel = By.cssSelector("iframe[id^='mce']");
        By tinyTextSel = By.id("tinymce");

        //Find iframe element
        WebElement iframeElem = driver.findElement(iframeSel);
        //Switch into iframe
        driver.switchTo().frame(iframeElem);
        //Find element after switching
        WebElement tinyTextElem = driver.findElement(tinyTextSel);
        //Input text into Tiny text area
        tinyTextElem.clear();
        tinyTextElem.sendKeys("hihi");
        //Switch back to parent iframe
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.partialLinkText("Selenium")).getAttribute("href"));

        driver.close();
    }
}
