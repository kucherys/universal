package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCarouselPage {
    IOSDriver<IOSElement> driver;

    By openBankAccountButton = By.id("button.openBankAccount");
    By eligibleLabel = By.id("button.eligibilityCriteria");


    public ProductCarouselPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public void verifyOpenBankAccountButton(String expectedName){
        String actualName = driver.findElement(openBankAccountButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyEligibilityLabel(String expectedName){
        String actualName = driver.findElement(eligibleLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

}
