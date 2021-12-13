package steps.o2;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o2.ScanMyKad1009Page;
import pages.ios.o2.VerifyId604Page;

public class VerifyId604Steps extends BaseClass {

    VerifyId604Page verifyId604Page;

    @Then("I verify identity page is loaded")
    public void verfyIdentityPageLoaded() {
        verifyId604Page = new VerifyId604Page(iosDriver);
        Assert.assertTrue(verifyId604Page.isLoaded(iosDriver));
    }

    @When("I continue to scan NRIC page")
    public ScanMyKad1009Page continueToScanNric() {
        verifyId604Page = new VerifyId604Page(iosDriver);
        return verifyId604Page.getScanMyKadPage(iosDriver);
    }
}
