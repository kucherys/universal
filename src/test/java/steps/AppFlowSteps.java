package steps;

import capabilities.BaseClassPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.AppFlowPage;
import pages.LaunchPage;
import pages.ProductCarouselPage;

import java.util.List;
import java.util.Map;

public class AppFlowSteps extends BaseClassPage {

    ProductCarouselPage prodCarPage;
    AppFlowPage appFlowPage;

    @When("I verify application flow page is loaded")
    public void verfyAppFlowPageLoaded() {
        appFlowPage = new AppFlowPage(driver);
        Assert.assertTrue(appFlowPage.isLoaded(driver));
    }

    @When("I am openning bank account")
    public void getAppFlowPage()  {
        prodCarPage = new ProductCarouselPage(driver);
        appFlowPage = prodCarPage.getAppFlowPage(driver);
    }

    @Then("I verify elements on application flow page")
    public void verifyProductCarouselElements(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows){
            prodCarPage.verifyOpenBankAccountButton(row.get("openBankAccountButton"));
            prodCarPage.verifyEligibilityLabel(row.get("eligibilityLabel"));
            prodCarPage.verifyInstructionText(row.get("instructionText"));
            prodCarPage.verifyLogoLabel(row.get("logoLabel"));
        }
    }
}
