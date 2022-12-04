package models.components.global.header;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".search-box")
public class SearchBox extends HeaderAreaComponent{
    public SearchBox(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
