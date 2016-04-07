package PageObjects;

import WebDrivers.BaseWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by wysocz on 05/04/16.
 */
public class Helper {
    protected WebDriver driver;

    public Helper() {
        driver = BaseWebDriver.Instance;
    }

    protected void select(By locator, String text) {

        Select select = new Select(driver.findElement(locator));

        select.selectByVisibleText(text);

    }
}
