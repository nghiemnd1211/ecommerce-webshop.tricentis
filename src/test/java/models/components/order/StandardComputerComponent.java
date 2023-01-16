package models.components.order;

import io.qameta.allure.Step;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@ComponentCssSelector(value = ".product-essential")
public class StandardComputerComponent extends ComputerEssentialsComponent {

    private static final By productAttributeDropdownSel = By.cssSelector("select[id^='product_attribute']");

    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Step("Select Processor Type with {type}")
    @Override
    public String selectProcessorType(String type) {
        final int PROCESSOR_DROPDOWN_INDEX = 0;
        WebElement processorDropdownElem = component.findElements(productAttributeDropdownSel).get(PROCESSOR_DROPDOWN_INDEX);
        //prefix with product_attribute
        return selectOption(processorDropdownElem);
    }

    @Step("Select RAM Type with {type}")
    @Override
    public String selectRAMType(String type) {
        final int RAM_DROPDOWN_INDEX = 1;
        WebElement RAMDropdownOption = component.findElements(productAttributeDropdownSel).get(RAM_DROPDOWN_INDEX);
        //prefix with product_attribute
        return selectOption(RAMDropdownOption);
    }

    //creating support method to reuse in other methods
    private String selectOption(WebElement dropdownElem) {
        String fullStrOption = null;
        Select select = new Select(dropdownElem);
        List<WebElement> optionList = select.getOptions();
        for (WebElement option : optionList) {
            String currentOptionText = option.getText();
            fullStrOption = currentOptionText.trim().replace(" ", "");
            return fullStrOption;
        }
        if (dropdownElem != null) {
            select.selectByVisibleText(fullStrOption);
            return fullStrOption;
        } else
            throw new RuntimeException("[ERR] The dropdown option is not existing to select");
    }
}
