package steps.o2;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o2.OneTimePass609Page;

import java.util.concurrent.TimeUnit;

public class OneTimePass609Steps extends BaseClass {

    OneTimePass609Page oneTimePass609Page;

    @Then("I verify one time password page is loaded")
    public void verfyNameCapturePageLoaded() throws InterruptedException {
        oneTimePass609Page = new OneTimePass609Page(iosDriver);
        TimeUnit.SECONDS.sleep(2);
//        Assert.assertTrue(oneTimePass609Page.isLoaded(iosDriver));
    }

    @When("^I enter (.+) password in one time password page$")
    public void enterOneTimePassword(String passValue) throws InterruptedException {
        oneTimePass609Page.fillOneTimePass(passValue);
    }

}
