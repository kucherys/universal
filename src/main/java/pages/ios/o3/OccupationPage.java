package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class OccupationPage extends BaseClass {

    By accountantOption = By.id("value_picker_cell.Accountant");
    By architectOption = By.id("value_picker_cell.Architect");

    public OccupationPage(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public void selectOccupation(String status) {
        switch (status) {
            case "Accountant":
                iosDriver.findElement(accountantOption).click();
                break;

            case "Architect":
                iosDriver.findElement(architectOption).click();
                break;

        }
    }
}
