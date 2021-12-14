package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class UserDetails112Page extends BaseClass {

    By title = By.id("label.title");
    By emailField = By.id("textfield.email");
    By maritalStatusField = By.id("textfield.marital_status");
    By ethnicityField = By.id("textfield.ethnicity");
    By confirmButton = By.id("button.confirm");


    public UserDetails112Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) {
        return iosDriver.findElement(confirmButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void fillEmail(String emailValue) {
        iosDriver.findElement(emailField).sendKeys(emailValue);
    }

    public UserDetails112Page fillMaritalStatus(String maritalStatus) {
        iosDriver.findElement(maritalStatusField).click();
        new MaritalStatusPage(iosDriver).selectMaritalStatus(maritalStatus);
        return new UserDetails112Page(iosDriver);
    }

    public UserDetails112Page fillEthnicityField(String ethnicityFieldValue) {
        iosDriver.findElement(ethnicityField).click();
        new EthnicityPage(iosDriver).selectEthnicity(ethnicityFieldValue);
        return new UserDetails112Page(iosDriver);

    }

    public EmplType114Page getEmploymentType114Page(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(confirmButton).click();
        return new EmplType114Page(iosDriver);
    }


}
