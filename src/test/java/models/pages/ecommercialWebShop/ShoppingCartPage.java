package models.pages.ecommercialWebShop;

import models.components.cart.CartItemRowComponent;
import models.components.cart.TotalComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public TotalComponent totalComp(){
        return findComponent(TotalComponent.class,driver);
    }
    public List<CartItemRowComponent> cartItemRowComponentList(){
        return findComponents(CartItemRowComponent.class,driver);
    }
}
