package test_flows.order_flow;

import models.components.order.ComputerEssentialsComponent;
import models.pages.webShopDemo.ComputerItemDetailsPage;
import org.openqa.selenium.WebDriver;

public class OrderComputerFlow <T  extends ComputerEssentialsComponent> {
    private final WebDriver driver;
    private Class <T> computerEsssentialsComponent;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialsComponent){
        this.driver = driver;
        this.computerEsssentialsComponent = computerEssentialsComponent;
    }

    public void buildComputerAndAddToCart(){
        ComputerItemDetailsPage computerItemDetailsPage = new ComputerItemDetailsPage(driver);
        T computerEssentialsComponent = computerItemDetailsPage.computerComp(computerEsssentialsComponent);
        computerEssentialsComponent.selectRAMType("2GB");
        computerEssentialsComponent.selectProcessorType("2.5GHZ");
        //computerEssentialsComponent.selectHDDType("400 GB");







    }

}
