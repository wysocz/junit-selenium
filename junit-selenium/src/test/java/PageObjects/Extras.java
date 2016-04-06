package PageObjects;

import WebDrivers.BaseWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by wysocz on 06/04/16.
 */
public class Extras extends Homepage{

    private static final By locatorCloseBtn = By.xpath("//*[@id=\"ngdialog1\"]/div[2]/div[1]/div/div[1]/div[2]/div/dialog-title/div/div[2]");
    private static final By locatorPopup = By.xpath("//*[@id=\"ngdialog1\"]/div[2]/div[1]/div/div[1]/div[2]/div/dialog-title/div/div[1]");
    private static final By locatorContinue = By.xpath("//*[@id=\"booking-selection\"]/article/div[2]/section/div[2]/button");
    private static final String baseUrl = "https://www.ryanair.com/pl/pl/booking/extras";


    public Extras() {
    }

    public static SecondPage navigateTo() throws IOException {

        BaseWebDriver.Initialize();
        BaseWebDriver.navigate(baseUrl);
        isOnPage();

        return new SecondPage();

    }
    public static void isOnPage() {

        WebElement popup = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorPopup));

        Assert.assertTrue("Not on ryanair Booking Extras page, URL: " + BaseWebDriver.Instance.getCurrentUrl(), BaseWebDriver.isOnPage(baseUrl));


    }

    public void closePopup() {
        WebElement bg = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorCloseBtn));
        bg.click();

    }

    public Payment clickContinue() throws InterruptedException {

        //TODO get rid of this ugly wait

        Thread.sleep(2000);

        WebElement button = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locatorContinue));
        button.click();

        return new Payment();
    }

}
