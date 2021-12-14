package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class SectorPage extends BaseClass {

    By constructionOption = By.id("value_picker_cell.Construction");
    By educationOption = By.id("value_picker_cell.Education");

    public SectorPage (IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public void selectSector(String status) {
        switch (status) {
            case "Construction":
                iosDriver.findElement(constructionOption).click();
                break;

            case "Education":
                iosDriver.findElement(educationOption).click();
                break;

        }
    }
}
