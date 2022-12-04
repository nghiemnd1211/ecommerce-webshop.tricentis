package models.pages.webShopDemo;

import models.components.order.ComputerEssentialsComponent;
import org.openqa.selenium.WebDriver;

public class ComputerItemDetailsPage extends BasePage {
    public ComputerItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    // Khong tim theo component co san
    public<T extends ComputerEssentialsComponent> T computerComp(Class<T> computerEssentialsComp){
        return findComponent(computerEssentialsComp,driver);
    }

}
