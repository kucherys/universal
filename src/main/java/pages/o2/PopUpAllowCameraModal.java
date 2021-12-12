package pages.o2;

import capabilities.BaseClassIos;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PopUpAllowCameraModal extends BaseClassIos {

    By title = By.id("label.title");
    String allowOption = "Allow";
    By enableButton = By.id("button.enable");
    By maybeLaterButton = By.id("button.maybeLater");

    public PopUpAllowCameraModal(IOSDriver<IOSElement> driver) {
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver) {
        return driver.findElement(enableButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = driver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void allowCamera() {
        driver.switchTo().alert().accept();
    }
}
