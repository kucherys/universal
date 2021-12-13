package pages.ios.o1;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AppFlowPage extends BaseClass {

    By backArrow = By.id("button.back");
    By titleLabel = By.id("label.title");
    By textLableDescription = By.id("label.description");
    By signUpButton = By.id("button.title");
    String progressSignUp = "label.title_0";
    String progressPersonalDetails = "label.title_1";
    String progressCreateAccount = "label.title_2";
    String progressTopUpAccount = "label.title_3";
    By progressSignUpText = By.id("progress.signUpText");

    ProductCarouselPage productCarouselPage;

    public AppFlowPage(IOSDriver<IOSElement> iosDriver){
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver){
        return iosDriver.findElement(titleLabel).isDisplayed();
    }

    public ProductCarouselPage verifyBackArrowButton(){
        iosDriver.findElement(backArrow).click();
        productCarouselPage = new ProductCarouselPage(iosDriver);
        return productCarouselPage;
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = iosDriver.findElement(titleLabel).getText();
        Assert.assertEquals(actualName, expectedName);
    }

    public void verifyLabelDescription(String expectedName){
        String actualName = iosDriver.findElement(textLableDescription).getText();
        Assert.assertEquals(actualName, expectedName);
    }

    public void verifyProgressBarStatus(boolean expectedStatus, String expectedName){
        boolean actualStatus = iosDriver.findElement(signUpButton).isEnabled();
        Assert.assertEquals(expectedStatus, actualStatus);
        String actualName = iosDriver.findElement(progressSignUpText).getText();
        Assert.assertEquals(actualName, expectedName);
    }

    public void verifyProgressBarLabels(String expSignUpLabel, String expPersDetLabel, String expCreAccLabel, String expToUpAccLabel){
        IOSElement elActFirst = iosDriver.findElementByAccessibilityId(progressSignUp);
        Assert.assertEquals(expSignUpLabel, elActFirst.getText());
        IOSElement elActSecond = iosDriver.findElementByAccessibilityId(progressPersonalDetails);
        Assert.assertEquals(expPersDetLabel, elActSecond.getText());
        IOSElement elActThird = iosDriver.findElementByAccessibilityId(progressCreateAccount);
        Assert.assertEquals(expCreAccLabel, elActThird.getText());
        IOSElement elActFourth = iosDriver.findElementByAccessibilityId(progressTopUpAccount);
        Assert.assertEquals(expToUpAccLabel, elActFourth.getText());
    }

    public void verifySignUpButton(String expectedName){
        String actualName = iosDriver.findElement(signUpButton).getText();
        Assert.assertEquals(actualName, expectedName);
    }

    public TermsConditionsPage getTermsConditionsPage(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(signUpButton).click();
        return new TermsConditionsPage(iosDriver);
    }

    }
