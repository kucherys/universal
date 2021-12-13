package pages.ios.o1;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TermsConditionsPage extends BaseClass {

    EligibilityConfirmPage eligibilityConfirmPage;

    By titleLabel = By.id("label.title");
    By bodyText = By.id("label.description");
    By confirmButton = By.id("button.confirm");
    By checkbox = By.id("checkbox.button");
    By personelData  = By.id("cell.index_0");

    public TermsConditionsPage(IOSDriver<IOSElement> driver){
        this.iosDriver = iosDriver;
    }

    TermsConditionsPage termsConditionsPage;

    public boolean isLoaded(IOSDriver<IOSElement> driver) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return driver.findElement(checkbox).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = iosDriver.findElement(titleLabel).getText();
//        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyBodyTextLabel(String expectedName){
        String actualName = iosDriver.findElement(bodyText).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySignUpButton(String expectedName){
        String actualName = iosDriver.findElement(confirmButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyPersonalDataText(String expectedName){
        String actualName = iosDriver.findElement(personelData).getText();
        Assert.assertEquals(actualName, expectedName);
    }

    public EligibilityConfirmPage getEligibilityConfirmPage (IOSDriver<IOSElement> iosDriver){
        termsConditionsPage = new TermsConditionsPage(iosDriver);
//        driver.findElement(checkbox).click();
//        driver.findElement(confirmButton).click();
        return new EligibilityConfirmPage(iosDriver);
    }
}
