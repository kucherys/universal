package pages.ios.o4;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SetSecureWord275Page extends BaseClass {

    By title = By.id("label.title");
    By usernameField = By.id("textfield.secureWord");
    By nextButton = By.id("button.submitKeyboard");
    By nextButtonDown = By.id("button.submit");


    public SetSecureWord275Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return iosDriver.findElement(nextButtonDown).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void setSecureWord(String username) {
        iosDriver.findElement(usernameField).sendKeys(username);
    }

    public SetPassword587Page getPassword587Page(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(nextButton).click();
        return new SetPassword587Page(iosDriver);
    }
}
