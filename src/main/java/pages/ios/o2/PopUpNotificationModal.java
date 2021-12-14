package pages.ios.o2;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PopUpNotificationModal extends BaseClass {

    By title = By.id("label.title");
    String allowOption = "Allow";
    By enableButton = By.id("button.enable");
    By maybeLaterButton = By.id("button.maybeLater");

    public PopUpNotificationModal(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(enableButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void allowPopUps() {
        iosDriver.switchTo().alert().accept();
    }
}
