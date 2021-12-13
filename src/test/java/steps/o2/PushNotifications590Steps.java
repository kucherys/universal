package steps.o2;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o2.PopUpNotificationModal;
import pages.ios.o2.PushNotifications590Page;

public class PushNotifications590Steps extends BaseClass {

    PushNotifications590Page pushNotifications590Page;

    @Then("I verify receive push notifications page is loaded")
    public void verfyReceiveNotificationPageLoaded() {
        pushNotifications590Page = new PushNotifications590Page(iosDriver);
        Assert.assertTrue(pushNotifications590Page.isLoaded(iosDriver));
    }

    @When("I enable push notifications")
    public PopUpNotificationModal enablePushNotifications() {
        pushNotifications590Page = new PushNotifications590Page(iosDriver);
        return pushNotifications590Page.getPushNotificationsModal(iosDriver);
    }
}
