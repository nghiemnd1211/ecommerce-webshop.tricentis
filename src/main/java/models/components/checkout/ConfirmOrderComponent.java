package models.components.checkout;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import test_data.DataObjectBuilder;
import test_data.UserData.UserDataObject;

@ComponentCssSelector(value = "#opc-confirm_order")
public class ConfirmOrderComponent extends Component {
    private final static By billingInfoSel = By.cssSelector(".billing-info");
    private final static By shippingInfoSel = By.cssSelector(".shipping-info");
    private final static By paymentMethodSel = By.cssSelector("li.payment-method");
    private final static By shippingMethodSel = By.cssSelector("li.shipping-method");
    private final static By nameSel = By.cssSelector(".name");
    private final  static By emailSel = By.cssSelector(".email");
    private final static By phoneSel = By.cssSelector(".phone");
    private final static By faxSel = By.cssSelector(".fax");
    private final static By companySel = By.cssSelector(".company");
    private final static By address1Sel = By.cssSelector(".address1");
    private final static By address2Sel = By.cssSelector(".address2");
    private final static By stateSel = By.cssSelector(".city-state-zip");
    private final static By countrySel = By.cssSelector(".country");


    private final static By confirmBtnSel = By.cssSelector(".confirm-order-next-step-button");

    String fileLocation = "/src/main/java/test_data/UserData/UserCheckoutData.json";
    private UserDataObject defaultCheckoutUser = DataObjectBuilder.buildDataObjectFrom(fileLocation, UserDataObject.class);

    public ConfirmOrderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void verifyBillingAddressInfo(){
        verifyOrderInformation(billingInfoSel);
    }
    public void verifyShippingAddressInfo(){
        verifyOrderInformation(shippingInfoSel);
    }
    public String actualShippingMethod(){
        return findElement(shippingMethodSel).getText();
    }

    public String actualPaymentMethod(){
        return findElement(paymentMethodSel).getText();
    }

    public void verifyOrderInformation(By selector){
        String actualName = findElement(selector).findElement(nameSel).getText();
        String actualEmail = findElement(selector).findElement(emailSel).getText();
        String actualPhone = findElement(selector).findElement(phoneSel).getText();
        String actualFax = findElement(selector).findElement(faxSel).getText();
        String actualCompany = findElement(selector).findElement(companySel).getText();
        String actualAddress1 = findElement(selector).findElement(address1Sel).getText();
        String actualAddress2 = findElement(selector).findElement(address2Sel).getText();
        String actualState = findElement(selector).findElement(stateSel).getText();
        String actualCountry = findElement(selector).findElement(countrySel).getText();

        String fileLocation = "/src/main/java/test_data/UserData/UserCheckoutData.json";
        UserDataObject defaultCheckoutUser = DataObjectBuilder.buildDataObjectFrom(fileLocation, UserDataObject.class);

        String expectedName = defaultCheckoutUser.getFirstName() + " " + defaultCheckoutUser.getLastName();
        String expectedEmail = defaultCheckoutUser.getEmail();
        String expectedPhone = defaultCheckoutUser.getPhoneNum();
        String expectedFax = defaultCheckoutUser.getFaxNum();
        String expectedCompany = defaultCheckoutUser.getCompany();
        String expectedAddress1 = defaultCheckoutUser.getAddress1();
        String expectedAddress2 = defaultCheckoutUser.getAddress2();
        String expectedState = defaultCheckoutUser.getState();
        String expectedCountry = defaultCheckoutUser.getCountry();

        //Assertions
//        Assert.assertEquals(actualName,expectedName);
//        Assert.assertEquals(actualEmail,expectedEmail);
//        Assert.assertEquals(actualPhone,expectedPhone);
//        Assert.assertEquals(actualFax,expectedFax);
//        Assert.assertEquals(actualCompany,expectedCompany);
//        Assert.assertEquals(actualAddress1,expectedAddress1);
//        Assert.assertEquals(actualAddress2,expectedAddress2);
//        Assert.assertEquals(actualState,expectedState);
//        Assert.assertEquals(actualCountry,expectedCountry);

        Assert.assertTrue(actualName.contains(expectedName));
        Assert.assertTrue(actualEmail.contains(expectedEmail));
        Assert.assertTrue(actualPhone.contains(expectedPhone));
        Assert.assertTrue(actualFax.contains(expectedFax));
        Assert.assertTrue(actualCompany.contains(expectedCompany));
        Assert.assertTrue(actualAddress1.contains(expectedAddress1));
        Assert.assertTrue(actualAddress2.contains(expectedAddress2));
        Assert.assertTrue(actualState.contains(expectedState));
        Assert.assertTrue(actualCountry.contains(expectedCountry));


    }
    public void clickOnConfirmBtn(){
        WebElement confirmBtnElem = findElement(confirmBtnSel);
        confirmBtnElem.click();
        wait.until(ExpectedConditions.invisibilityOf(confirmBtnElem));
    }
}
