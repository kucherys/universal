package baseClasses;

import capabilities.Capabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

public class BaseClass extends Capabilities {

        public static IOSDriver<IOSElement> driver;

        @BeforeClass
        public void setupClassGlobal() throws IOException, InterruptedException {
                System.out.println("Global class setup");
                service = startServer();
                driver = capabilities("Digibank.app");
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
