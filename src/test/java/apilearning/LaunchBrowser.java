package apilearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        String chromeDriverPath = "src/test/resources/chromedriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("-incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.google.com/");

        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.quit();
    }
}
