package models.components.checkout;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test_data.CreditCardType;

@ComponentCssSelector(value = "#opc-payment_info")
public class PaymentInformationComponent extends Component {
    private static final By creditCardDropdownSel = By.cssSelector("#CreditCardType");
    private static final By cardHolderNameSel = By.cssSelector("#CardholderName");
    private static final By cardNumberSel = By.cssSelector("#CardNumber");
    private static final By expiredMonthDropdownSel = By.cssSelector("#ExpireMonth");
    private static final By expiredYearDropdownSel = By.cssSelector("#ExpireYear");
    private static final By cardCodeSel = By.cssSelector("#CardCode");
    private final static By continueBtnSel = By.cssSelector(".payment-info-next-step-button");


    public PaymentInformationComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void selectCreditCard(CreditCardType creditCardType) {
        Select select = new Select(findElement(creditCardDropdownSel));
        switch (creditCardType){
            case VISA:
                select.selectByVisibleText("Visa");
                break;
            case MASTER_CARD:
                select.selectByVisibleText("Master card");
                break;
            case DISCOVER:
                select.selectByVisibleText("Discover");
                break;
            case AMEX:
                select.selectByVisibleText("Amex");
        }
    }

    public void inputCardholderName(String cardName) {
        findElement(cardHolderNameSel).sendKeys(cardName);
    }

    public void inputCardNum(String cardNum) {
        findElement(cardNumberSel).sendKeys(cardNum);
    }

    public void selectExpiredMoth(String expiredMonth) {
        WebElement expiredMonthDropdownElem = findElement(expiredMonthDropdownSel);
        Select select = new Select(expiredMonthDropdownElem);
        select.selectByVisibleText(expiredMonth);
    }

    public void selectExpiredYear(String expiredYear) {
        WebElement expiredYearDropdownElem = findElement(expiredYearDropdownSel);
        Select select = new Select(expiredYearDropdownElem);
        select.selectByVisibleText(expiredYear);
    }

    public void inputCardCode(String cardCode) {
        findElement(cardCodeSel).sendKeys(cardCode);
    }

    public void clickOnContinueBtn() {
        findElement(continueBtnSel).click();
    }
}
