package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class EthnicityPage  extends BaseClass {

    By malayOption = By.id("value_picker_cell.Malay");
    By chineseOption = By.id("value_picker_cell.Chinese");

    public EthnicityPage(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public void selectEthnicity(String status) {
        switch (status) {
            case "Malay":
                iosDriver.findElement(malayOption).click();
                break;
            case "Chinese":
                iosDriver.findElement(chineseOption).click();
                break;

        }
    }
}
