package capabilities;

import capabilities.Capabilities;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

public class BaseClassPage extends Capabilities {

        public static IOSDriver<IOSElement> driver;

        @BeforeClass
        public void setupClassGlobal() throws IOException, InterruptedException {
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

        public String removeFirstLastChar(String str){
                return str = str.substring(1, str.length()-1);
        }


}
