package steps.o1;

import capabilities.BaseClass;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o1.AppFlowPage;
import pages.ios.o1.ProductCarouselPage;

import java.util.List;
import java.util.Map;

public class AppFlowSteps extends BaseClass {

    ProductCarouselPage prodCarPage;
    AppFlowPage appFlowPage;

    @When("I verify application flow page is loaded")
    public void verfyAppFlowPageLoaded() {
        appFlowPage = new AppFlowPage(iosDriver);
        Assert.assertTrue(appFlowPage.isLoaded(iosDriver));
    }

    @When("I am openning bank account")
    public void getAppFlowPage()  {
        prodCarPage = new ProductCarouselPage(iosDriver);
        appFlowPage = prodCarPage.getAppFlowPage(iosDriver);
    }

    @Then("I verify elements on application flow page")
    public void verifyAppFlowElements(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows){
            appFlowPage.verifyLabelDescription(row.get("labelDescription"));
            appFlowPage.verifySignUpButton(row.get("signUpButton"));
            appFlowPage.verifyTitleLabel(row.get("logoLabel"));
        }
    }

    @Then("I verify progress bar elements on application flow page")
    public void verifyProgressBarElements(List<String> list) {
        appFlowPage.verifyProgressBarLabels(list.get(0),list.get(1),list.get(2),list.get(3));
    }

    @Then("^I verify logo as (.+) on application flow page$")
    public void verifyLogo(String logo)  {
        appFlowPage.verifyTitleLabel(logo);
    }
}
