package pages;

import capabilities.BaseClassPage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class EligibilityConfirmPage extends BaseClassPage {


    NameCapturePage captureNamePage;

    By titleLabel = By.id("label.title");
    By bodyText = By.id("label.description");
    By eligibleButton = By.id("button.eligible");
    By notEligibleButton = By.id("button.notEligible");
    By checkboxNationality = By.id("button.nationality");
    By checkboxUsCitizen = By.id("button.usCitizenship");
    By checkboxTaxRes = By.id("button.taxResidency");
    By textTip = By.id("text.tip");

    By confirmEligibleButton = By.id("button.eligible");

    public EligibilityConfirmPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver){
        return driver.findElement(eligibleButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = driver.findElement(titleLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyTipText(String expectedName){
        String actualName = driver.findElement(textTip).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyConfirmEligibleButton(String expectedName){
        String actualName = driver.findElement(eligibleButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyConfirmNotEligibleButton(String expectedName){
        String actualName = driver.findElement(notEligibleButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void selectAllEligCheckboxes (   IOSDriver<IOSElement> driver) throws InterruptedException {
        driver.findElement(checkboxNationality).click();
        driver.findElement(checkboxUsCitizen).click();
        driver.findElement(checkboxTaxRes).click();
    }


    public NameCapturePage getCaptureNamePage (   IOSDriver<IOSElement> driver) throws InterruptedException {
        driver.findElement(checkboxNationality).click();
        driver.findElement(checkboxUsCitizen).click();
        driver.findElement(checkboxTaxRes).click();
        driver.findElement(eligibleButton).click();
        TimeUnit.SECONDS.sleep(1);
        return new NameCapturePage(driver);
    }

    public NameCapturePage confirmeligibility (   IOSDriver<IOSElement> driver) throws InterruptedException {
        driver.findElement(eligibleButton).click();
        TimeUnit.SECONDS.sleep(1);
        return new NameCapturePage(driver);
    }
}
