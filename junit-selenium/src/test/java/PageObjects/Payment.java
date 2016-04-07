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
public class Payment extends Extras{

    private static final By locatorHeading = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[1]/h2");
    private static final By locatorFirstName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div/div/ng-form/div[1]/div[2]/input");
    private static final By locatorFirstLastName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div/div/ng-form/div[1]/div[3]/input");
    private static final By locatorSelectFirst = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div/div/ng-form/div[1]/div[1]/div/select");
    private static final By locatorSelectSecond = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div[2]/div/ng-form/div[1]/div[1]/div/select");
    private static final By locatorSecondName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div[2]/div/ng-form/div[1]/div[2]/input");
    private static final By locatorSecondLastName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div[2]/div/ng-form/div[1]/div[3]/input");
    private static final By locatorContactEmail = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/contact-details-form/div/div[1]/div[2]/input");
    private static final By locatorContactCountry = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/contact-details-form/div/div[1]/div[3]/div/div[1]/div/select");
    private static final By locatorContactPhone = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/contact-details-form/div/div[1]/div[3]/div/div[2]/input");
    private static final By locatorPay = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[6]/button");
    private static final By locatorChildName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div[3]/div/ng-form/div[1]/div[1]/input");
    private static final By locatorChildLastName = By.xpath("//*[@id=\"checkout\"]/div/form/div[1]/div[1]/div/div[2]/ng-form/div[3]/div/ng-form/div[1]/div[2]/input");
    private static final By locatorCardNumber = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-card/div[1]/input");
    private static final By locatorCardType = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-card/div[2]/div/div/select");
    private static final By locatorCardMonth = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-card/div[3]/div[1]/div[1]/div/select");
    private static final By locatorCardYear = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-card/div[3]/div[1]/div[2]/div/div/select");
    private static final By locatorCardCCV = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-card/div[3]/div[2]/div[2]/input");
    private static final By locatorCardHolder = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-card/div[4]/div/input");
    private static final By locatorAddress = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[2]/div[2]/div[1]/input");
    private static final By locatorAddressTwo = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[2]/div[2]/div[2]/input");
    private static final By locatorCity = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[2]/div[2]/div[3]/div[1]/input");
    private static final By locatorCode= By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/div[2]/div[2]/div[3]/div[2]/input");
    private static final By locatorAcceptTerms= By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[6]/div/input");
    private static final By locatorAlert = By.xpath("//*[@id=\"payment-contact-form\"]/div[2]/div[4]/div/div[2]/prompt");
    private static final String baseUrl = "https://www.ryanair.com/pl/pl/booking/payment";

    public Payment() {
    }

    public static Payment naviqateTo() throws IOException {

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
        select(locatorSelectFirst, "Pan");
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
        select(locatorSelectSecond, "Pani");
        select.sendKeys(Keys.TAB);

        WebElement name = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorSecondName));

        name.sendKeys("Jane");

        WebElement surname = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorSecondLastName));

        surname.sendKeys("Smith");

    }


    public void child() {

        //TODO Hardcoded strings 3!

        WebElement name = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorChildName));

        name.sendKeys("Jordan");

        WebElement surname = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorChildLastName));

        surname.sendKeys("Smith");

    }

    //Thats how I would deal with default values

    public void contact() { contact("ryan@air.pl", "Polska", "788788788");}

    public void contact(final String emailAddress, final String country, final String phoneNumber) {

        WebElement email = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorContactEmail));

        email.sendKeys(emailAddress);

        WebElement select = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorContactCountry));

        select(locatorContactCountry, country);

        WebElement phone = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorContactPhone));

        phone.sendKeys(phoneNumber);

    }

    public void card(String number, String cardType, int month, int year, int ccv) {

        WebElement cardNumber = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorCardNumber));

        cardNumber.sendKeys(number);

        select(locatorCardType, cardType);
        select(locatorCardMonth, "" + month);
        select(locatorCardYear, "20" + year);

        WebElement ccvField = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorCardCCV));

        ccvField.sendKeys("" + ccv);

        WebElement holder = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorCardHolder));

        holder.sendKeys("John Smith");

        WebElement address = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorAddress));

        address.sendKeys("Dluga");

        WebElement addressTwo = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorAddressTwo));

        addressTwo.sendKeys("12");

        WebElement city = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorCity));

        city.sendKeys("Wroclaw");

        WebElement code = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorCode));

        code.sendKeys("55440");

        WebElement terms = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorAcceptTerms));

        terms.click();

    }

    public void cardValidationAlert(){

        WebElement alert = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorAlert));

        Assert.assertTrue("Card Validation Alert is not visible", alert.isDisplayed());

        System.out.println(alert.getText());

    }

    public void pay() throws InterruptedException {

        WebElement button = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorPay));
        button.click();

    }

}
