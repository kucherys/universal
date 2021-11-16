package steps;

import capabilities.BaseClass;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.AppFlowPage;
import pages.TermsConditionsPage;

public class TermsConditionsSteps extends BaseClass {

    AppFlowPage appFlowPage;
    TermsConditionsPage termsConditionsPage;

    @When("I verify terms and conditions page is loaded")
    public void verfyTermsAndConditionsPageLoaded() {
        termsConditionsPage = new TermsConditionsPage(driver);
        Assert.assertTrue(termsConditionsPage.isLoaded(driver));
    }

    @When("I'm processing to terms and conditions page")
    public void getTermsConditionsPage()  {
        appFlowPage = new AppFlowPage(driver);
        termsConditionsPage = appFlowPage.getTermsConditionsPage(driver);
    }

}
