package steps;

import capabilities.BaseClassPage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;
import pages.LaunchPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class IosLandingSteps extends BaseClassPage {

//    public static IOSDriver<IOSElement> driver;

    LaunchPage launchPage;

    @Given("Appium server is running")
    public void appiumServerIsRunning() {
        service = startServer();
    }

    @Given("Appium server and simulator with application started")
    public void appiumServerAndApplicationRunning() throws IOException, InterruptedException {
        setupClassGlobal();
    }

    @When("I verify landing page is loaded")
    public void getLandingPage() {
        launchPage = new LaunchPage(driver);
        Assert.assertTrue(launchPage.isLoaded(driver));
    }

    @Then("^I verify elements (.+) and (.+) and (.+) on landing page$")
    public void verifyElementsLandingPage(String logInButton, String welcomeLabel, String signUpButton) {
        launchPage.verifyWelcomeLabel(welcomeLabel);
        launchPage.verifyLogInButton(logInButton);
        launchPage.verifySignUpButton(signUpButton);
    }


    @Then("^I verify all elements on landing page$")
    public void verifyElementsLandingPage() {
        launchPage.verifyLogInButton("Log In");
        launchPage.verifyWelcomeLabel("Welcome to ARBM Digibank");
        launchPage.verifySignUpButton("I'm new to [ARBM Digibank]");

    }

    @Then("^I verify elements on landing page$")
    public void verifyElementsLandingPageData(DataTable dataTable) {
        List<Map<String, String>> data =  dataTable.asMaps(String.class, String.class);
        String logInButton = data.get(0).get("LogInButton");
        String logoLabel = data.get(0).get("LogoLabel");
        String signUpButton = data.get(0).get("SignUpButton");
        System.out.println(logInButton + " " + logoLabel + " " + signUpButton);
    }


    @Then("^I verify word (.+)$")
    public void verifyLandingPageEl(String logInButton) {
        System.out.println(logInButton);
    }

    @After
    public void stopAppiumServer(){
        System.out.println("Spop appium server");
        service.stop();
    }
}
