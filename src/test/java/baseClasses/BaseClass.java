package baseClasses;

import capabilities.Capabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass extends Capabilities {

        @BeforeClass
        public void setupClassGlobal(){
                System.out.println("Global class setup");
                service = startServer();
        }

        @AfterClass
        public void cleanUpClassGlobal(){
                System.out.println("Global class clean up");
                service.stop();
        }


        @BeforeMethod
        public void setupGlobal(){
                System.out.println("Global method setup");
        }

        @AfterMethod
        public void cleanUpGlobal(){
                System.out.println("Global method clean up");
        }

}
