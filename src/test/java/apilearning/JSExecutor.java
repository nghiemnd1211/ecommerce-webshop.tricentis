package apilearning;

import utils.DriverFactory;
import utils.PageController;
import org.openqa.selenium.WebDriver;

public class JSExecutor {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/floating_menu");

        PageController.ScrollToBottom(driver);
    }
}
