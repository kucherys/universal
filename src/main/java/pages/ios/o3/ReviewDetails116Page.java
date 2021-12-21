package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class ReviewDetails116Page extends BaseClass {

    By title = By.id("label.title");
    By personalEditButton = By.id("button.edit.additional_details");
    By emailEdit = By.id("textfield.email");
    By submitAppButton = By.id("button.submit");

    UserDetails112Page userDetails112Page;

    public ReviewDetails116Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(submitAppButton).isDisplayed();
    }

    public void editPersonalDetail(String detailToEdit) {
        iosDriver.findElement(personalEditButton).click();
        userDetails112Page = new UserDetails112Page(iosDriver);
        userDetails112Page.updateEmail(detailToEdit);
        userDetails112Page.closeModal();
    }

    public CheckingDetails1530Page submitApplication (IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(submitAppButton).click();
        return new CheckingDetails1530Page(iosDriver);
    }
}
