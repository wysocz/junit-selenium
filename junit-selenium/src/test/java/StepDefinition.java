import PageObjects.Extras;
import PageObjects.Homepage;
import PageObjects.Payment;
import PageObjects.SecondPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by wysocz on 05/04/16.
 */


public class StepDefinition {

    @When("^I pay for booking with card details “(\\d+) (\\d+) (\\d+) (\\d+)”, “(\\d+)/(\\d+)” and “(\\d+)”$")
    public void iPayForBookingWithCardDetailsAnd(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) throws Throwable {

        String cardNumber = "" + arg0 + arg1 + arg2 + arg3;
        Payment payment = new Payment();
        payment.firstAdult();
        payment.secondAdult();
        payment.child();
        payment.contact();
        payment.card(cardNumber, "MasterCard", arg4, arg5, arg6);
        payment.pay();

    }

    @Then("^I should get payment declined message$")
    public void iShouldGetPaymentDeclinedMessage() throws Throwable {

        Payment payment = new Payment();
        payment.cardValidationAlert();

    }

    @Given("^I make a booking from \"([^\"]*)\" to \"([^\"]*)\" on (\\d+)/(\\d+)/(\\d+) for (\\d+) adults and (\\d+) child$")
    public void iMakeABookingFromToOnForAdultsAndChild(String arg0, String arg1, int arg2, int arg3, int arg4, int arg5, int arg6) throws Throwable {
        Homepage booking = Homepage.navigateTo();

        booking.from(arg0);
        booking.to(arg1);
        booking.oneWay();
        booking.day(arg2);
        booking.month(arg3);
        booking.year(arg4);
        booking.passengers(arg5, arg6);
        SecondPage secondPage = booking.submit();
        secondPage.isOnPage();
        secondPage.chooseOption();
        Extras extras = secondPage.clickContinue();
        extras.isOnPage();
        extras.closePopup();
        extras.clickContinue();
    }
}
