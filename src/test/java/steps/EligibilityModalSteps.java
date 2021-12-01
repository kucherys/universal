package steps;

import capabilities.BaseClassIos;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o1.EligibilityModalPage;
import pages.o1.ProductCarouselPage;

import java.util.List;

public class EligibilityModalSteps extends BaseClassIos {

    ProductCarouselPage prodCarPage;
    EligibilityModalPage eligPage;

    @When("I verify Eligibility criteria modal is loaded")
    public void verfyEligibilityModalLoaded() {
        eligPage = new EligibilityModalPage(driver);
        Assert.assertTrue(eligPage.isLoaded(driver));
    }

    @Then("I verify elements on Eligibility criteria modal")
    public void verifyEligibilityCriteriaModal(List<String> listStr) {
        eligPage.verifyEligibilityLabelName("I'm eligible because...");
        eligPage.verifyEligibilityList(listStr);
    }

    @When("I verify if I am eligible")
    public void getEligibilityModal() {
        prodCarPage = new ProductCarouselPage(driver);
        eligPage = prodCarPage.openEligibilityModal(driver);
    }

    @Then("I close eligibility modal")
    public void closeEligibilityModal() {
        eligPage.closeEligibilityModal();
    }
}
