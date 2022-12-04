package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageController {
    private JavascriptExecutor javascriptExecutor;

    public PageController(JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
    }

    public void scrollToBottom() {
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollToTop() {
        javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight,0)");
    }

    public void removeElement(WebElement tobeRemoveElem) {
        javascriptExecutor.executeScript("remove.argument[0]", tobeRemoveElem);
    }
    public static void ScrollToBottom(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver; //casting
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}
