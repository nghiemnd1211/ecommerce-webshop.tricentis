package models.pages.ecommercialWebShop;

import models.components.Component;
import models.components.global.BarNotificationComponent;
import models.components.global.TopMenuComponent;
import models.components.global.footer.FooterComponent;
import models.components.global.header.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Component {
    protected WebDriver driver;

    // Create constructor with 1 params
    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
    }
    // >>global component scope
    public FooterComponent footerComp(){
        return findComponent(FooterComponent.class,driver);
    }
    public HeaderComponent headerComp(){
        return findComponent(HeaderComponent.class,driver);
    }
    public TopMenuComponent topMenuComponent(){
        return findComponent(TopMenuComponent.class,driver);
    }

    public BarNotificationComponent barNotificationComponent(){
        return findComponent(BarNotificationComponent.class,driver);
    }
}
