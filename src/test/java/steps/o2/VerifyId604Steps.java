package steps.o2;

import capabilities.BaseClassIos;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o2.ScanMyKad1009Page;
import pages.o2.VerifyId604Page;

public class VerifyId604Steps extends BaseClassIos {

    VerifyId604Page verifyId604Page;

    @Then("I verify identity page is loaded")
    public void verfyIdentityPageLoaded() {
        verifyId604Page = new VerifyId604Page(driver);
        Assert.assertTrue(verifyId604Page.isLoaded(driver));
    }

    @When("I continue to scan NRIC page")
    public ScanMyKad1009Page continueToScanNric() {
        verifyId604Page = new VerifyId604Page(driver);
        return verifyId604Page.getScanMyKadPage(driver);
    }
}
