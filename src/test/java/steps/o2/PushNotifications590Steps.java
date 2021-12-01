package steps.o2;

import capabilities.BaseClassIos;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o2.OneTimePass609Page;
import pages.o2.PopUpNotificationModal;
import pages.o2.PushNotifications590Page;

public class PushNotifications590Steps extends BaseClassIos {

    PushNotifications590Page pushNotifications590Page;

    @Then("I verify receive push notifications page is loaded")
    public void verfyReceiveNotificationPageLoaded() {
        pushNotifications590Page = new PushNotifications590Page(driver);
        Assert.assertTrue(pushNotifications590Page.isLoaded(driver));
    }

    @When("I enable push notifications")
    public PopUpNotificationModal enablePushNotifications() {
        pushNotifications590Page = new PushNotifications590Page(driver);
        return pushNotifications590Page.getPushNotificationsModal(driver);
    }
}
