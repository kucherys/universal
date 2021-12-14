package steps.o2;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o2.PopUpAllowCameraModal;
import pages.ios.o2.PopUpNotificationModal;

public class PopUpAllowCameraSteps extends BaseClass {

    PopUpAllowCameraModal popUpAllowCameraModal;

    @Then("I verify allow camera pop up is loaded")
    public void verfyallowCameraPopUpLoaded() {
        popUpAllowCameraModal = new PopUpAllowCameraModal(iosDriver);
//        Assert.assertTrue(PopUpAllowCameraModal.isLoaded(iosDriver));
    }


    @When("I confirm to allow camera in pop up")
    public void allowCamera() throws InterruptedException {
        popUpAllowCameraModal = new PopUpAllowCameraModal(iosDriver);
        popUpAllowCameraModal.allowCamera();
    }

}
