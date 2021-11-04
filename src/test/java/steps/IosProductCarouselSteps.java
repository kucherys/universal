package steps;

import capabilities.BaseClassPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LaunchPage;
import pages.ProductCarouselPage;

import java.io.IOException;

public class IosProductCarouselSteps extends BaseClassPage {

//    public static IOSDriver<IOSElement> driver;

    LaunchPage launchPage;
    ProductCarouselPage prodCarPage;

    @When("I log in to product carousel page")
    public void getProductCarouselPage()  {
        launchPage = new LaunchPage(driver);
        prodCarPage = launchPage.logInToProductCarouselPage(driver);
    }

    @Then("I verify elements on product carousel page")
    public void verifyElementsLandingPage() {
        prodCarPage.verifyInstructionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ullamcorper aliquet risus");
        prodCarPage.verifyLogoLabel("DigiBank");
        prodCarPage.verifyOpenBankAccountButton("Open Bank Account");
        prodCarPage.verifyEligibilityLabel("Am I eligible?");
        for(int i = 0; i<3; i++) {
            driver.findElementByAccessibilityId("pageControl").click();
        }

    }

}
