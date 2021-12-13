package pages.ios.o1;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCarouselPage extends BaseClass {

    IOSLaunchPage iosLaunchPage;

    By openBankAccountButton = By.id("button.openBankAccount");
    By eligibleButton = By.id("button.eligibilityCriteria");
    By logoLabel = By.id("label.logo");
    By instructionText = By.id("label.carousel.0");
    String buttonBack = "Back";
    By carouselImage = By.id("carousel_img");
    By spinButton1 = By.id("carousel_tab_1");
    By spinButton2 = By.id("carousel_tab_2");
    By spinButton3 = By.id("carousel_tab_3");
    By spinButton4 = By.id("carousel_tab_4");

    public ProductCarouselPage(IOSDriver<IOSElement> iosDriver){
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver){
        System.out.println(iosDriver.findElement(openBankAccountButton));
        return iosDriver.findElement(openBankAccountButton).isDisplayed();
    }

    public void verifyOpenBankAccountButton(String expectedName){
        String actualName = iosDriver.findElement(openBankAccountButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyEligibilityLabel(String expectedName){
        String actualName = iosDriver.findElement(eligibleButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyLogoLabel(String expectedName){
        String actualName = iosDriver.findElement(logoLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyInstructionText(String expectedName){
        String actualName = iosDriver.findElement(instructionText).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public EligibilityModalPage openEligibilityModal(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElementByAccessibilityId("button.eligibilityCriteria").click();
        return new EligibilityModalPage(iosDriver);
    }

    public IOSLaunchPage backToPreviousPage (){
        iosDriver.findElementByClassName(buttonBack).click();
        iosLaunchPage = new IOSLaunchPage(iosDriver);
        return iosLaunchPage;
    }

    public ProductCarouselPage spinToCarouselPage(String pageNb, IOSDriver<IOSElement> iosDriver){
        ProductCarouselPage productCarouselPage;
        switch (pageNb) {
            case ("1"):
                productCarouselPage = getProductCarouselPage(iosDriver, spinButton1);
                break;
            case ("2"):
                productCarouselPage = getProductCarouselPage(iosDriver, spinButton2);
                break;
            case ("3"):
                productCarouselPage = getProductCarouselPage(iosDriver, spinButton3);
                break;
            case ("4"):
                productCarouselPage = getProductCarouselPage(iosDriver, spinButton4);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pageNb);
        }
        return productCarouselPage;
    }

    public void verifyImagePresent(){
        Assert.assertTrue(iosDriver.findElement(carouselImage).isDisplayed());
    }

    public ProductCarouselPage getProductCarouselPage(IOSDriver<IOSElement> driver, By locator){
        driver.findElement(locator).click();
        return new ProductCarouselPage(driver);
    }

    public AppFlowPage getAppFlowPage(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(openBankAccountButton).click();
        return new AppFlowPage(iosDriver);
    }

}
