package models.pages.tricentis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOptionPage extends BasePage{
    private static final By checkoutAsGuestSel = By.cssSelector(".checkout-as-guest-button");

    public CheckoutOptionPage(WebDriver driver) {
        super(driver);
    }
    public void selectToCheckoutAsGuest(){
        WebElement checkoutAsGuestElem = findElement(checkoutAsGuestSel);
        checkoutAsGuestElem.click();
    }
}
