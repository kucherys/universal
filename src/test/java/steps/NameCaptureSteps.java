package steps;

import capabilities.BaseClass;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.EligibilityConfirmPage;
import pages.NameCapturePage;
import pages.PhoneCapturePage;

public class NameCaptureSteps extends BaseClass {

    EligibilityConfirmPage eligibilityConfirmPage;
    NameCapturePage nameCapturePage;
    PhoneCapturePage phoneCapturePage;

    @When("I verify name capture page is loaded")
    public void verfyNameCapturePageLoaded() {
        nameCapturePage = new NameCapturePage(driver);
        Assert.assertTrue(nameCapturePage.isLoaded(driver));
    }

//    @When("^I enter (.+) value in name capture screen$")
//    public void enterUserName(String name) {
//        nameCapturePage.fillNameTextField(name);
//    }

    @When("^I enter (.+) value in name capture screen$")
    public void enterUserName(String name) {
        nameCapturePage.fillNameTextField(name);
    }

    @When("I am processing to phone capture page")
    public PhoneCapturePage getPhoneNumberPage() {
        nameCapturePage = new NameCapturePage(driver);
        return nameCapturePage.getPhoneCapturePage(driver);
    }


}
