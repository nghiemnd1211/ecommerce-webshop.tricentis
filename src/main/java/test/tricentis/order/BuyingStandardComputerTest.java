package test.tricentis.order;

import models.components.order.StandardComputerComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.CreditCardType;
import test_data.DataObjectBuilder;
import test_data.PaymentMethodType;
import test_data.computer.ComputerData;
import test_flows.order_flow.OrderComputerFlow;
import test.tricentis.BaseTest;
import url.Urls;

public class BuyingStandardComputerTest extends BaseTest {
    @Test(dataProvider = "computerData")
    //@Parameters({"browser"})
    public void testStandardComputerBuying(ComputerData computerData) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get(Urls.BASE_URL.concat("/build-your-own-computer"));
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow
                = new OrderComputerFlow<>(driver, StandardComputerComponent.class,computerData);
        orderComputerFlow.buildComputerAndAddToCart();
        orderComputerFlow.verifyShoppingCartPage();
        orderComputerFlow.agreeTOSAndCheckout();
        orderComputerFlow.selectToCheckoutAsGuest();
        orderComputerFlow.inputBillingAddress();
        orderComputerFlow.inputShippingAddress();
        orderComputerFlow.selectShippingMethod();
        orderComputerFlow.selectPaymentMethod(PaymentMethodType.CREDIT_CARD);
        orderComputerFlow.inputPaymentInfo(CreditCardType.VISA);
        orderComputerFlow.confirmAndVerifyOrder();
    }

    @DataProvider
    public ComputerData[] computerData(){
        String fileLocation = "/src/main/java/test_data/computer/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);
    }
}
