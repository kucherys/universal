package steps;

import capabilities.BaseClassPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LaunchPage;
import pages.ProductCarouselPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class IosProductCarouselSteps extends BaseClassPage {

//    public static IOSDriver<IOSElement> driver;

    LaunchPage launchPage;
    ProductCarouselPage prodCarPage;

    @When("I log in to product carousel page")
    public void getProductCarouselPage()  {
        launchPage = new LaunchPage(driver);
        prodCarPage = launchPage.logInToProductCarouselPage(driver);
    }

    @Then("I verify elements on product carousel page")
    public void verifyProductCarouselElements(DataTable table) {
            List<Map<String, String>> rows = table.asMaps(String.class, String.class);
            for (Map<String, String> row : rows){
                prodCarPage.verifyOpenBankAccountButton(row.get("openBankAccountButton"));
                prodCarPage.verifyEligibilityLabel(row.get("eligibilityLabel"));
                prodCarPage.verifyInstructionText(row.get("instructionText"));
                prodCarPage.verifyLogoLabel(row.get("logoLabel"));
            }
    }

    @Then("I verify elements on product carousel is spinning")
    public void verifyProductCarouselSpin() {
        for(int i = 0; i<3; i++) {
            driver.findElementByAccessibilityId("pageControl").click();
        }

    }

}
