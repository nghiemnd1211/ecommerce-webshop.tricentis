package models.components.order;

import io.qameta.allure.Step;
import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseItemDetailsComponent extends Component {
    private final static By basePriceSel = By.cssSelector(".product-price");
    private static final By inputQuantitySel = By.cssSelector(".qty-input");


    public BaseItemDetailsComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public double basePrice(){
        String productPriceText = component.findElement(basePriceSel).getText().trim();
        return Double.parseDouble(productPriceText);
    }
    @Step("Input Quantity")
    public void inputQuantity(int quantity){
        WebElement quantityElem = findElement(inputQuantitySel);
        quantityElem.clear();
        quantityElem.sendKeys(String.valueOf(quantity));
    }

}
