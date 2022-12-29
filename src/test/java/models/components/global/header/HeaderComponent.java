package models.components.global.header;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".header")

public class HeaderComponent extends Component {
    private static final By shoppingCartLinkSel =By.cssSelector("li#topcartlink");
    public HeaderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public void clickOnShoppingCartLink(){
        WebElement shoppingCartLinkElem = driver.findElement(shoppingCartLinkSel);
        scrollUpToElement(shoppingCartLinkElem);
        shoppingCartLinkElem.click();
    }
}