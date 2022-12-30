Trong DOM TREE > Console
type: $("cssSelector")

Bad practice: Chưa move qua page khác mà đi findElement của page đó --> getting failed


## Handle check-boxes
WebElement dropdownElm = driver.findElement(By.cssSelector("#dropdown"));
Select select = new Select(dropdownElm);
    //Select by visible text
    //Select by index
    //Select by value

## Handle iframe
**- Context: Trong DOM TREE HTML contains iframe (trong iframe do lai chua tag)

<iframe> </iframe>
Match Substring Match Prefix Match Suffix Xpath contains() starts-with() ends-with() CSS *= ^= - Switch back to parent iframe driver.switchTo().defaultContent();**
Custom method bang cach implement interface ExpectedCondition
WaitForElementEnabled

## Handle hovers
Actions action = new Actions(driver);
action.moveToElement(element).perform();


findElement from element
Thay vì dùng driver.findElement() thì sẽ dùng {WebElement}.findElement()

## Generic Type
Add maven compiler plugin
Add maven sure-fire plugin
Add <suiteXmlFile>${suite}</suiteXmlFile>
Run cmd: mvn clean test -Dsuite = relative path (from src/./..)



## Assertion from TestNG
    sortAssert
    Gỉa sử assert fail nhưng nó cũng sẽ pass
    Nhưng nếu sau khi verify tất cả assert (sử dụng assertAll) nó sẽ return fail

## TestNG: @BeforeTest, @AfterTest
Simple version: Before Test > Before class > Before method
                After method > After class > After test
Bad practice: static WebDriver ?

## Su dung boundary generic type khi chua biet se call class cu the nao
    // Khong tim theo component co san
    public<T extends ComputerEssentialsComponent> T computerComp(Class<T> computerEssentialsComp){
        return findComponent(computerEssentialsComp,driver);
    }

## Không cần dùng generic type (da xac dinh duoc muon call toi class nao) 
    public BillingAddressComponent billingAddressComp(){
            return findComponent(BillingAddressComponent.class, driver);
        }

## For Selector
.class1.class2 selects an element that has both classes.
.class1 .class2 selects an element with a class of .class2 that is a child of an element that has a class of .class1.

## Using backslash to print
        By shippingMethodSel = By.xpath("//label[contains(text(),"+ "\""+shippingMethod + "\")]");
## Handles DOM element in Console
$x("//label[contains(text(),'Medium')]")[0].click()

## CLI
    Runtest: 
             mvn clean test -Dtest=BuyingStandardComputerTest
             mvn clean test -DSuite=regression (assign dir .xml to suite tag in POM file)
    Get allure results: 
             allure generate allure-results --clean