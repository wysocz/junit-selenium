package PageObjects;

import WebDrivers.BaseWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by wysocz on 05/04/16.
 */
public class Helper {

    public static void select(By locator, String text) {

        Select select = new Select(BaseWebDriver.Instance.findElement(locator));

        select.selectByVisibleText(text);

    }
}
