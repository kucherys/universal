package pages.o2;

import capabilities.BaseClassIos;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyId604Page extends BaseClassIos {

    By title = By.id("label.mainTitle");
    By labelDescription = By.id("label.description");
    By continueButton = By.id("button.continue");


    public VerifyId604Page(IOSDriver<IOSElement> driver) {
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver) {
        return driver.findElement(continueButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = driver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public ScanMyKad1009Page getScanMyKadPage(IOSDriver<IOSElement> driver){
        driver.findElement(continueButton).click();
        return new ScanMyKad1009Page(driver);
    }
}
