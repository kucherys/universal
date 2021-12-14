package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class MaritalStatusPage extends BaseClass {

    By married = By.id("value_picker_cell.Married");
    By single = By.id("value_picker_cell.Single");

    public MaritalStatusPage(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public void selectMaritalStatus(String status) {
        switch (status) {
            case "Single":
                iosDriver.findElement(single).click();
            break;

            case "Married":
                iosDriver.findElement(married).click();
            break;

        }
    }

}
