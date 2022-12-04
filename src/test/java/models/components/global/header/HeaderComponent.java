package models.components.global.header;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".header")
public class HeaderComponent extends Component {
    public HeaderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public LogoArea logoArea() {
        return findComponent(LogoArea.class, driver);
    }

    public LinksArea linksArea() {
        return findComponent(LinksArea.class, driver);
    }

    public SearchBox searchBox() {
        return findComponent(SearchBox.class, driver);
    }

    public HeaderMenu headerMenu() {
        return findComponent(HeaderMenu.class, driver);
    }
}
