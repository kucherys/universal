package steps.o2;

import capabilities.BaseClassIos;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o2.PopUpAllowCameraModal;
import pages.o2.ScanMyKad1009Page;
import pages.o2.VerifyId604Page;

public class ScanMyKad1009Steps extends BaseClassIos {

    ScanMyKad1009Page scanMyKad1009Page;

    @Then("I verify scan NRIC page is loaded")
    public void verfyIdentityPageLoaded() {
        scanMyKad1009Page = new ScanMyKad1009Page(driver);
        Assert.assertTrue(scanMyKad1009Page.isLoaded(driver));
    }

    @When("I confirm to progress to identity verification pop up")
    public PopUpAllowCameraModal continueToAllowCamera() {
        scanMyKad1009Page = new ScanMyKad1009Page(driver);
        return scanMyKad1009Page.getCameraPopUp(driver);
    }
}
