package pages.pagesAndroid.o1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCarouselPage {
    AndroidDriver<AndroidElement> driver;

    By openBankAccountButton = By.id("carousel_open_account_btn");
    By eligibleButton = By.id("carousel_eligible");
    By eligibleButtonText = By.id("carousel_eligible_txt");
    By logoLabel = By.id("carousel_title");
    By instructionText = By.id("carousel_subtitle");
    By carouselImage = By.id("carousel_img");

    By spinButton1 = By.id("carousel_tab_1");
    By spinButton2 = By.id("carousel_tab_2");
    By spinButton3 = By.id("carousel_tab_3");
    By spinButton4 = By.id("carousel_tab_4");


    public ProductCarouselPage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
    }

    public boolean isLoaded(AndroidDriver<AndroidElement> driver){
        return driver.findElement(openBankAccountButton).isDisplayed();
    }
    public void verifyImagePresent(){
        Assert.assertTrue(driver.findElement(carouselImage).isDisplayed());
    }

    public void verifyOpenBankAccountButton(String expectedName){
        String actualName = driver.findElement(openBankAccountButton).getText();
        Assert.assertEquals(actualName, expectedName);
    }

    public void verifyEligibilityLabel(String expectedName){
        String actualName = driver.findElement(eligibleButtonText).getText();
        Assert.assertEquals(actualName, expectedName);  //leave
    }

    public void verifyLogoLabel(String expectedName){
        String actualName = driver.findElement(logoLabel).getText().replace("\n", " ");
        Assert.assertEquals(actualName, expectedName);
    }

    public void verifyInstructionText(String expectedName){
        String actualName = driver.findElement(instructionText).getText().replace("\n", " ");
        Assert.assertEquals(actualName, expectedName);
    }

//    public EligibilityModalPage openEligibilityModal(){
//        driver.findElement(eligibleButton).click();
//        return new EligibilityModalPage(driver);
//    }

    public ProductCarouselPage spinToCarouselPage(String pageNb, AndroidDriver<AndroidElement> driver){
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

    public ProductCarouselPage getProductCarouselPage(AndroidDriver<AndroidElement> driver, By locator){
        driver.findElement(locator).click();
        return new ProductCarouselPage(driver);
    }

}
