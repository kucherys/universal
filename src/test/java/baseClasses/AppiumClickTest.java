package baseClasses;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;

import java.net.MalformedURLException;

public class AppiumClickTest extends BaseIOSTest{

    public static void main (String[] args) throws MalformedURLException {
        IOSDriver driver = DesiredCapabilities();

        driver.findElementByAccessibilityId("Alert Views").click();

        driver.findElementByAccessibilityId("Text Entry").click();

//        driver.findElementByXPath("XCUIElementTypeStaticText[@name='Text Entry']").click();
        driver.findElementByXPath("//XCUIElementTypeCell").sendKeys("hello");
        driver.findElementByAccessibilityId("OK").click();
        driver.findElementByAccessibilityId("Confirm / Cancel").click();
        String actualText = driver.findElementByXPath("//*[contains(@name,'message')]").getText();

        Assert.assertEquals(actualText, "A message should be a short, complete sentence.");
        driver.findElementByAccessibilityId("Confirm").click();


    }

}
