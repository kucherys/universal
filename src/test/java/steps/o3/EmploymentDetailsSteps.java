package steps.o3;

import capabilities.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o3.EmplType114Page;
import pages.ios.o3.Reason115Page;
import pages.ios.o3.UserDetails112Page;

public class EmploymentDetailsSteps extends BaseClass {

    EmplType114Page emplType114Page;

    @Then("I verify employment details page is loaded")
    public void verfyEmploymentDetailsPageLoaded() throws InterruptedException {
        emplType114Page = new EmplType114Page(iosDriver);
        Assert.assertTrue(emplType114Page.isLoaded(iosDriver));
    }

    @Then("^I fill employer name as (.+)$")
    public void fillEmployerName(String empName) {
        emplType114Page = new EmplType114Page(iosDriver);
        emplType114Page.fillEmplName(empName);
    }

    @Then("^I fill employment type as (.+)$")
    public void fillEmploymentType(String type) {
        emplType114Page = new EmplType114Page(iosDriver);
        emplType114Page.fillEmplType(type);
    }

    @Then("^I fill occupation as (.+)$")
    public void fillOccupation(String occupation) {
        emplType114Page = new EmplType114Page(iosDriver);
        emplType114Page.fillOccupation(occupation);
    }

    @Then("^I fill employment sector as (.+)$")
    public void fillSector(String sector) {
        emplType114Page = new EmplType114Page(iosDriver);
        emplType114Page.fillSector(sector);
    }

    @Then("^I fill Annual income as (.+)$")
    public void fillIncome(String income) {
        emplType114Page = new EmplType114Page(iosDriver);
        emplType114Page.fillIncome(income);
    }

    @When("I confirm employment details filled")
    public Reason115Page confirmDetails() {
        emplType114Page = new EmplType114Page(iosDriver);
        return emplType114Page.confirmDetails(iosDriver);
    }
}
