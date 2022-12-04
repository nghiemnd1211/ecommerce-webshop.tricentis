package models.components.global.header;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderAreaComponent extends Component {
    private final static By menuLinkSel = By.cssSelector("li a");

    public HeaderAreaComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public WebElement getMenuLink(){
        return component.findElement(menuLinkSel);
    }
}
