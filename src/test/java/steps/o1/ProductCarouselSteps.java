package steps.o1;

import capabilities.BaseClass;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ios.o1.IOSLaunchPage;
import pages.ios.o1.ProductCarouselPage;

import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class ProductCarouselSteps extends BaseClass {

    IOSLaunchPage iosLaunchPage;
    ProductCarouselPage prodCarPage;

    @When("I verify product carousel page is loaded")
    public void verfyProdCarouselPageLoaded() {
        prodCarPage = new ProductCarouselPage(iosDriver);
        Assert.assertTrue(prodCarPage.isLoaded(iosDriver));
    }

    @When("I log in to product carousel page")
    public void getProductCarouselPage()  {
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        prodCarPage = iosLaunchPage.logInToProductCarouselPage(iosDriver);
    }

    @Then("I verify elements on product carousel page")
    public void verifyProductCarouselElements(DataTable table) throws InterruptedException {
            List<Map<String, String>> rows = table.asMaps(String.class, String.class);
            for (Map<String, String> row : rows){
                prodCarPage.verifyOpenBankAccountButton(row.get("openBankAccountButton"));
                prodCarPage.verifyEligibilityLabel(row.get("eligibilityLabel"));
                prodCarPage.verifyInstructionText(row.get("instructionText"));
            }
    }
//    public void verifyProductCarouselElements(DataTable table) throws InterruptedException {
//        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
//        for (Map<String, String> row : rows){
//            prodCarPage.spinToCarouselPage(row.get("pageNumber"), driver);
//            sleep(1000);
//            prodCarPage.verifyLogoLabel(row.get("logoText"));
//            prodCarPage.verifyOpenBankAccountButton(row.get("openBankAccountButton"));
//            prodCarPage.verifyEligibilityLabel(row.get("eligibilityLabel"));
//            prodCarPage.verifyInstructionText(row.get("instructionText"));
//            prodCarPage.verifyImagePresent();
//        }
//    }

    @Then("I verify elements on product carousel is spinning")
    public void verifyProductCarouselSpin() {
        for(int i = 0; i<3; i++) {
            iosDriver.findElementByAccessibilityId("pageControl").click();
        }

    }

}
