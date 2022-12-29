package models.components.order;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".product-essential")
public class CheapComputerComponent extends ComputerEssentialsComponent {
    public CheapComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        return selectComputerOption(type);
    }

    @Override
    public String selectRAMType(String type) {
        return selectComputerOption(type);
    }
}
