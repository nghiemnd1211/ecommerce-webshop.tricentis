package tests.ecommercialWebShop.order;

import models.components.order.StandardComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.computer.ComputerData;
import test_flows.order_flow.OrderComputerFlow;
import tests.ecommercialWebShop.BaseTest;
import url.Urls;

public class BuyingStandardComputerTest extends BaseTest {

    @Test(dataProvider = "computerData")
    public void testStandardComputerBuying(ComputerData computerData) throws InterruptedException {
        driver.get(Urls.BASE_URL.concat("/build-your-own-computer"));
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow
                = new OrderComputerFlow<>(driver, StandardComputerComponent.class,computerData);
        orderComputerFlow.buildComputerAndAddToCart();
        orderComputerFlow.verifyShoppingCartPage();
    }

    @DataProvider
    public ComputerData[] computerData(){
        String fileLocation = "/src/test/java/test_data/computer/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);
    }
}
