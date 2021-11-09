package steps;

import capabilities.BaseClassPage;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.EligibilityConfirmPage;
import pages.NameCapturePage;
import pages.PhoneCapturePage;

public class PhoneCaptureSteps extends BaseClassPage {

    EligibilityConfirmPage eligibilityConfirmPage;
    NameCapturePage nameCapturePage;
    PhoneCapturePage phoneCapturePage;

    @When("I verify phone capture page is loaded")
    public void verfyPhoneCapturePageLoaded() {
        phoneCapturePage = new PhoneCapturePage(driver);
        Assert.assertTrue(phoneCapturePage.isLoaded(driver));
    }

    @When("^I enter (.+) phone value in phone capture screen$")
    public void enterValidPhoneNumbet(String phoneNumber) {
        phoneCapturePage.fillPhoneNumberField(phoneNumber);
    }

    @When("^I verify status of Confirm button is (.+)$")
    public void verifyConfirmButton(String status) {
        if (status.equals("disabled")) {
            Assert.assertFalse(phoneCapturePage.getConfirmButtonStatus());
        } else if (status.equals("enabled")) {
            Assert.assertTrue(phoneCapturePage.getConfirmButtonStatus());
        }
    }
}
