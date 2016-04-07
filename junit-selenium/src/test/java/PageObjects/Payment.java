package PageObjects;

import WebDrivers.BaseWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by wysocz on 06/04/16.
 */
public class Payment {

    private static final By locatorHeading = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[1]/h2");
    private static final By locatorFirstName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div/div/ng-form/div[1]/div[2]/input");
    private static final By locatorFirstLastName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div/div/ng-form/div[1]/div[3]/input");
    private static final By locatorSelectFirst = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div/div/ng-form/div[1]/div[1]/div/select");
    private static final By locatorSelectSecond = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div[2]/div/ng-form/div[1]/div[1]/div/select");
    private static final By locatorSecondName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div[2]/div/ng-form/div[1]/div[2]/input");
    private static final By locatorSecondLastName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div[2]/div/ng-form/div[1]/div[3]/input");
    private static final By locatorContactEmail = By.xpath("//*[@id=\\\"payment-contact-form\\\"]/div[2]/contact-details-form/div/div[1]/div[2]/input");
    private static final By locatorContactCountry = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/contact-details-form/div/div[1]/div[3]/div/div[1]/div/select");
    private static final By locatorContactPhone = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/contact-details-form/div/div[1]/div[3]/div/div[2]/input");
    private static final By locatorPay = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[6]/button");
    private static final String baseUrl = "https://www.ryanair.com/pl/pl/booking/payment";


    public Payment() {
    }

    public static Payment navigateTo() throws IOException {

        BaseWebDriver.Initialize();
        BaseWebDriver.navigate(baseUrl);
        isOnPage();

        return new Payment();

    }
    public static void isOnPage() {

        WebElement heading = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorHeading));

        Assert.assertTrue("Not on ryanair Booking Payment page, URL: " + BaseWebDriver.Instance.getCurrentUrl(), BaseWebDriver.isOnPage(baseUrl));


    }

    public void firstAdult() {

        //TODO Get rid of Hardcoded Strings!

        WebElement select = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorSelectFirst));
        Helper.select(locatorSelectFirst, "Pan");
        select.sendKeys(Keys.TAB);

        WebElement name = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorFirstName));

        name.sendKeys("John");

        WebElement surname = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorFirstLastName));

        surname.sendKeys("Smith");

    }

    public void secondAdult() {

        //TODO Hardcoded strings 2!


        WebElement select = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorSelectSecond));
        Helper.select(locatorSelectSecond, "Pani");
        select.sendKeys(Keys.TAB);

        WebElement name = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorSecondName));

        name.sendKeys("Jane");

        WebElement surname = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorSecondLastName));

        surname.sendKeys("Smith");

    }


    public void contact() {

    }


    public void pay() throws InterruptedException {

        WebElement button = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorPay));
        button.click();

    }

}
