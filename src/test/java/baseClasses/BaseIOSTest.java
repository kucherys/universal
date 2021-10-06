package baseClasses;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseIOSTest {

public static IOSDriver DesiredCapabilities () throws MalformedURLException {


        DesiredCapabilities cap = new DesiredCapabilities();

        //StartEmulator();
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
        cap.setCapability("commandTimeouts", "12000");
        cap.setCapability(MobileCapabilityType.APP, "Users/syky/Documents/TestAutomation/UIKitCatalog.app");

        IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), cap);

        return driver;

    }


}
