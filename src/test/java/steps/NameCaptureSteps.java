package steps;

import capabilities.BaseClass;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o1.EligibilityConfirmPage;
import pages.ios.o1.NameCapturePage;
import pages.ios.o1.PhoneCapturePage;

public class NameCaptureSteps extends BaseClass {

    EligibilityConfirmPage eligibilityConfirmPage;
    NameCapturePage nameCapturePage;
    PhoneCapturePage phoneCapturePage;

    @When("I verify name capture page is loaded")
    public void verfyNameCapturePageLoaded() {
        nameCapturePage = new NameCapturePage(iosDriver);
        Assert.assertTrue(nameCapturePage.isLoaded(iosDriver));
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
        nameCapturePage = new NameCapturePage(iosDriver);
        return nameCapturePage.getPhoneCapturePage(iosDriver);
    }


}
