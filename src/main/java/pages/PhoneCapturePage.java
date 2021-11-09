package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PhoneCapturePage {
    IOSDriver<IOSElement> driver;

    By titleLabel = By.id("label.title");
    By phoneNumberField = By.id("textfield.phone_number");
    By confirmButton = By.id("button.submit");

    public PhoneCapturePage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver) {
        return driver.findElement(phoneNumberField).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = driver.findElement(titleLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void getConfirmButtonName(String expectedName){
        String actualName = driver.findElement(confirmButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void fillPhoneNumberField(String number){
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).click();
        driver.findElement(phoneNumberField).sendKeys(number);
    }
//
//    public void verifyConfirmButtonStatus(boolean expectedStatus){
//        boolean actualStatus = driver.findElement(confirmButton).isEnabled();
//        Assert.assertEquals(expectedStatus, actualStatus);
//    }

    public boolean getConfirmButtonStatus(){
        return driver.findElement(confirmButton).isEnabled();
    }

}
