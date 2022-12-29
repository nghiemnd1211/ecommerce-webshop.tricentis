package test_flows.order_flow;

import models.components.cart.CartItemRowComponent;
import models.components.cart.TotalComponent;
import models.components.order.ComputerEssentialsComponent;
import models.pages.ecommercialWebShop.ComputerItemDetailsPage;
import models.pages.ecommercialWebShop.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test_data.computer.ComputerData;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerFlow<T extends ComputerEssentialsComponent> {
    private final WebDriver driver;
    private Class<T> computerEssentialsComponent;
    private ComputerData computerData;
    private int quantity = 1;
    private double totalItemPrice;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialsComponent, ComputerData computerData) {
        this.driver = driver;
        this.computerEssentialsComponent = computerEssentialsComponent;
        this.computerData = computerData;
    }

    public void buildComputerAndAddToCart() {
        ComputerItemDetailsPage computerItemDetailsPage = new ComputerItemDetailsPage(driver);
        T computerEssentialsComp = computerItemDetailsPage.computerComp(computerEssentialsComponent);

        // Unselect the default option
        computerEssentialsComp.unselectAllDefaultOptions();

        //Select option & get the extracted value from the added price
        String ramFullStr = computerEssentialsComp.selectRAMType(computerData.getRam());
        double ramAddedPrice = extractAdditionalPrice(ramFullStr);

        String processorFullStr = computerEssentialsComp.selectProcessorType(computerData.getProcessorType());
        double processorAddedPrice = extractAdditionalPrice(processorFullStr);

        String hddFullStr = computerEssentialsComp.selectHDDType(computerData.getHdd());
        double hddAddedPrice = extractAdditionalPrice(hddFullStr);

        double osAddedPrice = 0;
        if (computerData.getOs() != null) {
            String osFullStr = computerEssentialsComp.selectOSType(computerData.getOs());
            osAddedPrice = extractAdditionalPrice(osFullStr);
        }
        double sofwareAddedPrice = 0;
        if (computerData.getSoftware() != null) {
            String softwareFullStr = computerEssentialsComp.selectSoftware(computerData.getSoftware());
            sofwareAddedPrice = extractAdditionalPrice(softwareFullStr);
        }
        double totalAddedPrice = ramAddedPrice + processorAddedPrice + hddAddedPrice + osAddedPrice + sofwareAddedPrice;
        totalItemPrice = (computerEssentialsComp.basePrice()+totalAddedPrice);
        System.out.println("Base price: "+ computerEssentialsComp.basePrice());
        System.out.println("Total price on item: "+totalItemPrice);

        //Add to Cart
        computerEssentialsComp.clickOnAddToCartBtn();

        //Click on close button to close bar notification
        computerItemDetailsPage.barNotificationComponent().clickOnCloseBtn();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));

        //Navigate to shopping cart
        computerItemDetailsPage.headerComp().clickOnShoppingCartLink();
    }

    public static double extractAdditionalPrice(String fullPriceStr) {
        double price = 0;
        int factor = 1;
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(fullPriceStr);
        if (matcher.find()) {
            String priceStr = matcher.group(1).trim();
            if (priceStr.startsWith("-"))
                factor = -1;
            price = Double.parseDouble(priceStr.replaceAll("[+-]", ""));
            System.out.println("Additional price: " + price);
        }
        return price * factor;
    }
    public void verifyShoppingCartPage() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        //verify the CartItemComponent list
        List<CartItemRowComponent> cartItemRowComponentList= shoppingCartPage.cartItemRowComponentList();

        if(cartItemRowComponentList.isEmpty()){
            System.out.println("[ERR] There is no item displayed in the shopping cart");
            Assert.fail();
        }
        // Compare all sub-total from CartItemRows with total by its function
        double allSubTotal = 0;
        for(CartItemRowComponent cartItem:cartItemRowComponentList){
            double currentSubTotal = cartItem.subTotal();
            double expectedSubTotal = cartItem.quantityInput() * cartItem.unitPrice();
            Assert.assertEquals(currentSubTotal,expectedSubTotal,"[ERR] The sub-total on item is incorrect!");
            allSubTotal += currentSubTotal;
        }

        // Get checkout price from TotalComponent
        TotalComponent totalComponent = shoppingCartPage.totalComp();
        Map<String,Double> priceCategorized = totalComponent.priceCategorized();
        System.out.println("############################################################");
        System.out.println(priceCategorized);

        /*verification points
        * 1. allSubTotal = checkoutSubTotal ?
        * 2. checkoutTotal = checkoutSubTotal + checkoutOtherFees
        * */
        double checkoutSubTotal = 0;
        double checkoutOtherFees = 0;
        double checkoutTotal = 0;

        for(String priceType : priceCategorized.keySet()){
            double priceValue = priceCategorized.get(priceType);
            if(priceType.startsWith("Sub-Total")){
                checkoutSubTotal = priceValue;
                System.out.println("checkoutSubTotal: " + checkoutSubTotal);
            }
            else if (priceType.startsWith("Total")){
                checkoutTotal = priceValue;
                System.out.println("checkoutTotal: "+checkoutTotal);
            } else {
                checkoutOtherFees += priceValue;
                System.out.println("checkoutOtherFees: "+checkoutOtherFees);
            }
        }

        Assert.assertEquals(allSubTotal,checkoutSubTotal,"[ERR] Checking out Sub Total price is incorrect!");
        Assert.assertEquals((checkoutSubTotal+checkoutOtherFees),checkoutTotal,"[ERR] Checking out Total price is incorrect!");
    }
}
