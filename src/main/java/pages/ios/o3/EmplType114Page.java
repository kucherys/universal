package pages.ios.o3;

import capabilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class EmplType114Page extends BaseClass {

    By title = By.id("label.title");
    By employmentTypeField = By.id("textfield.employmentType");
    By employmentNameField = By.id("textfield.nameOfEmployer");
    By occupationField = By.id("textfield.occupation");
    By emplSectorField = By.id("textfield.employmentSector");
    By incomeField = By.id("textfield.annualIncome");
    By confirmButton = By.id("button.confirm");


    public EmplType114Page(IOSDriver<IOSElement> iosDriver) {
        this.iosDriver = iosDriver;
    }

    public boolean isLoaded(IOSDriver<IOSElement> iosDriver) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return iosDriver.findElement(employmentTypeField).isDisplayed();
    }

    public void fillEmplName(String emplName) {
        iosDriver.findElement(employmentNameField).sendKeys(emplName);
    }

    public void verifyTitleLabel(String expectedName) {
        String actualName = iosDriver.findElement(title).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    public EmplType114Page fillEmplType(String emplType) {
        iosDriver.findElement(employmentTypeField).click();
        new EmployerPage(iosDriver).selectEmployerType(emplType);
        return new EmplType114Page(iosDriver);
    }

    public EmplType114Page fillOccupation(String occupation) {
        iosDriver.findElement(occupationField).click();
        new OccupationPage(iosDriver).selectOccupation(occupation);
        return new EmplType114Page(iosDriver);
    }

    public EmplType114Page fillSector(String sector) {
        iosDriver.findElement(emplSectorField).click();
        new SectorPage(iosDriver).selectSector(sector);
        return new EmplType114Page(iosDriver);
    }

    public EmplType114Page fillIncome(String income) {
        iosDriver.findElement(incomeField).click();
        new IncomePage(iosDriver).selectIncome(income);
        return new EmplType114Page(iosDriver);
    }

    public Reason115Page confirmDetails(IOSDriver<IOSElement> iosDriver){
        iosDriver.findElement(confirmButton).click();
        return new Reason115Page(iosDriver);
    }
}
