package models.components.global.header;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".header-links-wrapper")
public class LinksArea  extends HeaderAreaComponent{

    public LinksArea(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
