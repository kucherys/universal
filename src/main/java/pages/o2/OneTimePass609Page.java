package pages.o2;

import capabilities.BaseClassIos;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OneTimePass609Page extends BaseClassIos {

    By title = By.id("label.title");
    By bodyTextLabel = By.id("label.description");
    By nextButton = By.id("button.submit");
    By passwordField = By.id("textfield.code");

    public OneTimePass609Page(IOSDriver<IOSElement> driver) {
        this.driver = driver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> driver) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return driver.findElement(nextButton).isDisplayed();
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = driver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyBodyTextLabel(String expectedName) {
        String actualName = driver.findElement(bodyTextLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyNextButton(String expectedName) {
        String actualName = driver.findElement(nextButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void fillOneTimePass(String pass) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        List<String> list = Arrays.asList(pass);
        for (String a : list) {
            driver.findElement(passwordField).sendKeys(a);
        }

    }

}
