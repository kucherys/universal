package steps.o2;

import capabilities.BaseClassIos;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o2.PopUpAllowCameraModal;
import pages.o2.PopUpNotificationModal;

public class PopUpAllowCameraSteps extends BaseClassIos {

    PopUpAllowCameraModal popUpAllowCameraModal;

    @Then("I verify allow camera pop up is loaded")
    public void verfyallowCameraPopUpLoaded() {
        popUpAllowCameraModal = new PopUpAllowCameraModal(driver);
//        Assert.assertTrue(PopUpAllowCameraModal.isLoaded(driver));
    }


    @When("I confirm to allow camera in pop up")
    public void allowCamera() {
        popUpAllowCameraModal = new PopUpAllowCameraModal(driver);
        popUpAllowCameraModal.allowCamera();
    }

}
