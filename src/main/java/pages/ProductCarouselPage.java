package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCarouselPage {
    IOSDriver<IOSElement> driver;

    EligibilityModalPage eligibilityModalPage;
    AppFlowPage appFlowPage;
    LaunchPage launchPage;

    By openBankAccountButton = By.id("button.openBankAccount");
    By eligibleButton = By.id("button.eligibilityCriteria");
    By logoLabel = By.id("label.logo");
    By instructionText = By.id("label.carousel.0");
    String buttonBack = "Back";

    public ProductCarouselPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public void verifyOpenBankAccountButton(String expectedName){
        String actualName = driver.findElement(openBankAccountButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyEligibilityLabel(String expectedName){
        String actualName = driver.findElement(eligibleButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyLogoLabel(String expectedName){
        String actualName = driver.findElement(logoLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyInstructionText(String expectedName){
        String actualName = driver.findElement(instructionText).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public EligibilityModalPage openEligibilityModal(){
        driver.findElementByAccessibilityId("button.eligibilityCriteria").click();
        eligibilityModalPage = new EligibilityModalPage(driver);
        return eligibilityModalPage;
    }

    public LaunchPage backToPreviousPage (){
        driver.findElementByClassName(buttonBack).click();
        launchPage = new LaunchPage(driver);
        return launchPage;
    }

    public AppFlowPage getAppFlowPage(){
        driver.findElement(openBankAccountButton).click();
        appFlowPage = new AppFlowPage(driver);
        return appFlowPage;
    }

}
