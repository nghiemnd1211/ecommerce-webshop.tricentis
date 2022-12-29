package models.components.checkout;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#opc-shipping_method")
public class ShippingMethodComponent extends Component {
    private static final By continueBtnSel = By.cssSelector(".shipping-method-next-step-button");

    public ShippingMethodComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void selectShippingMethod(String shippingMethod) {
        By shippingMethodSel = By.xpath("//label[contains(text()," + "\"" + shippingMethod + "\")]");
        WebElement shippingMethodElem = findElement(shippingMethodSel);
        shippingMethodElem.click();
    }

    public void clickOnContinueBtn() {
        findElement(continueBtnSel).click();
    }
}
