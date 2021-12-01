package steps.o2;

import capabilities.BaseClassIos;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o2.OneTimePass609Page;
import pages.o2.PopUpNotificationModal;

public class PopUpNotificationSteps extends BaseClassIos {

    PopUpNotificationModal popUpNotificationModal;

    @Then("I verify allow notifications pop up opened")
    public void verfyallowNotificationsPopUpLoaded() {
        popUpNotificationModal = new PopUpNotificationModal(driver);
//        Assert.assertTrue(popUpNotificationModal.isLoaded(driver));
    }


    @When("I allow notification in pop up")
    public void allowNotifications() {
        popUpNotificationModal = new PopUpNotificationModal(driver);
        popUpNotificationModal.allowPopUps();
    }


}
