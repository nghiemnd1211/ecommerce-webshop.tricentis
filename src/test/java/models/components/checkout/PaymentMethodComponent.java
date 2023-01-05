package models.components.checkout;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ComponentCssSelector(value = "#opc-payment_method")
public class PaymentMethodComponent extends Component {
    private static final By codSel = By.xpath("//label[contains(text(),'Cash On Delivery')]");
    private static final By checkMoneyOrderSel = By.xpath("//label[contains(text(),'Check / Money Order')]");
    private static final By creditCardSel = By.xpath("//label[contains(text(),'Credit Card')]");
    private static final By purchaseOrderSel = By.xpath("//label[contains(text(),'Purchase Order')]");
    private final static By continueBtnSel = By.cssSelector(".payment-method-next-step-button");

    public PaymentMethodComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public String selectCODMethod() {
        WebElement codElem = findElement(codSel);
        codElem.click();
        return codElem.getText();
    }
    public String selectCheckMoneyOrderMethod(){
        WebElement checkMoneyOrderElem = findElement(checkMoneyOrderSel);
        checkMoneyOrderElem.click();
        return checkMoneyOrderElem.getText();
    }
    public String selectCreditCardMethod(){
        WebElement creditCardElem = findElement(creditCardSel);
        creditCardElem.click();
        return creditCardElem.getText();
    }
    public String selectPurchaseOrder(){
        WebElement checkMoneyOrderElem = findElement(purchaseOrderSel);
        checkMoneyOrderElem.click();
        return checkMoneyOrderElem.getText();
    }
    public void clickOnContinueBtn() {
        WebElement continueBtnElem = findElement(continueBtnSel);
        continueBtnElem.click();
        wait.until(ExpectedConditions.invisibilityOf(continueBtnElem));
    }

}
