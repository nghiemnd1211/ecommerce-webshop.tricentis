package test_flows.global.footer;


import models.components.global.footer.*;
import models.pages.tricentis.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow  {
    WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        // Chua xac dinh url page can test nen se dua vao BasePage
        BasePage basePage = new BasePage(driver);
        InformationColumn informationColumn = basePage.footerComp().informationColumn();
        MyAccountColumn myAccountColumn = basePage.footerComp().myAccountColumn();
        CustomerServiceColumn customerServiceColumn = basePage.footerComp().customerServiceColumn();
        FollowUsColumn followUsColumn = basePage.footerComp().followUsColumn();

        verifyInformationColumn(informationColumn);
        verifyMyAccountColumn(myAccountColumn);
        verifyCustomerServiceColumn(customerServiceColumn);
        verifyFollowUsColumn(followUsColumn);

    }

    private void verifyInformationColumn(FooterColumnComponent informationColumn) {
        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap",
                "Shipping & Returns",
                "Privacy Notice",
                "Conditions of Use",
                "About us",
                "Contact us");
        List<String> expectedHrefs = Arrays.asList(
                "https://demowebshop.tricentis.com/sitemap",
                "https://demowebshop.tricentis.com/shipping-returns",
                "https://demowebshop.tricentis.com/privacy-policy",
                "https://demowebshop.tricentis.com/conditions-of-use",
                "https://demowebshop.tricentis.com/about-us",
                "https://demowebshop.tricentis.com/contactus"
        );
        verifyFooterColumn(informationColumn, expectedLinkTexts, expectedHrefs);
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent customerServiceColumn) {

    }

    private void verifyMyAccountColumn(FooterColumnComponent myAccountColumn) {

    }

    private void verifyFollowUsColumn(FooterColumnComponent followUsColumn) {

    }

    public void verifyFooterColumn(
            FooterColumnComponent footerColumnComponent, List<String> expectedLinkTexts, List<String> expectedHrefs) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();

        if (footerColumnComponent.linksElem().isEmpty()) {
            Assert.fail("[ERR] The column has no element...");
        } else {
            for (WebElement link : footerColumnComponent.linksElem()) {
                actualLinkTexts.add(link.getText().trim());
                actualHrefs.add(link.getAttribute("href"));
            }
        }

        // Verify link texts
        Assert.assertEquals(actualLinkTexts,expectedLinkTexts,"[ERR] Link text is mismatched");

        // Verify hyperlinks
        Assert.assertEquals(actualHrefs,expectedHrefs, "[ERR] Hyperlink is mismatched");
    }
}
