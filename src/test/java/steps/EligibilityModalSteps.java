package steps;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.*;

import java.util.List;

public class EligibilityModalSteps extends BaseClass {

    ProductCarouselPage prodCarPage;
    EligibilityModalPage eligPage;

    @When("I verify Eligibility criteria modal is loaded")
    public void verfyEligibilityModalLoaded() {
        eligPage = new EligibilityModalPage(driver);
        Assert.assertTrue(eligPage.isLoaded(driver));
    }

    @Then("I verify elements on Eligibility criteria modal")
    public void verifyEligibilityCriteriaModal(List<String> listStr) {
        eligPage.verifyEligibilityLabelName("Eligibility criteria");
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
