package steps.o3;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o3.EmplType114Page;
import pages.ios.o3.UserDetails112Page;

public class UserDetails112Steps extends BaseClass {

    UserDetails112Page userDetails112Page;
    EmplType114Page emplType114Page;

    @Then("I verify additional user details page is loaded")
    public void verfyReceiveNotificationPageLoaded() {
        userDetails112Page = new UserDetails112Page(iosDriver);
        Assert.assertTrue(userDetails112Page.isLoaded(iosDriver));
    }

    @Then("^I fill email value as (.+)$")
    public void fillEmail(String email) {
        userDetails112Page = new UserDetails112Page(iosDriver);
        userDetails112Page.fillEmail(email);
    }

    @Then("^I fill marital status as (.+)$")
    public void selectMaritalStatus(String maritalStatus) {
        userDetails112Page = new UserDetails112Page(iosDriver);
        userDetails112Page.fillMaritalStatus(maritalStatus);
    }


    @Then("^I fill ethnicity as (.+)$")
    public void selectEthnicity(String ethnicity) {
        userDetails112Page = new UserDetails112Page(iosDriver);
        userDetails112Page.fillEthnicityField(ethnicity);
    }

    @When("I confirm user details filled")
    public EmplType114Page confirmDetails() {
        userDetails112Page = new UserDetails112Page(iosDriver);
        return userDetails112Page.getEmploymentType114Page(iosDriver);
    }

}
