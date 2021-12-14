package steps.o2;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o2.PopUpAllowCameraModal;
import pages.ios.o2.ScanMyKad1009Page;

public class ScanMyKad1009Steps extends BaseClass {

    ScanMyKad1009Page scanMyKad1009Page;

    @Then("I verify scan NRIC page is loaded")
    public void verfyIdentityPageLoaded() {
        scanMyKad1009Page = new ScanMyKad1009Page(iosDriver);
        Assert.assertTrue(scanMyKad1009Page.isLoaded(iosDriver));
    }

    @When("I am progressing to allow access camera pop up")
    public PopUpAllowCameraModal continueToAllowCamera() {
        scanMyKad1009Page = new ScanMyKad1009Page(iosDriver);
        return scanMyKad1009Page.getCameraPopUp(iosDriver);
    }
}
