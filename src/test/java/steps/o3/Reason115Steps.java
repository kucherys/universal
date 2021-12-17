package steps.o3;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o3.EmplType114Page;
import pages.ios.o3.Reason115Page;
import pages.ios.o3.ReviewDetails116Page;

public class Reason115Steps extends BaseClass {

    Reason115Page reason115Page;

    @Then("I verify reasons for account page is loaded")
    public void verfyReceiveNotificationPageLoaded() {
        reason115Page = new Reason115Page(iosDriver);
        Assert.assertTrue(reason115Page.isLoaded(iosDriver));
    }

    @Then("^I select checkbox option (.+)$")
    public void fillEmail(String checkBox) {
        reason115Page = new Reason115Page(iosDriver);
        reason115Page.selectCheckbox(checkBox);
    }

    @When("I confirm reasons for account filled")
    public ReviewDetails116Page confirmDetails() {
        reason115Page = new Reason115Page(iosDriver);
        return reason115Page.confirmReason(iosDriver);
    }
}
