package steps.o1;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o1.EligibilityModalPage;
import pages.ios.o1.ProductCarouselPage;

import java.util.List;

public class EligibilityModalSteps extends BaseClass {

    ProductCarouselPage prodCarPage;
    EligibilityModalPage eligPage;

    @When("I verify Eligibility criteria modal is loaded")
    public void verfyEligibilityModalLoaded() {
        eligPage = new EligibilityModalPage(iosDriver);
        Assert.assertTrue(eligPage.isLoaded(iosDriver));
    }

    @Then("I verify elements on Eligibility criteria modal")
    public void verifyEligibilityCriteriaModal(List<String> listStr) {
        eligPage.verifyEligibilityLabelName("I'm eligible because...");
        eligPage.verifyEligibilityList(listStr);
    }

    @When("I verify if I am eligible")
    public void getEligibilityModal() {
        prodCarPage = new ProductCarouselPage(iosDriver);
        eligPage = prodCarPage.openEligibilityModal(iosDriver);
    }

    @Then("I close eligibility modal")
    public void closeEligibilityModal() {
        eligPage.closeEligibilityModal();
    }
}
