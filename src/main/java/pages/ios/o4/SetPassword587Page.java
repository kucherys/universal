package pages.ios.o4;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SetPassword587Page extends BaseClass {

    By title = By.id("label.title");
    By nextButton = By.id("button.submit");

    public SetPassword587Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(nextButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }
}
