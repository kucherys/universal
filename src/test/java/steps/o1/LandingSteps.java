package steps.o1;

import capabilities.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import org.testng.Assert;
import pages.android.o1.AndroidLaunchPage;
import pages.ios.o1.IOSLaunchPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LandingSteps extends BaseClass {

    IOSLaunchPage iosLaunchPage;
    AndroidLaunchPage androidLaunchPage;

    @Given("Appium server is running")
    public void appiumServerIsRunning() {
        service = startServer();
        System.out.println("APPIUM SERVER started");
    }

    @Given("^Appium server and simulator with application type (.+) started$")
    public void appiumServerAndApplicationiOSRunning(String appType) throws IOException, InterruptedException {
        setupClassGlobal(appType);
        System.out.println("IOS Emulator WAS started in HEADLESS mode");
    }

    @When("I verify landing page is loaded")
    public void verifyLandingPageLoaded() {
        if (getAppType().equals("iOS") ) {
            iosLaunchPage = new IOSLaunchPage(iosDriver);
            Assert.assertTrue(iosLaunchPage.isLoaded(iosDriver));
            System.out.println("IOS LAUNCH PAGE LOADED");
        } else if (appType.equals("Android") ) {
            androidLaunchPage = new AndroidLaunchPage(androidDriver);
            Assert.assertTrue(androidLaunchPage.isLoaded(androidDriver));
        }
    }

    @Then("I verify elements on landing page")
    public void verifyElementsLandingDataPage(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        if (getAppType().equals("iOS")) {
            for (Map<String, String> row : rows) {
                iosLaunchPage.verifyLogInButton(row.get("logInButton"));
                iosLaunchPage.verifyWelcomeLabel(row.get("logoLabel"));
                iosLaunchPage.verifySignUpButton(row.get("signUpButton"));
            }
        } else if (getAppType().equals("Android")) {
            for (Map<String, String> row : rows) {
                androidLaunchPage.verifyLogInButton(row.get("logInButton"));
                androidLaunchPage.verifyWelcomeLabel(row.get("logoLabel"));
                androidLaunchPage.verifySignUpButton(row.get("signUpButton"));
            }
        }
    }

    @Then("^I confirm tests completed with result (.+)$")
    public void confitmTests(String result) {
        System.out.println("CUCUMBER TESTS PASSED WITH RESULT: " + result);

    }

    @Then("^I confirm simple cucumber tests in status (.+)$")
    public void confitmSimpleTests(String result) {
        System.out.println("CUCUMBER TESTS PASSED WITH RESULT: " + result);

    }

    @Then("I print login button name")
    public void printButtonName() {

        if (getAppType().equals("iOS") ) {
            System.out.println("IOS BUTTON NAME IS : " + iosLaunchPage.getLogInButtonName());
        } else if (appType.equals("Android") ) {
            System.out.println("ANDROID BUTTON NAME IS : " + androidLaunchPage.getLogInButtonName());
        }

    }

    @After
    public void stopAppiumServer(){
        System.out.println("Stop appium server in INITIALIZATION class");
        service.stop();
    }
}
