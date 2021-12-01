package steps;

import capabilities.BaseClassIos;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o1.AppFlowPage;
import pages.o1.ProductCarouselPage;

import java.util.List;
import java.util.Map;

public class AppFlowSteps extends BaseClassIos {

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
    public void verifyAppFlowElements(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows){
            appFlowPage.verifyFirstTextLabel(row.get("labelFirst"));
            appFlowPage.verifySecondTextLabel(row.get("labelSecond"));
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
