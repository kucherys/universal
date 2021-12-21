package pages.ios.o2;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.ios.o3.UserDetails112Page;

public class Progress270Page extends BaseClass {

    By title = By.id("label.title");
    By labelDescription = By.id("label.description");
    By nextButton = By.id("button.title");


    public Progress270Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(nextButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public UserDetails112Page getUserDetails112Page(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(nextButton).click();
        return new UserDetails112Page(iosDriver);
    }
}
