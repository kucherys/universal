package steps.o4;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o3.CheckingDetails1530Page;
import pages.ios.o3.ReviewDetails116Page;
import pages.ios.o4.SetSecureWord275Page;
import pages.ios.o4.SetUserName586Page;

public class SetUsername586Steps extends BaseClass {

    SetUserName586Page setUserName586Page;

    @Then("I verify Set username page is loaded")
    public void verfyReviewDetailsPageLoaded() {
        setUserName586Page = new SetUserName586Page(iosDriver);
        Assert.assertTrue(setUserName586Page.isLoaded(iosDriver));
    }

    @Then("^I enter valid username with value (.+)$")
    public void createUsername(String userName) {
        setUserName586Page = new SetUserName586Page(iosDriver);
        setUserName586Page.setUserName(userName);

    }

    @When("I submit user name by button Next")
    public SetSecureWord275Page progressToSecureWordScreen() {
        setUserName586Page = new SetUserName586Page(iosDriver);
        return setUserName586Page.getSecureWord275Page(iosDriver);
    }
}
