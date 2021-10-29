package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AppFlowPage {
    IOSDriver<IOSElement> driver;

    By backArrow = By.id("button.back");
    By titleLabel = By.id("label.title");
    By textFirstLable = By.id("label.firstDescription");
    By textSecondLable = By.id("label.secondDescription");
    By signUpButton = By.id("button.letsStart");
    String progressSignUp = "label.title_0";
    String progressPersonalDetails = "label.title_1";
    String progressCreateAccount = "label.title_2";
    String progressTopUpAccount = "label.title_3";
    By progressSignUpText = By.id("progress.signUpText");

    ProductCarouselPage productCarouselPage;
    TermsConditionsPage termsConditionsPage;

    public AppFlowPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public ProductCarouselPage verifyBackArrowButton(){
        driver.findElement(backArrow).click();
        productCarouselPage = new ProductCarouselPage(driver);
        return productCarouselPage;
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = driver.findElement(titleLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyFirstTextLabel(String expectedName){
        String actualName = driver.findElement(textFirstLable).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySecondTextLabel(String expectedName){
        String actualName = driver.findElement(textSecondLable).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyProgressBarStatus(boolean expectedStatus, String expectedName){
        boolean actualStatus = driver.findElement(signUpButton).isEnabled();
        Assert.assertEquals(expectedStatus, actualStatus);
        String actualName = driver.findElement(progressSignUpText).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyProgressBarLabels(String expSignUpLabel, String expPersDetLabel, String expCreAccLabel, String expToUpAccLabel){
        IOSElement elActFirst = driver.findElementByAccessibilityId(progressSignUp);
        Assert.assertEquals(expSignUpLabel, elActFirst.getText());
        IOSElement elActSecond = driver.findElementByAccessibilityId(progressPersonalDetails);
        Assert.assertEquals(expPersDetLabel, elActSecond.getText());
        IOSElement elActThird = driver.findElementByAccessibilityId(progressCreateAccount);
        Assert.assertEquals(expCreAccLabel, elActThird.getText());
        IOSElement elActFourth = driver.findElementByAccessibilityId(progressTopUpAccount);
        Assert.assertEquals(expToUpAccLabel, elActFourth.getText());
    }

    public void verifySignUpButton(String expectedName){
        String actualName = driver.findElement(signUpButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public TermsConditionsPage getTermsConditionsPage(){
        driver.findElement(signUpButton).click();
        termsConditionsPage = new TermsConditionsPage(driver);
        return termsConditionsPage;
    }

    }
