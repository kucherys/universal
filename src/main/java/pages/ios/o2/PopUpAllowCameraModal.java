package pages.ios.o2;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PopUpAllowCameraModal extends BaseClass {

    By title = By.id("label.title");
    String allowOption = "Allow";
    By enableButton = By.id("button.enable");

    public PopUpAllowCameraModal(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(enableButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void allowCamera() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        iosDriver.switchTo().alert().accept();
    }
}
