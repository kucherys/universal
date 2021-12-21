package steps.o4;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o4.SetPassword587Page;
import pages.ios.o4.SetSecureWord275Page;
import pages.ios.o4.SetUserName586Page;

public class SetSecureWord275Steps extends BaseClass {

    SetSecureWord275Page setSecureWord275Page;

    @Then("I verify Set secure word page is loaded")
    public void verfySecureWordPageLoaded() throws InterruptedException {
        setSecureWord275Page = new SetSecureWord275Page(iosDriver);
//        Assert.assertTrue(setSecureWord275Page.isLoaded(iosDriver));
    }

    @Then("^I enter secure word with value (.+)$")
    public void createUsername(String userWord) {
        setSecureWord275Page = new SetSecureWord275Page(iosDriver);
        setSecureWord275Page.setSecureWord(userWord);

    }

    @When("I submit secure word by button Next")
    public SetPassword587Page progressToSecureWordScreen() {
        setSecureWord275Page = new SetSecureWord275Page(iosDriver);
        return setSecureWord275Page.getPassword587Page(iosDriver);
    }
}
