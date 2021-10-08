package tests.ios;

import baseClasses.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class AppiumiOSTest extends BaseClass {

    @Test
    public void iosEmulator() throws IOException, InterruptedException{
        IOSDriver<IOSElement> driver = capabilities("Digibank.app");
        System.out.println("Test started");
//        String actualText = driver.findElementByXPath("//*[contains(@name,'message')]").getText();
//        System.out.println(actualText);
//        driver.findElementByAccessibilityId("I'm new to [ARBM Digibank]").click();
//        driver.findElementByXPath("XCUIElementTypeStaticText[@name='Text Entry']").click();
//        driver.findElementByXPath("//XCUIElementTypeCell").sendKeys("hello");
//        driver.findElementByAccessibilityId("OK").click();
        System.out.println("Test finished");
    }

}
