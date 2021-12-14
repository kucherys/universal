package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import pages.ios.o2.PopUpNotificationModal;

public class Reason115Page extends BaseClass {

    By title = By.id("label.title");
    By employmentField = By.id("textfield.employmentType");



    public Reason115Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(title).isDisplayed();
    }

    public void fillEmplName(String emplName) {
        iosDriver.findElement(employmentField).sendKeys(emplName);
    }
}
