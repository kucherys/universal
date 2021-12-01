package steps;

import capabilities.BaseClassIos;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.o1.EligibilityConfirmPage;
import pages.o1.NameCapturePage;
import pages.o1.TermsConditionsPage;

public class EligibilityConfirmSteps extends BaseClassIos {

    TermsConditionsPage termsConditionsPage;
    EligibilityConfirmPage eligibilityConfirmPage;
    NameCapturePage nameCapturePage;

    @When("I verify eligibility page is loaded")
    public void verfyEligibilityPageLoaded() {
        eligibilityConfirmPage = new EligibilityConfirmPage(driver);
        Assert.assertTrue(eligibilityConfirmPage.isLoaded(driver));
    }

    @When("I confirm all terms and conditions are met")
    public void getEligibilityConditionsPage()  {
        termsConditionsPage = new TermsConditionsPage(driver);
        eligibilityConfirmPage = termsConditionsPage.getEligibilityConfirmPage(driver);
    }

    @When("I select all eligibility criteria on eligibility page")
    public void selectAllEligibilityCheckboxesPage() throws InterruptedException {
        eligibilityConfirmPage.selectAllEligCheckboxes(driver);
    }

    @When("I confirm I am eligible and progress to name capture page")
    public void getNamePage() throws InterruptedException {
        eligibilityConfirmPage = new EligibilityConfirmPage(driver);
        nameCapturePage = eligibilityConfirmPage.confirmeligibility(driver);
    }
}
