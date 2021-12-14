package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class EmployerPage extends BaseClass {

    By employerOption = By.id("value_picker_cell.Employer");
    By studentOption = By.id("value_picker_cell.Student");

    public EmployerPage(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public void selectEmployerType(String status) {
        switch (status) {
            case "Employer":
                iosDriver.findElement(employerOption).click();
                break;

            case "Student":
                iosDriver.findElement(studentOption).click();
                break;

        }
    }
}
