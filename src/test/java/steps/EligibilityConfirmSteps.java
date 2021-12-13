package steps;

import capabilities.BaseClass;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o1.EligibilityConfirmPage;
import pages.ios.o1.NameCapturePage;
import pages.ios.o1.TermsConditionsPage;

public class EligibilityConfirmSteps extends BaseClass {

    TermsConditionsPage termsConditionsPage;
    EligibilityConfirmPage eligibilityConfirmPage;
    NameCapturePage nameCapturePage;

    @When("I verify eligibility page is loaded")
    public void verfyEligibilityPageLoaded() {
        eligibilityConfirmPage = new EligibilityConfirmPage(iosDriver);
        Assert.assertTrue(eligibilityConfirmPage.isLoaded(iosDriver));
    }

    @When("I confirm all terms and conditions are met")
    public void getEligibilityConditionsPage()  {
        termsConditionsPage = new TermsConditionsPage(iosDriver);
        eligibilityConfirmPage = termsConditionsPage.getEligibilityConfirmPage(iosDriver);
    }

    @When("I select all eligibility criteria on eligibility page")
    public void selectAllEligibilityCheckboxesPage() throws InterruptedException {
        eligibilityConfirmPage.selectAllEligCheckboxes(iosDriver);
    }

    @When("I confirm I am eligible and progress to name capture page")
    public void getNamePage() throws InterruptedException {
        eligibilityConfirmPage = new EligibilityConfirmPage(iosDriver);
        nameCapturePage = eligibilityConfirmPage.confirmeligibility(iosDriver);
    }
}
