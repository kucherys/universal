package pages.o2;

import capabilities.BaseClassIos;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ScanMyKad1009Page extends BaseClassIos {

    By title = By.id("label.title");
    By textDescription = By.id("label.description");
    By verifyIdentityButton = By.id("button.verifyIdentity");


    public ScanMyKad1009Page(IOSDriver<IOSElement> driver) {
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver) {
        return driver.findElement(verifyIdentityButton).isDisplayed();
    }

    public void verifyDescription(String expectedName) {
        String actualName = driver.findElement(textDescription).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = driver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public PopUpAllowCameraModal getCameraPopUp(IOSDriver<IOSElement> driver){
        driver.findElement(verifyIdentityButton).click();
        return new PopUpAllowCameraModal(driver);
    }
}
