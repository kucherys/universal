package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LaunchPage {

    IOSDriver<IOSElement> driver;

    By logInButton = By.id("button.logIn");
    By signUpButton = By.id("button.signUp");
    By welcomeLabel = By.id("label.welcome");

    public LaunchPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public void verifyLogInButton(String expectedName){
        String actualName = driver.findElement(logInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySignUpButton(String expectedName){
        String actualName = driver.findElement(signUpButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyWelcomeLabel(String expectedName){
        String actualName = driver.findElement(welcomeLabel).getText();
//        String actualName = driver.findElementByAccessibilityId("Welcome to ARBM Digibank").getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void logInToProductCarouselPage(){
        driver.findElement(signUpButton).click();
    }
}
