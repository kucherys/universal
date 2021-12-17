package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import pages.ios.o4.SetUserName586Page;

public class CheckingDetails1530Page extends BaseClass {

    By title = By.id("label.title");
    By textLabel = By.id("label.description");
    By dailySpendingCheckbox = By.id("checkbox.dailySpendings");
    By otherCheckbox = By.id("checkbox.other");
    By createAccountButton = By.id("button.title");

    public CheckingDetails1530Page (IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(createAccountButton).isDisplayed();
    }

    public SetUserName586Page submitApplication (IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(createAccountButton).click();
        return new SetUserName586Page(iosDriver);
    }


}
