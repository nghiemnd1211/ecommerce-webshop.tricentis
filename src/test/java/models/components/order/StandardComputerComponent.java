package models.components.order;

import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@ComponentCssSelector(value = ".product-essential")
public class StandardComputerComponent extends ComputerEssentialsComponent{

    private static final By productAttributeSel = By.cssSelector("select[id^='product_attribute']");
    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        final int PROCESSOR_DROPDOWN_INDEX=0;
        WebElement processorDropdownElem = component.findElements(By.cssSelector("select[id^='product_attribute']")).get(PROCESSOR_DROPDOWN_INDEX);
        //prefix with product_attribute
        return selectOption(processorDropdownElem);
    }

    @Override
    public String selectRAMType(String type)
    {
        final int RAM_DROPDOWN_INDEX=0;
        WebElement RAMDropdownOption = component.findElements(By.cssSelector("select[id^='product_attribute']")).get(RAM_DROPDOWN_INDEX);
        //prefix with product_attribute
        return selectOption(RAMDropdownOption);
    }

    @Override
    public String selectHDDType(String type) {
        return selectComputerOption(type);
    }

    //creating support method to reuse in other methods
    private String selectOption(WebElement dropdownElem) {
        String fullStrOption = null;
        Select select = new Select(dropdownElem);
        for(WebElement option: select.getOptions()){
            String currentOptionText = option.getText();
            fullStrOption = currentOptionText.trim().replace(" ","");
            return fullStrOption;
        }
        if (dropdownElem!=null){
            select.selectByVisibleText(fullStrOption);
            return fullStrOption;
        }
        else
            throw new RuntimeException("[ERR] The dropdown option is not existing to select");
    }
}
