package steps.o3;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o3.CheckingDetails1530Page;
import pages.ios.o3.ReviewDetails116Page;
import pages.ios.o4.SetUserName586Page;

public class CheckingDetails1530Steps extends BaseClass {

    CheckingDetails1530Page checkingDetails1530Page;

    @Then("I verify progress account creation page is loaded")
    public void verfyReviewDetailsPageLoaded() {
        checkingDetails1530Page = new CheckingDetails1530Page(iosDriver);
        Assert.assertTrue(checkingDetails1530Page.isLoaded(iosDriver));
    }

//    @Then("^I edit personal details with value (.+)$")
//    public void editPersonal(String detailsToEdit) {
//        reviewDetails116Page = new ReviewDetails116Page(iosDriver);
//        reviewDetails116Page.editPersonalDetail(detailsToEdit);
//
//    }

    @Then("I create my account")
    public SetUserName586Page confirmDetails() {
        checkingDetails1530Page = new CheckingDetails1530Page(iosDriver);
        return checkingDetails1530Page.submitApplication(iosDriver);
    }
}
