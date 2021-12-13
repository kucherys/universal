package steps.o2;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ios.o2.PopUpAllowCameraModal;

public class PopUpAllowCameraSteps extends BaseClass {

    PopUpAllowCameraModal popUpAllowCameraModal;

    @Then("I verify allow camera pop up is loaded")
    public void verfyallowCameraPopUpLoaded() {
        popUpAllowCameraModal = new PopUpAllowCameraModal(iosDriver);
//        Assert.assertTrue(PopUpAllowCameraModal.isLoaded(driver));
    }


    @When("I confirm to allow camera in pop up")
    public void allowCamera() {
        popUpAllowCameraModal = new PopUpAllowCameraModal(iosDriver);
        popUpAllowCameraModal.allowCamera();
    }

}
