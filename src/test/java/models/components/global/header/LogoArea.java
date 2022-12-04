package models.components.global.header;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".header-logo")
public class LogoArea extends HeaderAreaComponent{
    public LogoArea(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
