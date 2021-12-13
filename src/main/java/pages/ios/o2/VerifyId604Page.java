package pages.ios.o2;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyId604Page extends BaseClass {

    By title = By.id("label.mainTitle");
    By labelDescription = By.id("label.description");
    By continueButton = By.id("button.continue");


    public VerifyId604Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(continueButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public ScanMyKad1009Page getScanMyKadPage(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(continueButton).click();
        return new ScanMyKad1009Page(iosDriver);
    }
}
