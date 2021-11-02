package steps;

import capabilities.Capabilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pages.LaunchPage;

import java.io.IOException;

public class IosLandingSteps extends Capabilities {

    public static IOSDriver<IOSElement> driver;

    LaunchPage launchPage;

        @Given("Appium server is running")
        public void appiumServerIsRunning() throws IOException, InterruptedException {
            service = startServer();
            System.out.println("Appium server is up and running");
        }

        @When("I open landing page")
        public void getLandingPage() throws IOException, InterruptedException {
            driver = capabilities("digibank-0.0.4-debug.apk");
            System.out.println("Android simulator started");
        }

        @Then("I verify elements on landing page")
        public void verifyElementsLandingPage() {
            launchPage = new LaunchPage(driver);
            launchPage.verifyLogInButton("Log In");
            launchPage.verifyWelcomeLabel("Welcome to ARBM Digibank");
            launchPage.verifySignUpButton("I'm new to [ARBM Digibank]");
        }

}
