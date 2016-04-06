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
 * Created by michalwysoczanski on 05/04/16.
 */
public class Homepage extends Helper {

    public Homepage() {
    }

    public static Homepage navigateTo() throws IOException {

        BaseWebDriver.Initialize();
        BaseWebDriver.navigate("https://www.ryanair.com/pl/pl");

        WebElement input = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.col-departure-airport")));

        closeCookies();
        Assert.assertTrue("Not on ryanair HP, URL: " + BaseWebDriver.Instance.getCurrentUrl(), BaseWebDriver.isOnPage("https://www.ryanair.com/pl/pl/"));

    return new Homepage();
    }

        public static void closeCookies() {
            WebElement button = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#home > cookie-pop-up > div > core-icon > div > svg > use")));
            button.click();
        }
        public static void oneWay() {

            WebElement input = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#flight-search-type-option-one-way")));
            input.click();


        }


        public static void from(String from) {

            WebElement input = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search-container > div > div > form > div.col-flight-search-left > div.row-airports > div > div.col-departure-airport > div:nth-child(2) > div:nth-child(5) > div > div.disabled-wrap > input")));
            input.clear();
            input.sendKeys(from);
            input.sendKeys(Keys.TAB);
        }

        public static void to(String to) {

            WebElement input = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search-container > div > div > form > div.col-flight-search-left > div.row-airports > div > div.col-destination-airport > div:nth-child(2) > div:nth-child(5) > div > div.disabled-wrap > input")));
            input.clear();
            input.sendKeys(to);
            input.sendKeys(Keys.TAB);

        }

        public static void day(int day) {
            WebElement input = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"row-dates-pax\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]")));
           //Ugly hack! TODO
            String str = "" + day;

            input.sendKeys(str);
        }

    public static void month(int month) {
        WebElement input = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"row-dates-pax\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[2]")));
        input.clear();
        //Ugly hack! TODO
        String str = "" + month;
        input.sendKeys(str);
    }

    public static void year(int year) {
        WebElement input = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"row-dates-pax\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[3]")));
        input.clear();
        //Ugly hack! TODO
        String str = "" + year;
        input.sendKeys(str);
    }


    public static void passengers(int adults, int childes) {

        WebElement input = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"row-dates-pax\"]/div[2]/div[2]/div[2]/div/div[1]")));
        input.click();

        WebElement dropdown = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"row-dates-pax\"]/div[2]/div[3]/div/div/div[2]")));
        Assert.assertTrue(input.isDisplayed());

        WebElement adultsAdd = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"row-dates-pax\"]/div[2]/div[3]/div/div/div[2]/popup-content/div[6]/div/div[3]/core-inc-dec/button[2]")));


        for (int i = 1; i < adults; i++) {
            adultsAdd.click();
        }

        WebElement childesAdd = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"row-dates-pax\"]/div[2]/div[3]/div/div/div[2]/popup-content/div[8]/div/div[3]/core-inc-dec/button[2]")));

        for (int i = 0; i < childes; i++) {
            childesAdd.click();
        }


    }

    public SecondPage submit() {

        WebElement submit = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search-container > div > div > form > div.col-flight-search-right > button:nth-child(2) > span")));

        submit.click();

        return new SecondPage();

    }
}
