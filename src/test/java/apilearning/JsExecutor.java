package apilearning;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import url.Urls;
import utils.DriverFactory;
import utils.PageController;

public class JsExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.HEROKU_BASE_URL.concat(Urls.FLOATING_MENU_SLUG));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        PageController pageController = new PageController(javascriptExecutor);

        pageController.scrollToBottom();
        Thread.sleep(2000);

        pageController.scrollToTop();
        Thread.sleep(2000);
        driver.quit();
    }
}
