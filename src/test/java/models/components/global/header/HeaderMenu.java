package models.components.global.header;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".header-menu")
public class HeaderMenu extends HeaderAreaComponent{
    public HeaderMenu(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
