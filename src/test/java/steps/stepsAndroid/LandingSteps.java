package steps.stepsAndroid;

import capabilities.BaseClassAndroid;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.runners.Parameterized;
import org.testng.Assert;
import pages.pagesAndroid.o1.AndroidLaunchPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LandingSteps extends BaseClassAndroid {

    AndroidLaunchPage androidLaunchPage;

//    @Given("Appium server and simulator with application started")
//    public void appiumServerAndApplicationRunning() throws IOException, InterruptedException {
//        setupClassGlobal();
//    }
//
//    @When("I verify landing page is loaded")
//    public void verifyLandingPageLoaded() {
//        androidLaunchPage = new AndroidLaunchPage(driver);
//        Assert.assertTrue(androidLaunchPage.isLoaded(driver));
//    }
//
//    @Then("I verify elements on landing page")
//    public void verifyElementsLandingPage() {
//        androidLaunchPage = new AndroidLaunchPage(driver);
//        androidLaunchPage.verifyLogo();
//        androidLaunchPage.verifyWelcomeLabel("Welcome to", "ARBM Digibank");
//        androidLaunchPage.verifySignUpButton("I'm new to [ARBM Digibank]");
//        androidLaunchPage.verifyLogInButton("Log In");
//    }
//
//    @Then("I verify elements on landing page with values")
//    public void verifyElementsLandingDataPage(List<Map<String, String>> animals) {
//        System.out.println(animals);
//    }
//
//    @Then("I stop appium server")
//    public void stopApiumServer() {
//        service.stop();
//    }


}
