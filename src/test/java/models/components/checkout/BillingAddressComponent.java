package models.components.checkout;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@ComponentCssSelector(value = "li#opc-billing")
public class BillingAddressComponent extends Component {
    private static final By firstnameSel = By.cssSelector("#BillingNewAddress_FirstName");
    private static final By lastnameSel = By.cssSelector("#BillingNewAddress_LastName");
    private static final By emailSel = By.cssSelector("#BillingNewAddress_Email");
    private static final By companySel  = By.cssSelector("#BillingNewAddress_Company");
    private static final By countryDropdownSel = By.cssSelector("select#BillingNewAddress_CountryId");
    private static final By stateDropdownSel = By.cssSelector("select#BillingNewAddress_StateProvinceId");
    private static final By citySel = By.cssSelector("#BillingNewAddress_City");
    private static final By address1Sel = By.cssSelector("#BillingNewAddress_Address1");

    private static final By address2Sel = By.cssSelector("#BillingNewAddress_Address2");
    private static final By zipCodeSel = By.cssSelector("#BillingNewAddress_ZipPostalCode");
    private static final By phoneNumberSel = By.cssSelector("#BillingNewAddress_PhoneNumber");

    private static final By faxNumberSel = By.cssSelector("#BillingNewAddress_FaxNumber");
    private static final By continueBtnSel = By.cssSelector(".new-address-next-step-button");

    public BillingAddressComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void inputFirstName(String value){
        findElement(firstnameSel).sendKeys(value);
    }
    public void inputLastName(String value){
        findElement(lastnameSel).sendKeys(value);
    }
    public void inputEmail(String value){
        findElement(emailSel).sendKeys(value);
    }
    public void inputCompany(String value){
        findElement(companySel).sendKeys(value);
    }
    public void selectCountryOption(String value){
        WebElement countryDropdownElem = findElement(countryDropdownSel);
        Select select = new Select(countryDropdownElem);
        select.selectByVisibleText(value);
    }
    public void selectStateOption(String value){
        WebElement stateDropdownElem = findElement(stateDropdownSel);
        Select select = new Select(stateDropdownElem);
        select.selectByVisibleText(value);
    }
    public void inputCity(String value){
        findElement(citySel).sendKeys(value);
    }
    public void inputAddress1(String value){
        findElement(address1Sel).sendKeys(value);
    }
    public void inputAddress2(String value){
        findElement(address2Sel).sendKeys(value);
    }
    public void inputZipCode(String value){
        findElement(zipCodeSel).sendKeys(value);
    }
    public void inputPhoneNumber(String value){
        findElement(phoneNumberSel).sendKeys(value);
    }
    public void inputFaxNumber(String value){
        findElement(faxNumberSel).sendKeys(value);
    }
    public void clickOnContinueBtn(){
        findElement(continueBtnSel).click();
    }
}
