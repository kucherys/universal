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

public class LandingSteps extends BaseClassPage {

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
    public void verifyLandingPageLoaded() {
        launchPage = new LaunchPage(driver);
        Assert.assertTrue(launchPage.isLoaded(driver));
    }

    @Then("^I verify elements (.+) and (.+) and (.+) on landing page$")
    public void verifyElementsLandingPage(String logInButton, String welcomeLabel, String signUpButton) {
        launchPage.verifyWelcomeLabel(welcomeLabel);
        launchPage.verifyLogInButton(logInButton);
        launchPage.verifySignUpButton(signUpButton);
    }

    @Then("I verify elements on landing page")
    public void verifyElementsLandingDataPage(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows){
            launchPage.verifyLogInButton(row.get("logInButton"));
            launchPage.verifyWelcomeLabel(row.get("logoLabel"));
            launchPage.verifySignUpButton(row.get("signUpButton"));
        }
    }

    @After
    public void stopAppiumServer(){
        System.out.println("Spop appium server");
        service.stop();
    }
}
