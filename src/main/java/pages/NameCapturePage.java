package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NameCapturePage {

    IOSDriver<IOSElement> driver;

    By title = By.id("label.title");
    By bodyTextLabel = By.id("label.description");
    By nameTextField = By.id("textfield.nickname");
    By nextButton = By.id("button.submit");

    PhoneCapturePage phoneCapturePage;

    public NameCapturePage(IOSDriver<IOSElement> driver){
        this.driver = driver;
    }

    public void verifyTitleLabel(String expectedName){
        String actualName = driver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyBodyTextLabel(String expectedName){
        String actualName = driver.findElement(bodyTextLabel).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void verifyNextButton(String expectedName){
        String actualName = driver.findElement(nextButton).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public void fillNameTextField(String text){
        driver.findElement(nameTextField).click();
        driver.findElement(nameTextField).sendKeys(text);
    }

    public PhoneCapturePage getPhoneCapturePage (){
        driver.findElement(nextButton).click();
        phoneCapturePage = new PhoneCapturePage(driver);
        return phoneCapturePage;
    }

}
