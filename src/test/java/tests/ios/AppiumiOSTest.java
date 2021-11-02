package tests.ios;

import baseClasses.BaseClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppiumiOSTest extends BaseClass {

    LaunchPage launchPage;
    EligibilityModalPage eligibilityModalPage;
    ProductCarouselPage productCarouselPage;
    AppFlowPage appFlowPage;
    TermsConditionsPage termsConditionsPage;
    PhoneCapturePage phoneCapturePage;

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
        eligibilityModalPage = prodCarPage.openEligibilityModal();
        eligibilityModalPage.verifyCloseButton();
        eligibilityModalPage.verifyEligibilityLabelName("Eligibility criteria");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "I am a Malaysian with a MyKad, residing in Malaysia",
                "I am aged 18 and above",
                "I have an existing internet banking account with another bank in Malaysia",
                "I am NOT a US person",
                "I am NOT a tax resident in any other country",
                "I am applying for an individual account");
        eligibilityModalPage.verifyEligibilityList(list);
        eligibilityModalPage.closeEligibilityModal();

        for(int i = 0; i<3; i++) {
            driver.findElementByAccessibilityId("pageControl").click();
        }

        eligibilityModalPage = prodCarPage.openEligibilityModal();
        eligibilityModalPage.verifyCloseButton();
        eligibilityModalPage.verifyEligibilityLabelName("Eligibility criteria");
        eligibilityModalPage.verifyEligibilityList(list);
        eligibilityModalPage.closeEligibilityModal();

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

    @Test
    public void verify_terms_conditions_page() {
        launchPage = new LaunchPage(driver);
        ProductCarouselPage prodCarPage = launchPage.logInToProductCarouselPage();
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage();
        TermsConditionsPage termsConditionsPage = appFlowPage.getTermsConditionsPage();
        termsConditionsPage.verifyTitleLabel("Welcome to a new way of banking");
        termsConditionsPage.verifyBodyTextLabel("We're committed to protecting the data you share with us. Please contact our customer care team with any queries.");
        termsConditionsPage.verifySignUpButton("Confirm");
        EligibilityConfirmPage eligibilityConfirmPage = termsConditionsPage.getEligibilityConfirmPage();

    }

    @Test
    public void verify_eligbility_page() {
        launchPage = new LaunchPage(driver);
        ProductCarouselPage prodCarPage = launchPage.logInToProductCarouselPage();
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage();
        TermsConditionsPage termsConditionsPage = appFlowPage.getTermsConditionsPage();
        EligibilityConfirmPage eligibilityConfirmPage = termsConditionsPage.getEligibilityConfirmPage();
        eligibilityConfirmPage.verifyTitleLabel("I'm eligible because...");
        eligibilityConfirmPage.verifyTipText("Tip: You are a US person if you are either a US citizen, a US resident or a Green Card holder.");
        eligibilityConfirmPage.verifyConfirmEligibleButton("I confirm I am eligible");
        eligibilityConfirmPage.verifyConfirmNotEligibleButton("I am not eligible");

    }

    @Test
    public void verify_capture_name_page() throws InterruptedException {
        launchPage = new LaunchPage(driver);
        ProductCarouselPage prodCarPage = launchPage.logInToProductCarouselPage();
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage();
        TermsConditionsPage termsConditionsPage = appFlowPage.getTermsConditionsPage();
        EligibilityConfirmPage eligibilityConfirmPage = termsConditionsPage.getEligibilityConfirmPage();
        NameCapturePage captureNamePage = eligibilityConfirmPage.getCaptureNamePage();
        captureNamePage.verifyBodyTextLabel("This name is just a friendly way for us to address you. " +
                "We won't show it on your DigiBank card or anything official.");
        captureNamePage.verifyTitleLabel("What should we call you?");
        captureNamePage.verifyNextButton("Next");
        captureNamePage.fillNameTextField("User");

    }

    @Test
    public void verify_capture_phone_page() throws InterruptedException {
        launchPage = new LaunchPage(driver);
        ProductCarouselPage prodCarPage = launchPage.logInToProductCarouselPage();
        AppFlowPage appFlowPage = prodCarPage.getAppFlowPage();
        TermsConditionsPage termsConditionsPage = appFlowPage.getTermsConditionsPage();
        EligibilityConfirmPage eligibilityConfirmPage = termsConditionsPage.getEligibilityConfirmPage();
        NameCapturePage captureNamePage = eligibilityConfirmPage.getCaptureNamePage();
        captureNamePage.fillNameTextField("User");
        PhoneCapturePage phoneCapturePage = captureNamePage.getPhoneCapturePage();
        phoneCapturePage.fillPhoneNumberField("1123456789", true);
        phoneCapturePage.fillPhoneNumberField("1223456789", false);
        phoneCapturePage.fillPhoneNumberField("122345678", true);
        phoneCapturePage.verifyConfirmButton("Confirm");
        phoneCapturePage.verifyTitleLabel("What is your mobile number?");
    }
}
