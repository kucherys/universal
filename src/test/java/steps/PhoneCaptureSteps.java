package steps;

import capabilities.BaseClass;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o1.EligibilityConfirmPage;
import pages.ios.o1.NameCapturePage;
import pages.ios.o1.PhoneCapturePage;
import pages.ios.o2.OneTimePass609Page;

public class PhoneCaptureSteps extends BaseClass {

    EligibilityConfirmPage eligibilityConfirmPage;
    NameCapturePage nameCapturePage;
    PhoneCapturePage phoneCapturePage;

    @When("I verify phone capture page is loaded")
    public void verfyPhoneCapturePageLoaded() {
        phoneCapturePage = new PhoneCapturePage(iosDriver);
        Assert.assertTrue(phoneCapturePage.isLoaded(iosDriver));
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

    @When("I confirm mobile number and progress to one time password page")
    public OneTimePass609Page getOnetimePassword() {
        phoneCapturePage = new PhoneCapturePage(iosDriver);
        return phoneCapturePage.getOneTimePass609Page(iosDriver);
    }
}
