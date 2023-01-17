package test_flows.order_flow;

import io.qameta.allure.Step;
import models.components.cart.CartItemRowComponent;
import models.components.cart.TotalComponent;
import models.components.checkout.*;
import models.components.order.ComputerEssentialsComponent;
import models.pages.tricentis.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test_data.CreditCardType;
import test_data.DataObjectBuilder;
import test_data.PaymentMethodType;
import test_data.UserData.UserDataObject;
import test_data.computer.ComputerData;

import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerFlow<T extends ComputerEssentialsComponent> {
    private final WebDriver driver;
    private Class<T> computerEssentialsComponent;
    private ComputerData computerData;
    private int quantity = 1;
    private double totalItemPrice;

    String shippingMethodSelected;
    String paymentMethodSelected = "showIfFailed";
    private UserDataObject defaultCheckoutUser;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialsComponent, ComputerData computerData) {
        this.driver = driver;
        this.computerEssentialsComponent = computerEssentialsComponent;
        this.computerData = computerData;
    }

    @Step("Build computer and then add to cart")
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
        totalItemPrice = (computerEssentialsComp.basePrice() + totalAddedPrice);
        System.out.println("Base price: " + computerEssentialsComp.basePrice());
        System.out.println("==> Sub-Total on item: " + totalItemPrice);

        //Add to Cart
        computerEssentialsComp.clickOnAddToCartBtn();

        //Verify Item Added To Cart
        computerItemDetailsPage.barNotificationComponent().verifyItemAddedToCart();

        //Click on close button to close bar notification
        computerItemDetailsPage.barNotificationComponent().clickOnCloseBtn();

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

    @Step("Verify shopping cart")
    public void verifyShoppingCartPage() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        //verify the CartItemComponent list
        List<CartItemRowComponent> cartItemRowComponentList = shoppingCartPage.cartItemRowComponentList();

        if (cartItemRowComponentList.isEmpty()) {
            System.out.println("[ERR] There is no item displayed in the shopping cart");
            Assert.fail();
        }
        // Compare all sub-total from CartItemRows with total by its function
        double allSubTotal = 0;
        for (CartItemRowComponent cartItem : cartItemRowComponentList) {
            double currentSubTotal = cartItem.subTotal();
            double expectedSubTotal = cartItem.quantityInput() * cartItem.unitPrice();
            Assert.assertEquals(currentSubTotal, expectedSubTotal, "[ERR] The sub-total on item is incorrect!");
            allSubTotal += currentSubTotal;
        }

        // Get checkout price from TotalComponent
        TotalComponent totalComponent = shoppingCartPage.totalComp();
        Map<String, Double> priceCategorized = totalComponent.priceCategorized();

        System.out.println("\n############# Checkout Price ############");
        System.out.println("Price Categorized: " + priceCategorized);

        /*verification points
         * 1. allSubTotal = checkoutSubTotal ?
         * 2. checkoutTotal = checkoutSubTotal + checkoutOtherFees
         * */
        double checkoutSubTotal = 0;
        double checkoutOtherFees = 0;
        double checkoutTotal = 0;

        for (String priceType : priceCategorized.keySet()) {
            double priceValue = priceCategorized.get(priceType);
            if (priceType.startsWith("Sub-Total")) {
                checkoutSubTotal = priceValue;
            } else if (priceType.startsWith("Total")) {
                checkoutTotal = priceValue;
            } else {
                checkoutOtherFees += priceValue;
            }
        }
        System.out.println("\tSubTotal: " + checkoutSubTotal);
        System.out.println("\tOtherFees: " + checkoutOtherFees);
        System.out.println("\tTotal: " + checkoutTotal);

        Assert.assertEquals(allSubTotal, checkoutSubTotal, "[ERR] Checking out Sub Total price is incorrect!");
        Assert.assertEquals((checkoutSubTotal + checkoutOtherFees), checkoutTotal, "[ERR] Checking out Total price is incorrect!");
    }

    @Step("Click on Agree To Term Of Service")
    public void agreeTOSAndCheckout() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.totalComp().selectAgreeTOS();
        shoppingCartPage.totalComp().clickOnCheckoutBtn();
    }

    @Step("Checking out as guest")
    public void selectToCheckoutAsGuest() {
        CheckoutOptionPage checkoutOptionPage = new CheckoutOptionPage(driver);
        checkoutOptionPage.selectToCheckoutAsGuest();
    }

    @Step("Input Billing Address")
    public void inputBillingAddress() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        BillingAddressComponent billingAddressComp = checkoutPage.billingAddressComponent();
        String fileLocation = "/src/main/java/test_data/UserData/UserCheckoutData.json";

        if (!billingAddressComp.findElements(By.cssSelector("select#billing-address-select")).isEmpty()) {
            billingAddressComp.selectNewAddress();
        }

        defaultCheckoutUser = DataObjectBuilder.buildDataObjectFrom(fileLocation, UserDataObject.class);
        System.out.println(defaultCheckoutUser);

        billingAddressComp.inputFirstName(defaultCheckoutUser.getFirstName());
        billingAddressComp.inputLastName(defaultCheckoutUser.getLastName());
        billingAddressComp.inputEmail(defaultCheckoutUser.getEmail());
        billingAddressComp.inputCompany(defaultCheckoutUser.getCompany());
        billingAddressComp.selectCountryOption(defaultCheckoutUser.getCountry());
        billingAddressComp.selectStateOption(defaultCheckoutUser.getState());
        billingAddressComp.inputCity(defaultCheckoutUser.getCity());
        billingAddressComp.inputAddress1(defaultCheckoutUser.getAddress1());
        billingAddressComp.inputAddress2(defaultCheckoutUser.getAddress2());
        billingAddressComp.inputZipCode(defaultCheckoutUser.getZipCode());
        billingAddressComp.inputPhoneNumber(defaultCheckoutUser.getPhoneNum());
        billingAddressComp.inputFaxNumber(defaultCheckoutUser.getFaxNum());

        checkoutPage.billingAddressComponent().clickOnContinueBtn();
    }

    @Step("Input Shipping Address")
    public void inputShippingAddress() {
        new CheckoutPage(driver).shippingAddressComponent().clickOnContinueBtn();
    }

    @Step("Input Shipping Method")
    public String selectShippingMethod() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ShippingMethodComponent shippingMethodComp = checkoutPage.shippingMethodComponent();

        List<String> shippingMethodList = new ArrayList<>(Arrays.asList("Ground", "Next Day Air", "2nd Day Air "));
        int randomIndex = new SecureRandom().nextInt(shippingMethodList.size());
        String randomMethod = shippingMethodList.get(randomIndex);
        shippingMethodSelected = shippingMethodComp.selectShippingMethod(randomMethod);
        System.out.println("\nShipping Method Selected is: " + shippingMethodSelected);
        shippingMethodComp.clickOnContinueBtn();
        return shippingMethodSelected;
    }

    @Step("Select Payment method")
    public String selectPaymentMethod(PaymentMethodType paymentMethodType) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentMethodComponent paymentMethodComp = checkoutPage.paymentMethodComponent();
        switch (paymentMethodType) {
            case CHECK_MONEY_ORDER:
                paymentMethodSelected = paymentMethodComp.selectCheckMoneyOrderMethod();
                break;
            case CREDIT_CARD:
                paymentMethodSelected = paymentMethodComp.selectCreditCardMethod();
                break;
            case PURCHASE_ORDER:
                paymentMethodSelected = paymentMethodComp.selectPurchaseOrder();
                break;
            default:
                paymentMethodSelected = paymentMethodComp.selectCODMethod();
                break;
        }
        System.out.println("\nPayment Method Selected is: " + paymentMethodSelected);
        paymentMethodComp.clickOnContinueBtn();
        return paymentMethodSelected;
    }

    @Step("Input Payment Information")
    public void inputPaymentInfo(CreditCardType creditCardType) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentInformationComponent paymentInformationComp = checkoutPage.paymentInformationComponent();
        By creditCardDropdownSel = By.cssSelector("#CreditCardType");

        //boolean isHavingCreditCardDropdown = paymentInformationComp.findElements(creditCardDropdownSel).isEmpty();
        if (!paymentInformationComp.findElements(creditCardDropdownSel).isEmpty()) {
            paymentInformationComp.selectCreditCard(creditCardType);

            paymentInformationComp.inputCardholderName(defaultCheckoutUser.getFirstName() + " " + defaultCheckoutUser.getLastName());
            paymentInformationComp.inputCardNum(creditCardType.equals("VISA") ? "4012888888881881" : "6011000990139424");

            // Select current month and next year
            Calendar calendar = new GregorianCalendar();
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR) + 1;

            System.out.println("Select expired month:" + month + "\n" + "Select expired year: " + year);
            paymentInformationComp.selectExpiredMoth(String.valueOf(month));
            paymentInformationComp.selectExpiredYear(String.valueOf(year));

            paymentInformationComp.inputCardCode("123");
        }
        paymentInformationComp.clickOnContinueBtn();
    }

    @Step("Confirm and Verify the Order")
    public void confirmAndVerifyOrder() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmOrderComponent confirmOrderComp = checkoutPage.confirmOrderComponent();

        //TODO: Add some verification methods
        confirmOrderComp.verifyBillingAddressInfo();
        confirmOrderComp.verifyShippingAddressInfo();

        // Assertion for Shipping Method & Payment Method
        // Actual vs Expected result need to compare at runtime
        Assert.assertTrue(shippingMethodSelected.contains(confirmOrderComp.actualShippingMethod()));
        Assert.assertTrue(paymentMethodSelected.contains(confirmOrderComp.actualPaymentMethod()));
        confirmOrderComp.clickOnConfirmBtn();

        new CheckoutCompletedPage(driver).clickOnContinueBtn();
    }
}
