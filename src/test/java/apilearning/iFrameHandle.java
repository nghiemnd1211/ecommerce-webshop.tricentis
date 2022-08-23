package apilearning;

import utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class iFrameHandle {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement iframeElm = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElm);

        WebElement iframeBodyElm= driver.findElement(By.id("tinymce"));
        iframeBodyElm.clear();
        iframeBodyElm.sendKeys("This is a new content");

        //Switch back to the main frame
        driver.switchTo().defaultContent();
        driver.quit();

    }
}
