package pages.ios.o2;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ScanMyKad1009Page extends BaseClass {

    By title = By.id("label.title");
    By textDescription = By.id("label.description");
    By verifyIdentityButton = By.id("button.verifyIdentity");


    public ScanMyKad1009Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver) {
        return driver.findElement(verifyIdentityButton).isDisplayed();
    }

    public void verifyDescription(String expectedName) {
        String actualName = iosDriver.findElement(textDescription).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public PopUpAllowCameraModal getCameraPopUp(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(verifyIdentityButton).click();
        return new PopUpAllowCameraModal(iosDriver);
    }
}
