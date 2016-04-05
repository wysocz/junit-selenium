import WebDrivers.BaseWebDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by michalwysoczanski on 05/04/16.
 */


public class StepDefinition {

    @When("^I pay for booking with card details “(\\d+) (\\d+) (\\d+) (\\d+)”, “(\\d+)/(\\d+)” and “(\\d+)”$")
    public void iPayForBookingWithCardDetailsAnd(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should get payment declined message$")
    public void iShouldGetPaymentDeclinedMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I make a booking from \"([^\"]*)\" to \"([^\"]*)\" on (\\d+)/(\\d+)/(\\d+) for (\\d+) adults and (\\d+) child$")
    public void iMakeABookingFromToOnForAdultsAndChild(String arg0, String arg1, int arg2, int arg3, int arg4, int arg5, int arg6) throws Throwable {
        BaseWebDriver.Initialize();
        BaseWebDriver.navigate("https://www.ryanair.com/pl/pl");

        WebElement input = new WebDriverWait(BaseWebDriver.Instance, BaseWebDriver.getInstance().TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.col-departure-airport")));

        Assert.assertTrue("Not on ryanair HP, URL: " + BaseWebDriver.Instance.getCurrentUrl(), BaseWebDriver.isOnPage("https://www.ryanair.com/pl/pl/"));

        input.sendKeys(arg0);
    }
}
