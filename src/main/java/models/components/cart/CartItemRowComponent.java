package models.components.cart;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".cart-item-row")
public class CartItemRowComponent extends Component {
    private static final By priceSel = By.cssSelector(".product-unit-price");
    private static final By quantityInputSel = By.cssSelector(".qty-input");
    private static final By subTotalSel = By.cssSelector(".product-subtotal");

    public CartItemRowComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public Double unitPrice(){
        String numberStr = findElement(priceSel).getText().trim();
//        System.out.println(numberStr);
        return Double.parseDouble(numberStr);
    }
    public Double quantityInput(){
        String numberStr = findElement(quantityInputSel).getAttribute("value").trim();
//        System.out.println(numberStr);
        return Double.parseDouble(numberStr);
    }
    public Double subTotal(){
        String numberStr = findElement(subTotalSel).getText().trim();
//        System.out.println(numberStr);
        return Double.parseDouble(numberStr);
    }
}
