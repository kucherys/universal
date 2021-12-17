package pages.ios.o4;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.ios.o3.EmplType114Page;

public class SetUserName586Page extends BaseClass {

    By title = By.id("label.title");
    By usernameField = By.id("textfield.username");

    By nextButton = By.id("button.submit");

    public SetUserName586Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(nextButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void setUserName(String username) {
        iosDriver.findElement(usernameField).sendKeys(username);
    }

    public SetSecureWord275Page getSecureWord275Page(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(nextButton).click();
        return new SetSecureWord275Page(iosDriver);
    }
}
