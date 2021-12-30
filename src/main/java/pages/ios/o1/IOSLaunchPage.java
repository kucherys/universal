package pages.ios.o1;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class IOSLaunchPage extends BaseClass {

    By logInButton = By.id("button.logIn");
    By signInButton = By.id("button.signIn");
    String welcomeLabel = "label.welcome";

    public IOSLaunchPage(IOSDriver<IOSElement> iosDriver){
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver){
        return iosDriver.findElement(logInButton).isDisplayed();
    }

    public void verifyLogInButton(String expectedName){
        String actualName = iosDriver.findElement(logInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySignUpButton(String expectedName){
        String actualName = iosDriver.findElement(signInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyWelcomeLabel(String expectedName){
        String actualName = iosDriver.findElementByAccessibilityId(welcomeLabel).getText().replace("\n", " ");
        Assert.assertEquals(expectedName, actualName);
    }

    public ProductCarouselPage logInToProductCarouselPage(IOSDriver<IOSElement> driver){
        driver.findElement(signInButton).click();
        return new ProductCarouselPage(driver);
    }

    public String getLogInButtonName(){
        return iosDriver.findElement(logInButton).getText();

    }

}
