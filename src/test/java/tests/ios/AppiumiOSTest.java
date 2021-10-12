package tests.ios;

import baseClasses.BaseClass;
import org.testng.annotations.Test;
import pages.LaunchPage;
import pages.ProductCarouselPage;

public class AppiumiOSTest extends BaseClass {

    LaunchPage launchPage;
    ProductCarouselPage productCarouselPage;

    @Test
    public void verify_launching_page_labels() {
        launchPage = new LaunchPage(driver);
        launchPage.verifyLogInButton("Log In");
//        launchPage.verifyWelcomeLabel("Welcome to ARBM Digibank");
        launchPage.verifySignUpButton("I'm new to [ARBM Digibank]");
    }

    @Test
    public void verify_product_carousel_page_labels() {
        launchPage = new LaunchPage(driver);
        launchPage.logInToProductCarouselPage();
        productCarouselPage = new ProductCarouselPage(driver);
//        productCarouselPage.verifyOpenBankAccountButton("Open Bank Account");
        productCarouselPage.verifyEligibilityLabel("Am I eligible?");
    }

}
