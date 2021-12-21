package steps.o3;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o3.CheckingDetails1530Page;
import pages.ios.o3.ReviewDetails116Page;

public class ReviewDetails116Steps extends BaseClass {

    ReviewDetails116Page reviewDetails116Page;

    @Then("I verify review details page is loaded")
    public void verfyReviewDetailsPageLoaded() {
        reviewDetails116Page = new ReviewDetails116Page(iosDriver);
        Assert.assertTrue(reviewDetails116Page.isLoaded(iosDriver));
    }

    @Then("^I edit personal details with value (.+)$")
    public void editPersonal(String detailsToEdit) {
        reviewDetails116Page = new ReviewDetails116Page(iosDriver);
        reviewDetails116Page.editPersonalDetail(detailsToEdit);
    }

    @When("I submit application from review details screen")
    public CheckingDetails1530Page confirmDetails() {
        reviewDetails116Page = new ReviewDetails116Page(iosDriver);
        return reviewDetails116Page.submitApplication(iosDriver);
    }
}
