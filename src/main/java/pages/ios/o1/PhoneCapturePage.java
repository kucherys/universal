package pages.ios.o1;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.ios.o2.OneTimePass609Page;

public class PhoneCapturePage extends BaseClass {

    By titleLabel = By.id("label.title");
    By phoneNumberField = By.id("textfield.phone_number");
    By confirmButton = By.id("button.submit");

    public PhoneCapturePage(IOSDriver<IOSElement> iosDriver){
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(phoneNumberField).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = iosDriver.findElement(titleLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void getConfirmButtonName(String expectedName){
        String actualName = iosDriver.findElement(confirmButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void fillPhoneNumberField(String number){
        iosDriver.findElement(phoneNumberField).clear();
        iosDriver.findElement(phoneNumberField).click();
        iosDriver.findElement(phoneNumberField).sendKeys(number);
    }
//
//    public void verifyConfirmButtonStatus(boolean expectedStatus){
//        boolean actualStatus = driver.findElement(confirmButton).isEnabled();
//        Assert.assertEquals(expectedStatus, actualStatus);
//    }

    public boolean getConfirmButtonStatus(){
        return iosDriver.findElement(confirmButton).isEnabled();
    }

    public OneTimePass609Page getOneTimePass609Page (IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(confirmButton).click();
        return new OneTimePass609Page(iosDriver);
    }

}
