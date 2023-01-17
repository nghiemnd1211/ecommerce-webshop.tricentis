package models.components.cart;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentCssSelector(value = ".cart-footer .totals")
public class TotalComponent extends Component {

    // private static final By tableRowSel = By.cssSelector(".cart-item-row");
    private static final By priceTableRowSel = By.cssSelector("table tr");
    private static final By priceTypeSel = By.cssSelector(".cart-total-left");
    private static final By priceValueSel = By.cssSelector(".cart-total-right");
    private static final By agreeTOSSel = By.cssSelector("#termsofservice");
    private static final By checkoutBtnSel = By.cssSelector("#checkout");

    public TotalComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public Map<String, Double> priceCategorized() {
        List<WebElement> tableRowElements = findElements(priceTableRowSel);
        Map<String, Double> priceCategorized = new HashMap<>();
        for (WebElement tableRowElem : tableRowElements) {
            String priceType = tableRowElem.findElement(priceTypeSel).getText().replace(":","").trim();
            Double priceValue = Double.parseDouble(tableRowElem.findElement(priceValueSel).getText().trim());
            priceCategorized.put(priceType, priceValue);
        }
        return priceCategorized;
    }
    public void selectAgreeTOS(){
        WebElement agreeTOSElem = findElement(agreeTOSSel);
        if(!agreeTOSElem.isSelected()){
            agreeTOSElem.click();
        }
    }

    public void clickOnCheckoutBtn(){
        findElement(checkoutBtnSel).click();
    }
}
