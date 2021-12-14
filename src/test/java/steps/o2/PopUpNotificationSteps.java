package steps.o2;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o2.PopUpNotificationModal;

public class PopUpNotificationSteps extends BaseClass {

    PopUpNotificationModal popUpNotificationModal;

//    @Then("I verify allow notifications pop up opened")
//    public void verfyallowNotificationsPopUpLoaded() {
//        popUpNotificationModal = new PopUpNotificationModal(iosDriver);
//        Assert.assertTrue(popUpNotificationModal.isLoaded(iosDriver));
//    }


    @When("I allow notification in pop up")
    public void allowNotifications() {
        popUpNotificationModal = new PopUpNotificationModal(iosDriver);
        popUpNotificationModal.allowPopUps();
    }


}
