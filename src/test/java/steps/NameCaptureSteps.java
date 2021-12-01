package steps;

import capabilities.BaseClassIos;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o1.EligibilityConfirmPage;
import pages.o1.NameCapturePage;
import pages.o1.PhoneCapturePage;

public class NameCaptureSteps extends BaseClassIos {

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
