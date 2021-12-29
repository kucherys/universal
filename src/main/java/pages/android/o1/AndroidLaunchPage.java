package pages.android.o1;

import capabilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class AndroidLaunchPage extends BaseClass {

    By welcomeLogo = By.id("welcome_welcome");
    By welcomeTitle = By.id("welcome_title");
    By welcomeSubTitle = By.id("welcome_subtitle");
    By signInButton = By.id("welcome_register_btn");
    By logInButton = By.id("welcome_login_btn");

    public AndroidLaunchPage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
    }

    public boolean isLoaded(AndroidDriver<AndroidElement> driver){
        return driver.findElement(logInButton).isDisplayed();
    }

    public void verifyLogo(){
        List<AndroidElement> list = new ArrayList<>();
        list = androidDriver.findElements(welcomeLogo);
        Assert.assertTrue(list.size()==1);
    }

    public void verifyLogInButton(String expectedName){
        String actualName = androidDriver.findElement(logInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifySignUpButton(String expectedName){
        String actualName = androidDriver.findElement(signInButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public String getLogInButtonName(){
        return androidDriver.findElement(logInButton).getText();

    }

    public void verifyWelcomeLabel(String expectedLabel){
//        String actualLabel = androidDriver.findElement(welcomeTitle).getText();
//        Assert.assertEquals(expectedLabel, actualLabel);
    }

    public AndroidProductCarouselPage logInToProductCarouselPage(AndroidDriver<AndroidElement> driver){
        driver.findElement(signInButton).click();
        return new AndroidProductCarouselPage(driver);
    }


}
