package models.components.order;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ComputerEssentialsComponent extends BaseItemDetailsComponent {
    private static final By allOptionSel = By.cssSelector(".option-list input");
    private static final By addToCartBtnSel = By.cssSelector("[id^='add-to-cart-button']");

    public ComputerEssentialsComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract String selectProcessorType(String type);

    public abstract String selectRAMType(String type);

    public String selectHDDType(String type) {
        return selectComputerOption(type);
    }

    @Step("Select Software with {type}")
    //Only for cheap computer
    public String selectSoftware(String type) {
        return selectComputerOption(type);
    }

    @Step("Select OS Type with {type}")
    //Only for standard computer
    public String selectOSType(String type) {
        return selectComputerOption(type);
    }

    public void unselectAllDefaultOptions() {
        List<WebElement> allOptionElem = findElements(allOptionSel);
        allOptionElem.forEach(option -> {
            if (option.getAttribute("checked") != null) {
                option.click();
            }
        });
    }

    protected String selectComputerOption(String type) {
        String selectorStr = "//label[contains(text(),\"" + type + "\")]";
        By optionSel = By.xpath(selectorStr);

        WebElement optionElem = null;
        try {
            optionElem = component.findElement(optionSel);

        } catch (Exception ignored) {
        }
        if (optionElem != null) {
            optionElem.click();
            return optionElem.getText();
        } else throw new RuntimeException("[ERR] The option: " + type + " is not existing");
    }

    public void clickOnAddToCartBtn() {
        findElement(addToCartBtnSel).click();
    }
}
