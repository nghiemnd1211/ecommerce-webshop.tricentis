package models.components.order;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ComputerEssentialsComponent extends Component {
    public ComputerEssentialsComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract String selectProcessorType(String type);

    public abstract String selectRAMType(String type);

    public abstract String selectHDDType(String type);

    protected String selectComputerOption(String type) {
        By optionSelector = By.xpath("//label[contains(text()," + type + ")]");
        WebElement optionElem = null;
        try{
            optionElem = component.findElement(optionSelector);

        }catch (Exception ignored){
        }
        if(optionElem!=null){
            optionElem.click();
            return optionElem.getText();
        }
        else
            throw new RuntimeException("[ERR] The option: "+type+"is not existing");
    }

}
