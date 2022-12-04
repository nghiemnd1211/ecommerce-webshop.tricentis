package tests.webShopDemo.order;

import models.components.order.StandardComputerComponent;
import org.testng.annotations.Test;
import test_flows.order_flow.OrderComputerFlow;
import tests.BaseTest;
import url.Urls;

public class BuyingStandardComputerTest extends BaseTest {

    @Test
    public void testStandardComputerBuying(){
        driver.get(Urls.BASE_URL.concat("/build-your-own-computer"));
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, StandardComputerComponent.class);

        orderComputerFlow.buildComputerAndAddToCart();
    }
}
