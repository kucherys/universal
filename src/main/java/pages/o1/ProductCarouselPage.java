package pages.o1;

import capabilities.BaseClassIos;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCarouselPage extends BaseClassIos {

    LaunchPage launchPage;

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

    public ProductCarouselPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver){
        System.out.println(driver.findElement(openBankAccountButton));
        return driver.findElement(openBankAccountButton).isDisplayed();
    }

    public void verifyOpenBankAccountButton(String expectedName){
        String actualName = driver.findElement(openBankAccountButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyEligibilityLabel(String expectedName){
        String actualName = driver.findElement(eligibleButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyLogoLabel(String expectedName){
        String actualName = driver.findElement(logoLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyInstructionText(String expectedName){
        String actualName = driver.findElement(instructionText).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public EligibilityModalPage openEligibilityModal(IOSDriver<IOSElement> driver){
        driver.findElementByAccessibilityId("button.eligibilityCriteria").click();
        return new EligibilityModalPage(driver);
    }

    public LaunchPage backToPreviousPage (){
        driver.findElementByClassName(buttonBack).click();
        launchPage = new LaunchPage(driver);
        return launchPage;
    }

    public ProductCarouselPage spinToCarouselPage(String pageNb, IOSDriver<IOSElement> driver){
        ProductCarouselPage productCarouselPage;
        switch (pageNb) {
            case ("1"):
                productCarouselPage = getProductCarouselPage(driver, spinButton1);
                break;
            case ("2"):
                productCarouselPage = getProductCarouselPage(driver, spinButton2);
                break;
            case ("3"):
                productCarouselPage = getProductCarouselPage(driver, spinButton3);
                break;
            case ("4"):
                productCarouselPage = getProductCarouselPage(driver, spinButton4);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pageNb);
        }
        return productCarouselPage;
    }

    public void verifyImagePresent(){
        Assert.assertTrue(driver.findElement(carouselImage).isDisplayed());
    }

    public ProductCarouselPage getProductCarouselPage(IOSDriver<IOSElement> driver, By locator){
        driver.findElement(locator).click();
        return new ProductCarouselPage(driver);
    }

    public AppFlowPage getAppFlowPage(IOSDriver<IOSElement> driver){
        driver.findElement(openBankAccountButton).click();
        return new AppFlowPage(driver);
    }

}
