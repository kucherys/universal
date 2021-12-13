package pages.ios.o2;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PushNotifications590Page extends BaseClass {

    By title = By.id("label.title");
    By bodyTextLabel = By.id("label.description");
    By enableButton = By.id("button.enable");
    By maybeLaterButton = By.id("button.maybeLater");


    public PushNotifications590Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver) {
        return driver.findElement(enableButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyBodyTextLabel(String expectedName) {
        String actualName = iosDriver.findElement(bodyTextLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyEnableButton(String expectedName) {
        String actualName = iosDriver.findElement(enableButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyMaybeLaterButton(String expectedName) {
        String actualName = iosDriver.findElement(maybeLaterButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public PopUpNotificationModal getPushNotificationsModal(IOSDriver<IOSElement> driver) {
        driver.findElement(enableButton).click();
        return new PopUpNotificationModal(driver);
    }

}
