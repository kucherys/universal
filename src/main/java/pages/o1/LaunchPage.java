package pages.o1;

import capabilities.BaseClassIos;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LaunchPage extends BaseClassIos {

    By logInButton = By.id("button.logIn");
    By signInButton = By.id("button.signIn");
    String welcomeLabel = "label.welcome";

    public LaunchPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver){
        return driver.findElement(logInButton).isDisplayed();
    }

    public void verifyLogInButton(String expectedName){
        String actualName = driver.findElement(logInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySignUpButton(String expectedName){
        String actualName = driver.findElement(signInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyWelcomeLabel(String expectedName){
        String actualName = driver.findElementByAccessibilityId(welcomeLabel).getText().replace("\n", " ");
        Assert.assertEquals(expectedName, actualName);
    }

    public ProductCarouselPage logInToProductCarouselPage(IOSDriver<IOSElement> driver){
        driver.findElement(signInButton).click();
        return new ProductCarouselPage(driver);
    }

}
