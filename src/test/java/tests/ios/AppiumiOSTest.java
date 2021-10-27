package tests.ios;

import baseClasses.BaseClass;
import org.testng.annotations.Test;
import pages.AppFlowPage;
import pages.EligibilityPage;
import pages.LaunchPage;
import pages.ProductCarouselPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppiumiOSTest extends BaseClass {

    LaunchPage launchPage;
    EligibilityPage eligibilityPage;
    ProductCarouselPage productCarouselPage;
    AppFlowPage appFlowPage;

    @Test
    public void verify_launching_page() {
        launchPage = new LaunchPage(driver);
        launchPage.verifyLogInButton("Log In");
        launchPage.verifyWelcomeLabel("Welcome to ARBM Digibank");
        launchPage.verifySignUpButton("I'm new to [ARBM Digibank]");
    }

    @Test
    public void verify_product_carousel_page() {
        launchPage = new LaunchPage(driver);
        ProductCarouselPage prodCarPage = launchPage.logInToProductCarouselPage();
        prodCarPage.verifyInstructionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ullamcorper aliquet risus");

//        prodCarPage.backToPreviousPage()
//                        .logInToProductCarouselPage();

        prodCarPage.verifyLogoLabel("DigiBank");
        prodCarPage.verifyOpenBankAccountButton("Open Bank Account");
        prodCarPage.verifyEligibilityLabel("Am I eligible?");
        for(int i = 0; i<3; i++) {
            driver.findElementByAccessibilityId("pageControl").click();
        }
    }

    @Test
    public void verify_product_eligibility_modal() {
        launchPage = new LaunchPage(driver);
        ProductCarouselPage prodCarPage = launchPage.logInToProductCarouselPage();
        eligibilityPage = prodCarPage.openEligibilityModal();
        eligibilityPage.verifyCloseButton();
        eligibilityPage.verifyEligibilityLabelName("Eligibility criteria");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "I am a Malaysian with a MyKad, residing in Malaysia",
                "I am aged 18 and above",
                "I have an existing internet banking account with another bank in Malaysia",
                "I am NOT a US person",
                "I am NOT a tax resident in any other country",
                "I am applying for an individual account");
        eligibilityPage.verifyEligibilityList(list);
        eligibilityPage.closeEligibilityModal();

        for(int i = 0; i<3; i++) {
            driver.findElementByAccessibilityId("pageControl").click();
        }

        eligibilityPage = prodCarPage.openEligibilityModal();
        eligibilityPage.verifyCloseButton();
        eligibilityPage.verifyEligibilityLabelName("Eligibility criteria");
        eligibilityPage.verifyEligibilityList(list);
        eligibilityPage.closeEligibilityModal();

    }

    @Test
    public void verify_app_flow_page() {   // defect ARBP-1333
        launchPage = new LaunchPage(driver);
        ProductCarouselPage prodCarPage = launchPage.logInToProductCarouselPage();
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage();
        appFlowPage.verifyTitleLabel("This shouldn't take long at all");
//        appFlowPage.verifyFirstTextLabel("Our 4 stage sign up process is quick and easy to complete");
//        appFlowPage.verifySecondTextLabel("Have your MyKad ready and let's get started");
        appFlowPage.verifyFirstTextLabel("We pride ourselves on a quick sign up.");
        appFlowPage.verifySecondTextLabel("Please ensure you have your MyKad with you before starting the process.");
        appFlowPage.verifyProgressBarLabels("Sign up & ID verification","Personal details",
                "Create an account", "Top up account");
//        appFlowPage.verifySignUpButton("Let's start");
        appFlowPage.verifySignUpButton("Let's sign up");
    }
}
