package steps.o2;

import capabilities.BaseClass;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o2.OneTimePass609Page;
import pages.ios.o2.Progress270Page;
import pages.ios.o2.ScanMyKad1009Page;
import pages.ios.o2.VerifyId604Page;
import pages.ios.o3.UserDetails112Page;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Progress270Steps extends BaseClass {

    Progress270Page progress270Page;

    @Then("I verify progress page with status 2 is loaded")
    public void verfyProgressPageLoaded() throws InterruptedException {
        progress270Page = new Progress270Page(iosDriver);
        TimeUnit.SECONDS.sleep(2);
        Assert.assertTrue(progress270Page.isLoaded(iosDriver));
    }

    @Then("I verify elements on application progress page")
    public void verifyElements(DataTable table)  {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows){
            progress270Page.verifyTitleLabel(row.get("logoLabel"));
        }
    }

    @When("I progress to create account phase and filling user details")
    public UserDetails112Page continueToNextStage() {
        progress270Page = new Progress270Page(iosDriver);
        return progress270Page.getUserDetails112Page(iosDriver);
    }
}
