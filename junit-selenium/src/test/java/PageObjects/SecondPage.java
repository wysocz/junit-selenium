package PageObjects;

import WebDrivers.BaseWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by michalwysoczanski on 06/04/16.
 */
public class SecondPage  extends Homepage{

    private static final By locatorFirstOption = By.xpath("//*[@id=\"outbound\"]/div/div[3]/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/span[1]");
    private static final By locatorContinue = By.id("continue");
    public SecondPage() {
    }

    public static SecondPage navigateTo() throws IOException {

        BaseWebDriver.Initialize();
        BaseWebDriver.navigate("https://www.ryanair.com/pl/pl");
        isOnPage();

        return new SecondPage();

    }
    public static void isOnPage() {

        WebElement title = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#booking-selection > article > div.flight-title")));

        Assert.assertTrue("Not on ryanair Booking page, URL: " + BaseWebDriver.Instance.getCurrentUrl(), BaseWebDriver.isOnPage("https://www.ryanair.com/pl/pl/booking/home"));


    }

    public void chooseOption() {
        WebElement firstOption = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorFirstOption));
        firstOption.click();

    }

    public Extras clickContinue() throws InterruptedException {
        Thread.sleep(2000);

        WebElement button = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorContinue));
        button.click();
    return new Extras();
    }
}
