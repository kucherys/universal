package pages.ios.o1;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NameCapturePage extends BaseClass {

    By title = By.id("label.title");
    By bodyTextLabel = By.id("label.description");
    By nameTextField = By.id("textfield.nickname");
    By nextButton = By.id("button.submit");

    PhoneCapturePage phoneCapturePage;

    public NameCapturePage(IOSDriver<IOSElement> iosDriver){
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver){
        return driver.findElement(title).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyBodyTextLabel(String expectedName){
        String actualName = iosDriver.findElement(bodyTextLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyNextButton(String expectedName){
        String actualName = iosDriver.findElement(nextButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void fillNameTextField(String text){
        iosDriver.findElement(nameTextField).click();
        iosDriver.findElement(nameTextField).sendKeys(text);
    }

    public PhoneCapturePage getPhoneCapturePage (IOSDriver<IOSElement> driver){
        driver.findElement(nextButton).click();
        return new PhoneCapturePage(driver);
    }

}
