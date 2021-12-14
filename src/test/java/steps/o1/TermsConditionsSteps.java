package steps.o1;

import capabilities.BaseClass;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o1.AppFlowPage;
import pages.ios.o1.TermsConditionsPage;

public class TermsConditionsSteps extends BaseClass {

    AppFlowPage appFlowPage;
    TermsConditionsPage termsConditionsPage;

    @When("I verify terms and conditions page is loaded")
    public void verfyTermsAndConditionsPageLoaded() throws InterruptedException {
        termsConditionsPage = new TermsConditionsPage(iosDriver);
        Assert.assertTrue(termsConditionsPage.isLoaded(iosDriver));
    }

    @When("I'm processing to terms and conditions page")
    public void getTermsConditionsPage()  {
        appFlowPage = new AppFlowPage(iosDriver);
        termsConditionsPage = appFlowPage.getTermsConditionsPage(iosDriver);
    }

}
