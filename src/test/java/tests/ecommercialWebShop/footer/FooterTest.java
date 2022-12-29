package tests.ecommercialWebShop.footer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.footer.FooterTestFlow;
import url.Urls;
import utils.DriverFactory;


public class FooterTest {
    @Test
    public void testFooterHomePage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(Urls.BASE_URL);
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFooterCategoryPage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(Urls.BASE_URL);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFooterLoginPage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(Urls.BASE_URL);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
