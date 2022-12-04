package models.pages.webShopDemo;

import models.components.Component;
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
    public FooterComponent footerComp(){
        return findComponent(FooterComponent.class,driver);
    }

    //add header
    public HeaderComponent headerComp(){
        return findComponent(HeaderComponent.class,driver);
    }
}
