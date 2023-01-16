package models.components.order;

import io.qameta.allure.Step;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".product-essential")
public class CheapComputerComponent extends ComputerEssentialsComponent {
    public CheapComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Step("Select Processor Type with {type}")
    @Override
    public String selectProcessorType(String type) {
        return selectComputerOption(type);
    }

    @Step("Select RAM Type with {type}")
    @Override
    public String selectRAMType(String type) {
        return selectComputerOption(type);
    }
}
