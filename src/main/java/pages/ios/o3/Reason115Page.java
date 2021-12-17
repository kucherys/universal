package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class Reason115Page extends BaseClass {

    By title = By.id("label.title");
    By textLabel = By.id("label.description");
    By dailySpendingCheckbox = By.id("checkbox.dailySpendings");
    By savingCheckbox = By.id("checkbox.saving");
    By financingCheckbox = By.id("label.financing");
    By otherCheckbox = By.id("checkbox.other");
    By confirmButton = By.id("button.confirm");


    public Reason115Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(dailySpendingCheckbox).isDisplayed();
    }

    public void selectCheckbox(String checkboxName) {
        switch (checkboxName) {
            case "Daily spending":
                iosDriver.findElement(dailySpendingCheckbox).click();
                break;

            case "Saving":
                iosDriver.findElement(savingCheckbox).click();
                break;

            case "Financing":
                iosDriver.findElement(financingCheckbox).click();
                break;

            case "Other":
                iosDriver.findElement(otherCheckbox).click();
                break;
        }
    }

    public ReviewDetails116Page confirmReason(IOSDriver<IOSElement> iosDriver) {
        iosDriver.findElement(confirmButton).click();
        return new ReviewDetails116Page(iosDriver);
    }

}
