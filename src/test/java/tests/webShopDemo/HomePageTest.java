package tests.webShopDemo;

import models.components.global.footer.*;
import models.components.global.header.HeaderComponent;
import models.components.global.header.HeaderMenu;
import models.pages.webShopDemo.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import url.Urls;
import utils.DriverFactory;

public class HomePageTest {

    @Test
    public void footerTest() {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(Urls.BASE_URL);

            HomePage homePage = new HomePage(driver);
            FooterComponent footerComp = homePage.footerComp();

            InformationColumn informationColumn = footerComp.informationColumn();
            CustomerServiceColumn customerServiceColumn = footerComp.customerServiceColumn();
            MyAccountColumn myAccountColumn = footerComp.myAccountColumn();
            FollowUsColumn followUsColumn = footerComp.followUsColumn();

            System.out.println(informationColumn.headerElem().getText());
            System.out.println(customerServiceColumn.headerElem().getText());
            System.out.println(myAccountColumn.headerElem().getText());
            System.out.println(followUsColumn.headerElem().getText());


            //TRY WITH HEADER
            HeaderComponent headerComp = homePage.headerComp();
//        LinksArea linksArea = headerComp.linksArea();
//        System.out.println(linksArea.getMenuLink().getText());

            HeaderMenu headerMenu = headerComp.headerMenu();
            System.out.println(headerMenu.getMenuLink().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
