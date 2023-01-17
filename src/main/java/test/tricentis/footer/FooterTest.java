package test.tricentis.footer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.footer.FooterTestFlow;
import test.tricentis.BaseTest;
import url.Urls;


public class FooterTest extends BaseTest {
    @Test
    public void testFooterHomePage() {
        WebDriver driver = getDriver();
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
        WebDriver driver = getDriver();
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
        WebDriver driver = getDriver();
        try {
            driver.get(Urls.BASE_URL);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
