package steps;

import capabilities.BaseClassIos;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o1.EligibilityConfirmPage;
import pages.o1.NameCapturePage;
import pages.o1.PhoneCapturePage;
import pages.o2.OneTimePass609Page;

public class PhoneCaptureSteps extends BaseClassIos {

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

    @When("I confirm mobile number and progress to one time password page")
    public OneTimePass609Page getOnetimePassword() {
        phoneCapturePage = new PhoneCapturePage(driver);
        return phoneCapturePage.getOneTimePass609Page(driver);
    }
}
