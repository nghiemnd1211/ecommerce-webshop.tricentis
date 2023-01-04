package tests.tricentis;


import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverFactory;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeTest
    public void initBrowserSession() {
        driver = DriverFactory.getChromeDriver();

    }

    @AfterTest(alwaysRun = true)
    public void closeBrowserSession() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void captureScreenshot(ITestResult result) {
        // Take screenshot when test failed
        if (result.getStatus() == ITestResult.FAILURE) {

            //1. Get method name
            String methodName = result.getName();

            //2. Get Taken time
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH);
            int d = calendar.get(Calendar.DATE);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);

            // testMethodName-yyyy-m-dd-hr-mm-sec.png
            String fileName = methodName + "-" + y + "-" + m + "-" + d + "-" + hour + "-" + min + "-" + second + ".png";

            //3. Take screenshot
            File screenshotBase64Data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {
                //4. Save
                String fileLocation = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
                FileUtils.copyFile(screenshotBase64Data, new File(fileLocation));
                System.out.println(fileLocation);

                //5. Attach screenshot to allure report
                Path content = Paths.get(fileLocation);
                try (InputStream is = Files.newInputStream(content)) {
                    Allure.addAttachment(methodName, is);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
