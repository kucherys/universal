package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class IncomePage extends BaseClass {

    By maxIncomeOption = By.id("value_picker_cell.Less than RM 12,000");
    By minIncomeOption = By.id("value_picker_cell.RM 120,000 and above");

    public IncomePage (IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public void selectIncome(String status) {
        switch (status) {
            case "Less than RM 12,000":
                iosDriver.findElement(maxIncomeOption).click();
                break;

            case "RM 120,000 and above":
                iosDriver.findElement(minIncomeOption).click();
                break;

        }
    }
}
