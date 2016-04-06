/**
 * Created by wysocz on 05/04/16.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty","html:reports/test-report"}, features="src/test/resources",tags= "@smokeTest")
public class CucumberRunner {
}
