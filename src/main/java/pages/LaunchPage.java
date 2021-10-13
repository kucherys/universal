package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LaunchPage {

    IOSDriver<IOSElement> driver;

    By logInButton = By.id("button.logIn");
    By signInButton = By.id("button.signIn");
    String welcomeLabel = "label.welcome";

    ProductCarouselPage productCarouselPage;

    public LaunchPage(IOSDriver<IOSElement> driver){
        this.driver = driver;
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

    public ProductCarouselPage logInToProductCarouselPage(){
        driver.findElement(signInButton).click();
        productCarouselPage = new ProductCarouselPage(driver);
        return productCarouselPage;
    }
}
