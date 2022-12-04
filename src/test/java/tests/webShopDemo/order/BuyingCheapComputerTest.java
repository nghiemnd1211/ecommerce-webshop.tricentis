package tests.webShopDemo.order;

import models.components.order.CheapComputerComponent;
import org.testng.annotations.Test;
import test_flows.order_flow.OrderComputerFlow;
import tests.BaseTest;
import url.Urls;

public class BuyingCheapComputerTest extends BaseTest {

    @Test
    public void testCheapComputerBuying(){
        driver.get(Urls.BASE_URL.concat("/build-your-cheap-own-computer"));
        OrderComputerFlow<CheapComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, CheapComputerComponent.class);

        orderComputerFlow.buildComputerAndAddToCart();
    }
}
