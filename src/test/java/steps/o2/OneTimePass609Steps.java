package steps.o2;

import capabilities.BaseClassIos;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o1.EligibilityConfirmPage;
import pages.o1.NameCapturePage;
import pages.o1.PhoneCapturePage;
import pages.o2.OneTimePass609Page;

public class OneTimePass609Steps extends BaseClassIos {

    OneTimePass609Page oneTimePass609Page;

    @Then("I verify one time password page is loaded")
    public void verfyNameCapturePageLoaded() throws InterruptedException {
        oneTimePass609Page = new OneTimePass609Page(driver);
        Assert.assertTrue(oneTimePass609Page.isLoaded(driver));
    }

    @When("^I enter (.+) password in one time password page$")
    public void enterOneTimePassword(String passValue) throws InterruptedException {
        oneTimePass609Page.fillOneTimePass(passValue);
    }

}
